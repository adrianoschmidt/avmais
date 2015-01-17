package br.com.pdionline.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pdionline.entity.Organization;

@Stateless
public class SecurityService {

    @PersistenceContext
    private EntityManager em;

    public String getLoggedOrganizationName() {
    	return this.getLoggedOrganization().getName();
    }
    
    public Organization getLoggedOrganization() {
		// TODO: implementar para pegar organization do usuario logado

		List<Organization> organizations = em.createQuery("select o from Organization o").getResultList();
		
		if(organizations.isEmpty()) {
			Organization organization = new Organization();
			organization.setName("Organizacao Teste");
			this.em.persist(organization);
			this.em.flush();
			return organization;
		} else {
			return organizations.get(0);
		}
		
	}
}
