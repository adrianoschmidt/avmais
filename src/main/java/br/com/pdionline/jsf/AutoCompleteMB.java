package br.com.pdionline.jsf;

import br.com.pdionline.ejb.UserService;
import br.com.pdionline.entity.User;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by gui on 28/12/14.
 */
@ManagedBean
public class AutoCompleteMB {

    @Inject
    private UserService userService;
    
    private User user;


    /**
     * Lista de usuarios que podem ser inseridos na lista de avaliados ou avaliadores 
     */
    private List<User> autoCompleteUsers;


    public List<User> completeMethodUser(String query){

        return userService.buscaPorNome(query);
        
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getAutoCompleteUsers() {
        return autoCompleteUsers;
    }

    public void setAutoCompleteUsers(List<User> autoCompleteUsers) {
        this.autoCompleteUsers = autoCompleteUsers;
    }

}
