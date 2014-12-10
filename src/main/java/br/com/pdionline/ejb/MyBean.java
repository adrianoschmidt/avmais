package br.com.pdionline.ejb;

import br.com.pdionline.facade.FacadeCrud;
import br.com.pdionline.facade.ICrud;

import javax.ejb.Stateless;

/**
 * Created by supero on 06/12/2014.
 */
@Stateless
public class MyBean {

    private ICrud crud = new FacadeCrud();

    public void metodo(){

        System.out.println( "asdj");
    }
}
