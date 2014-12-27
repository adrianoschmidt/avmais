package br.com.pdionline.jsf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pdionline.ejb.EvaluationPdiService;
import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.EvaluationPdi;
import br.com.pdionline.entity.User;

import com.mongodb.MongoException;

@ManagedBean
@RequestScoped
public class EvaluationPdiMBean {

	@Inject
	private EvaluationPdiService service;
	
	@Inject
	private UserService userService;

	private EvaluationPdi pdi = new EvaluationPdi();

	public void save() throws MongoException, IOException {
		service.save(pdi);
	}

	public EvaluationPdi getPdi() {
		return pdi;
	}

	public void setPdi(EvaluationPdi pdi) {
		this.pdi = pdi;
	}

	public List<User> getUsers() {
		return this.userService.findAll();
	}
}
