package br.com.pdionline.ejb;

import java.io.IOException;

import javax.ejb.Stateless;

import br.com.pdionline.entity.EvaluationPdi;
import br.com.pdionline.facade.ICrud;

import com.mongodb.MongoException;

@Stateless
public class EvaluationPdiService {

	private final ICrud<EvaluationPdi> crud = ICrud.getInstance(EvaluationPdi.class);

	public void save(EvaluationPdi pdi) throws MongoException, IOException {
		crud.create(pdi);
	}
}
