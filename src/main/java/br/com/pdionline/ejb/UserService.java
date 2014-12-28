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
		List<User> users = this.em.createQuery("SELECT o FROM User o").getResultList();
		return users;
	}

	public User getById(Long userEvaluatedId) {
		User user = this.em.find(User.class, userEvaluatedId);
		return user;
	}
}
