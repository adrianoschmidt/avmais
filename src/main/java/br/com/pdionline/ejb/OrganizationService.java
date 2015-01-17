package br.com.pdionline.ejb;

import java.util.List;

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

		List<Organization> organizations = em.createQuery("select o from Organization o").getResultList();
		
		if(organizations.isEmpty()) {
			Organization organization = new Organization();
			organization.setName("Supero Tecnologia");
			this.em.persist(organization);
			this.em.flush();
			return organization;
		} else {
			return organizations.get(0);
		}
		
	}
}
