package br.com.pdionline.ejb;

import javax.ejb.Stateless;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.facade.ICrud;

import com.mongodb.BasicDBObject;

@Stateless
public class MyPdiService {

	public ICrud<MyPdi> crud = null; // FacadeCrud.getInstance("teammemberpdi");

	public MyPdi save(MyPdi pdi) {

		BasicDBObject object = new BasicDBObject();
		object.put("positivepoints", pdi.getPositivePoints());
		object.put("pointstoimprove", pdi.getPointsToImprove());
		object.put("expectatives", pdi.getNextGoals());
		object.put("actions", pdi.getActions());
		MyPdi ret = (MyPdi) crud.create(object);
		return ret;
	}
}
