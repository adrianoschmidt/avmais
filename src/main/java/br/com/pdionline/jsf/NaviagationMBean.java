package br.com.pdionline.jsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 * MBean onde estarao as strings de redirecionamento.
 */
@ManagedBean
@RequestScoped
public class NaviagationMBean {

	public String goToMyPdi() {
		return "meu-pdi.jsf";
	}

}
