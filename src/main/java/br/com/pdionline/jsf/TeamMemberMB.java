package br.com.pdionline.jsf;

import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.User;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gui on 28/12/14.
 */
@ManagedBean
@ViewScoped
public class TeamMemberMB {

    @Inject
    private UserService userService;
    
    private User user;
    
    private List<User> userList;


    @PostConstruct
    public void init(){

        userList = userService.findAll();

    }


    public  String  save(){

        String errors = userService.create(user);
        if (errors != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(errors));
            return null;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário salvo com sucesso."));
        
        user = new User();
        init();
        
        return null;

    }
    
    public void edit(Long id){
        
        user = userService.getById(id);

    }

    public void delete(Long id){

        userService.delete(id);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário removido com sucesso."));
        
        init();
        
    }



    public User getUser() {
        if(user == null) user = new User();
        //if(user.getEvaluator().contains(user)) user.getEvaluator().remove(user);
        //if(user.getEvaluator().contains(user)) user.getEvaluator().remove(user);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
