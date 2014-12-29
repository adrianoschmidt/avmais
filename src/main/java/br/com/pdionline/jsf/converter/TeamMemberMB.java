package br.com.pdionline.jsf.converter;

import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.User;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 * Created by gui on 28/12/14.
 */
@ManagedBean
public class TeamMemberMB {

    @Inject
    private UserService userService;
    
    private User user = new User();

    public  void  save(){

        userService.create(user);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
