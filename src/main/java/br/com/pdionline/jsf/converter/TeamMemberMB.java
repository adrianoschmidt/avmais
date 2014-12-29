package br.com.pdionline.jsf.converter;

import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.User;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gui on 28/12/14.
 */
@ManagedBean
public class TeamMemberMB {

    @Inject
    private UserService userService;
    
    private User user = new User();
    
    private DashboardModel model;
    
    private List<User> autoCompleteUsers;

    public  String  save(){

        String errors = userService.create(user);
        if (errors != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(errors));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário adicionado com sucesso."));
        return null;

    }
    


    public List<User> completMethodUser(String query){

        return userService.buscaPorNome(query);
        
    }
    /* GETTERS N SETTERS*/
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DashboardModel getModel() {
        return model;
    }

    public void setModel(DashboardModel model) {
        this.model = model;
    }

    public List<User> getAutoCompleteUsers() {
        return autoCompleteUsers;
    }

    public void setAutoCompleteUsers(List<User> autoCompleteUsers) {
        this.autoCompleteUsers = autoCompleteUsers;
    }
}
