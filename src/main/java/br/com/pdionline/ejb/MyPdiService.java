package br.com.pdionline.ejb;

import java.io.IOException;

import javax.ejb.Stateless;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.facade.ICrud;

import com.mongodb.MongoException;

@Stateless
public class MyPdiService {

	private final ICrud<MyPdi> crud = ICrud.getInstance(MyPdi.class);

	public void save(MyPdi pdi) throws MongoException, IOException {
		crud.create(pdi);
	}
}
