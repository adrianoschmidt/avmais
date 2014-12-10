package org.jboss.as.quickstarts.kitchensink.controller;

import br.com.pdionline.ejb.TeamMemberBean;
import org.jboss.as.quickstarts.kitchensink.model.TeamMemberPdi;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PdiMBean {

	@Inject
	private TeamMemberBean teamMemberBean;

	private TeamMemberPdi pdi = new TeamMemberPdi();

	public void register() throws Exception {
		System.out.println("salvou " + pdi.getName());

		teamMemberBean.create(pdi);
	}

	public List<TeamMemberPdi> list(){

		List<TeamMemberPdi> list = new ArrayList<>();
		list = teamMemberBean.crud.findAll();

		return list;
	}

	public TeamMemberPdi getPdi() {
		return pdi;
	}

	public void setPdi(TeamMemberPdi pdi) {
		this.pdi = pdi;
	}

}
