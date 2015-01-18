package br.com.pdionline.jsf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pdionline.ejb.SecurityService;

@ManagedBean
@ViewScoped
public class HomeGestaoMBean {

	
	@EJB
	public SecurityService securityService;

	@PostConstruct
	private void init() {
	}
	
	private String loggedOrganizationName;
	
	public String getLoggedOrganizationName() {
		if (loggedOrganizationName == null) {
			loggedOrganizationName = this.securityService.getLoggedOrganizationName();
		}
		return loggedOrganizationName;
	}
	

}
