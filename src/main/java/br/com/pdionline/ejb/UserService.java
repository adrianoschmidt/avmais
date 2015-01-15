package br.com.pdionline.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		user.getEvaluated().size();
		user.getEvaluator().size();

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

			if (user.getEvaluated() != null) {
				List<User> listEvaluated = new ArrayList<User>();
				for (User evaluated : user.getEvaluated()) {
					listEvaluated.add(em.find(User.class, evaluated.getId()));
				}
				user.setEvaluated(listEvaluated);
			}

			if(user.getEvaluator() != null) {
				List<User> listEvaluator = new ArrayList<User>();
				for (User evaluator : user.getEvaluator()) {
					listEvaluator.add(em.find(User.class, evaluator.getId()));
				}
				user.setEvaluator(listEvaluator);
			}

			if(user.getId() == null)	
				em.persist(user);
			else{
				em.merge(user);
			}
		}

		
		return null;
		
	}
	
	public void delete(Long id){
		
		Query query = em.createQuery("delete from User where id = :id ");
		query.setParameter("id",id);
		
		query.executeUpdate();
		
	}
	
	
	public List<User> buscaPorNome(String query){
		
		List<User> users = new ArrayList<>();
		Query usersByName = em.createQuery("select u from User u where u.name like :query");
		usersByName.setParameter("query","%"+query+"%");
		
		users = usersByName.getResultList();
		
		return users;
		
	}
	
}
