package br.com.pdionline.jsf;

import br.com.pdionline.ejb.MyBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * Created by supero on 06/12/2014.
 */
@ManagedBean
@ViewScoped
public class MBean {

    private String texto;

    @Inject
    private MyBean myBean;

    @PostConstruct
    public void init(){
        System.out.println("aqui");
    }

    public void acao(){


        System.out.println("aqui");
        myBean.metodo();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
