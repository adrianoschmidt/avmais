package br.com.pdionline.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public void create(User user){
		
		em.persist(user);
		
	}
}
