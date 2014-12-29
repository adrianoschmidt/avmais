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
<<<<<<< HEAD

		return em.createQuery("SELECT o FROM User o").getResultList();

=======
		List<User> users = this.em.createQuery("SELECT o FROM User o").getResultList();
		return users;
>>>>>>> 5248238bbccd3bda707c42b387b44c37102884b1
	}

	public User getById(Long userEvaluatedId) {

		return em.find(User.class, userEvaluatedId);

	}
}
