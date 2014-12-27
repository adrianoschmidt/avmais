package br.com.pdionline.ejb;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pdionline.entity.MyPdi;

import com.mongodb.MongoException;

@Stateless
public class MyPdiService {

    @PersistenceContext
    private EntityManager em;

	public void save(MyPdi pdi) throws MongoException, IOException {
		em.persist(pdi);
	}
}
