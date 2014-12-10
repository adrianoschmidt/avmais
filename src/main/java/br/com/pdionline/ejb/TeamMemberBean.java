package br.com.pdionline.ejb;

import br.com.pdionline.entity.TeamMemberPdi;
import br.com.pdionline.facade.FacadeCrud;
import br.com.pdionline.facade.ICrud;

import com.mongodb.BasicDBObject;

import javax.ejb.Stateless;

/**
 * Created by supero on 06/12/2014.
 */
@Stateless
public class TeamMemberBean {

    public ICrud<TeamMemberPdi> crud = null; //FacadeCrud.getInstance("teammemberpdi");

    public TeamMemberPdi create(TeamMemberPdi pdi) {

        BasicDBObject object = new BasicDBObject();
        object.put("nome",pdi.getName());
        object.put("nome",pdi.getName());
        object.put("actions",pdi.getActions());
        object.put("expectatives",pdi.getExpectatives());
        object.put("passconfirmation",pdi.getPasswordConfirmation());
        object.put("pointstoimprove",pdi.getPointsToImprove());
        object.put("positivepoints",pdi.getPositivePoints());
        TeamMemberPdi ret = (TeamMemberPdi) crud.create(object);
        return ret;
    }
}
