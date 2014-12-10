package br.com.pdionline.ejb;

import br.com.pdionline.facade.FacadeCrud;
import br.com.pdionline.facade.ICrud;
import com.mongodb.BasicDBObject;
import org.jboss.as.quickstarts.kitchensink.model.TeamMemberPdi;

import javax.ejb.Stateless;

/**
 * Created by supero on 06/12/2014.
 */
@Stateless
public class TeamMemberBean {

    private static ICrud<TeamMemberPdi> crud = FacadeCrud.getInstance("teammemberpdi");

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
