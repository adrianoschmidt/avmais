package br.com.pdionline.ejb;

import javax.ejb.Stateless;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.facade.FacadeCrud;
import br.com.pdionline.facade.ICrud;

import com.mongodb.BasicDBObject;

@Stateless
public class MyPdiService {

	private final ICrud<MyPdi> crud = FacadeCrud.getInstance("mypdi");

	public MyPdi save(MyPdi pdi) {

		BasicDBObject object = new BasicDBObject();
		object.put("positivePoints", pdi.getPositivePoints());
		object.put("pointsToImprove", pdi.getPointsToImprove());
		object.put("nextGoals", pdi.getNextGoals());
		object.put("actions", pdi.getActions());
		object.put("whatManagerCanDo", pdi.getWhatManagerCanDo());

		BasicDBObject user = new BasicDBObject();

		user.put("email", pdi.getUser().getEmail());
		user.put("name", pdi.getUser().getName());
		object.put("user",user);

		MyPdi ret = (MyPdi) crud.create(object);
		return ret;
	}
}
