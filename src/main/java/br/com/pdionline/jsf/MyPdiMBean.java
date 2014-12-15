package br.com.pdionline.jsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pdionline.ejb.MyPdiService;
import br.com.pdionline.entity.MyPdi;

@ManagedBean
@RequestScoped
public class MyPdiMBean {

	@Inject
	private MyPdiService teamMemberBean;

	private MyPdi pdi = new MyPdi();

	public void save() throws Exception {
		teamMemberBean.save(pdi);
	}

	public MyPdi getPdi() {
		return pdi;
	}

	public void setPdi(MyPdi pdi) {
		this.pdi = pdi;
	}
}
