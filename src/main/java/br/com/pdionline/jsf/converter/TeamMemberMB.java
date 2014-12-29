package br.com.pdionline.jsf.converter;

import br.com.pdionline.entity.User;

import javax.faces.bean.ManagedBean;

/**
 * Created by gui on 28/12/14.
 */
@ManagedBean
public class TeamMemberMB {

    private User user;

    public  void  login(){


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
