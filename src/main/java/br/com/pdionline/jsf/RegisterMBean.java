package br.com.pdionline.jsf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.Organization;
import br.com.pdionline.entity.User;

@ManagedBean
@RequestScoped
public class RegisterMBean {

	public User user;
	
	@EJB
	public UserService userService;

	@PostConstruct
	private void init() {
		this.user = new User();
		this.user.setOrganization(new Organization());
	}
	
	public void save() {
		this.userService.create(user);
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
