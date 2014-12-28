package br.com.pdionline.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pdionline.entity.Organization;

@Stateless
public class OrganizationService {

    @PersistenceContext
    private EntityManager em;

	public Organization getLoggedOrganization() {
		// TODO: implementar para pegar organization do usuario logado
		// retorna sempre a organization Supero Tecnologia que tem o id 1

		Organization organization = em.find(Organization.class, 1L);
		
		if (organization == null) {
			organization = new Organization();
			organization.setId(1L);
			organization.setName("Supero Tecnologia");
			this.em.persist(organization);
		}
		
		return organization;
	}
}
