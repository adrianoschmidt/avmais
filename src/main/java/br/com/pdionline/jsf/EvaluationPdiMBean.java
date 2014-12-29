package br.com.pdionline.jsf;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pdionline.ejb.EvaluationPdiService;
import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.EvaluationPdi;
import br.com.pdionline.entity.User;

@ManagedBean
@RequestScoped
public class EvaluationPdiMBean {

	@Inject
	private EvaluationPdiService evaluationPdiService;
	
	@Inject
	private UserService userService;

	private EvaluationPdi pdi = new EvaluationPdi();

<<<<<<< HEAD
	public void save() throws MongoException, IOException {
		evaluationPdiService.save(pdi);
=======
	public void save() {
		service.save(pdi);
>>>>>>> 5248238bbccd3bda707c42b387b44c37102884b1
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
