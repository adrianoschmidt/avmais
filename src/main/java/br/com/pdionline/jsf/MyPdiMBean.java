package br.com.pdionline.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
		myPdiService.save(pdi);
		return "meu-pdi-respondido.jsf";
	}

	public MyPdi getPdi() {
		return pdi;
	}

	public void setPdi(MyPdi pdi) {
		this.pdi = pdi;
	}

}
