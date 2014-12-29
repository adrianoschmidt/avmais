package br.com.pdionline.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.pdionline.ejb.MyPdiService;
import br.com.pdionline.entity.MyPdi;

@ManagedBean
@RequestScoped
public class MyPdiMBean {

	@Inject
	private MyPdiService myPdiService;

	private MyPdi pdi = new MyPdi();

	public String save() {
		String errors = myPdiService.save(pdi);
		if (errors != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(errors));
			return null;
		}

		return "meu-pdi-respondido.jsf";
	}

	public MyPdi getPdi() {
		return pdi;
	}

	public void setPdi(MyPdi pdi) {
		this.pdi = pdi;
	}

}
