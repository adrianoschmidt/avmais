package br.com.pdionline.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * MBean onde estarao as strings de redirecionamento.
 */
@ManagedBean
@ApplicationScoped
public class NaviagationMBean {

	public String goToMyPdi() {
		return "meu-pdi.jsf";
	}

	public String goToHomeGestao() {
		return "home-gestao.jsf";
	}

}
