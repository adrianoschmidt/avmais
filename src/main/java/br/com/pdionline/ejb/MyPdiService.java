package br.com.pdionline.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.entity.User;

import com.mongodb.BasicDBObject;

@Stateless
public class MyPdiService {

	@PersistenceContext
	private EntityManager em;

	public void save(MyPdi pdi) {

		User user = new User();
		user.setEmail("aa");
		user.setName("dsss");
		user.setPassword("sss");

		try {
			this.em.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
