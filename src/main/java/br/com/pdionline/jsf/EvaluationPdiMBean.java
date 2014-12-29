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
	
	public void save(){
		
		evaluationPdiService.save(pdi);

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
