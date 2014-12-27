package br.com.pdionline.jsf;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pdionline.ejb.GeneratePdiService;
import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.Pdi;
import br.com.pdionline.entity.User;

@ManagedBean
@RequestScoped
public class GeneratePdiMBean {

	@Inject
	private GeneratePdiService service;
	
	@Inject
	private UserService userService;

	private Pdi pdi = new Pdi();

	public void save() throws Exception {
		service.save(pdi);
	}

	public Pdi getPdi() {
		return pdi;
	}

	public void setPdi(Pdi pdi) {
		this.pdi = pdi;
	}

	public List<User> getUsers() {

		return this.userService.findAll();

	}
}
