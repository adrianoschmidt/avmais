package br.com.pdionline.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.pdionline.entity.User;

@Stateless
public class UserService {

	public List<User> findUsers() {

		List<User> users = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1L);
		user1.setName("Carlos Silva Fernandes");
		users.add(user1);

		User user2 = new User();
		user2.setId(2L);
		user2.setName("José Silveira Duffeck");
		users.add(user2);

		User user3 = new User();
		user3.setId(3L);
		user3.setName("Marcio Pereira Rosa");
		users.add(user3);

		User user4 = new User();
		user4.setId(4L);
		user4.setName("Manoella Assis Garcez");
		users.add(user4);

		return users;

	}
}
