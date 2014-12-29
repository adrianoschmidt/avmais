package br.com.pdionline.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pdionline.entity.Pdi;
import br.com.pdionline.entity.User;

@Stateless
public class GeneratePdiService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private UserService userService;

	public void save(Pdi pdi) {
		// resolvendo: detached entity passed to persist
		// FIXME: Resolver com flush ou alguma solucao mais elegante
		Long userEvaluatedId = pdi.getUserEvaluated().getId();
		User userEvaluated = userService.getById(userEvaluatedId);
		pdi.setUserEvaluated(userEvaluated);

		em.persist(pdi);
	}
}
