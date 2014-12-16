package br.com.pdionline.ejb;

import java.io.IOException;

import javax.ejb.Stateless;

import br.com.pdionline.entity.Pdi;
import br.com.pdionline.facade.ICrud;

import com.mongodb.MongoException;

@Stateless
public class GeneratePdiService {

	private final ICrud<Pdi> crud = ICrud.getInstance(Pdi.class);

	public void save(Pdi pdi) throws MongoException, IOException {
		crud.create(pdi);
	}
}
