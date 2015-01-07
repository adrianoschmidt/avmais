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

		return em.find(User.class, userEvaluatedId);

	}
	
	public String create(User user){

		boolean jaExiste = false;

		Object object = em.createQuery("" +
				"select count(o.id) " +
				"from User o " +
				"where o.email = :email " +
				"and o.name = :nome ")
				.setParameter("email",user.getEmail())
				.setParameter("nome",user.getName())
				.getSingleResult();
		
		jaExiste = (Long) object > 0;

		if(jaExiste){
			return "Usuário já existe";
		}else{
/*
			user.setEvaluated(null);
			user.setEvaluator(null);
			em.persist(user);
			em.flush();
*/
			if(user.getEvaluated() != null) {

				User evaluated = em.find(User.class, user.getEvaluated().get(0).getId());
				User evaluator = em.find(User.class, user.getEvaluator().get(0).getId());

				List<User> listEvaluated = new ArrayList<User>();
				listEvaluated.add(evaluated);

				List<User> listEvaluator = new ArrayList<User>();
				listEvaluator.add(evaluator);

				user.setEvaluated(listEvaluated);
				user.setEvaluator(listEvaluator);
			}
				
			em.persist(user);
		}

		
		return null;
		
	}

	public User update(User user){

		return em.merge(user);

	}
	
	public List<User> buscaPorNome(String query){
		
		List<User> users = new ArrayList<>();
		Query usersByName = em.createQuery("select u from User u where u.name like :query");
		usersByName.setParameter("query","%"+query+"%");
		
		users = usersByName.getResultList();
		
		return users;
		
	}
	
}
