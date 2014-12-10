package org.jboss.as.quickstarts.kitchensink.controller;

import br.com.pdionline.ejb.TeamMemberBean;
import org.jboss.as.quickstarts.kitchensink.model.TeamMemberPdi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class PdiMBean {

	@Inject
	private TeamMemberBean TeamMemberBean;

	private TeamMemberPdi pdi = new TeamMemberPdi();

	public void register() throws Exception {
		System.out.println("salvou " + pdi.getName());

		TeamMemberBean.create(pdi);
	}

	public TeamMemberPdi getPdi() {
		return pdi;
	}

	public void setPdi(TeamMemberPdi pdi) {
		this.pdi = pdi;
	}

}
