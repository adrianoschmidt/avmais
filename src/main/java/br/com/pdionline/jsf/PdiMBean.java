package br.com.pdionline.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pdionline.ejb.TeamMemberBean;
import br.com.pdionline.entity.TeamMemberPdi;

@ManagedBean
@RequestScoped
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

	public List<String> getTeamMembers() {
		List<String> members = new ArrayList<String>();
		members.add("Carlos Silva");
		members.add("José Silveira");
		members.add("Luiz Carlos Schmoekel");
		members.add("Manuela Assiz Garcez");
		return members;
	}
}
