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
				"or o.name = :nome ")
				.setParameter("email",user.getEmail())
				.setParameter("nome",user.getName())
				.getSingleResult();
		
		

		if(jaExiste){
			return "Usuário já existe";
		}else{
			em.persist(user);
		}

		
		return null;
		
	}
	
	public List<User> buscaPorNome(String query){
		
		List<User> users = new ArrayList<>();
		Query usersByName = em.createQuery("select u from User u where u.name like :query");
		usersByName.setParameter("query","%"+query+"%");
		
		users = usersByName.getResultList();
		
		return users;
		
	}
	
}
