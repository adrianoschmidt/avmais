package br.com.pdionline.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.pdionline.entity.Organization;
import br.com.pdionline.entity.User;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager em;

	public List<User> findAll() {

		return em.createQuery("SELECT o FROM User o").getResultList();

	}

	public User getById(Long userEvaluatedId) {

		User user = em.find(User.class, userEvaluatedId);
		user.getEvaluatedList().size();
		user.getEvaluatorList().size();

		return user;

	}
	
	public String create(User user){
		
		boolean jaExiste = false;

		Object object = em.createQuery("select count(o.id) from User o where o.email = :email and o.name = :nome ")
				.setParameter("email",user.getEmail())
				.setParameter("nome",user.getName())
				.getSingleResult();
		
		jaExiste = (Long) object > 0;

		if(jaExiste && user.getId() == null){
			return "Usuário já existe";
		}else{

			if (user.getEvaluatedList() != null) {
				List<User> listEvaluated = new ArrayList<User>();
				for (User evaluated : user.getEvaluatedList()) {
					listEvaluated.add(em.find(User.class, evaluated.getId()));
				}
				user.setEvaluatedList(listEvaluated);
			}

			if(user.getEvaluatorList() != null) {
				List<User> listEvaluator = new ArrayList<User>();
				for (User evaluator : user.getEvaluatorList()) {
					listEvaluator.add(em.find(User.class, evaluator.getId()));
				}
				user.setEvaluatorList(listEvaluator);
			}

			if(user.getId() == null)	
				em.persist(user);
			else{
				// para evitar o erro: java.lang.IllegalStateException: Multiple representations of the same entity [br.com.pdionline.entity.Organization#1] are being merged. Detached: [br.com.pdionline.entity.Organization@49d71099]; Managed: [br.com.pdionline.entity.Organization@7b13717f]
				user.setOrganization(this.em.find(Organization.class, user.getOrganization().getId()));

				em.merge(user);
			}
		}

		
		return null;
		
	}
	
	public String delete(Long id){

		Query query = em.createQuery("delete from User where id = :id ");
		query.setParameter("id",id);
		
		try{
			query.executeUpdate();
			return "Colaborador removido com sucesso.";
		}catch(Exception e){
			e.printStackTrace();
			return "Colaborador não pode ser removido.";
			
		}

		
	}
	
	
	public List<User> buscaPorNome(String query){
		
		List<User> users = new ArrayList<>();
		Query usersByName = em.createQuery("select u from User u where u.name like :query");
		usersByName.setParameter("query","%"+query+"%");
		
		users = usersByName.getResultList();
		
		return users;
		
	}
	
}
