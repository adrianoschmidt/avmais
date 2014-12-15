package br.com.pdionline.ejb;

import javax.ejb.Stateless;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.facade.FacadeCrud;
import br.com.pdionline.facade.ICrud;

import br.com.pdionline.mongo.MongoConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.mongojack.JacksonDBCollection;

import java.io.IOException;

@Stateless
public class MyPdiService {

	private final DB db = MongoConnection.getDB();

	private final DBCollection collection = db.getCollection(MyPdi.class.getSimpleName());

	private final JacksonDBCollection<MyPdi, String> jacksonDB =
			JacksonDBCollection.wrap(collection, MyPdi.class, String.class);

	private final ICrud<MyPdi> crud = new FacadeCrud<>(jacksonDB);

	public MyPdi save(MyPdi pdi) {

		try {
			return crud.create(pdi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
