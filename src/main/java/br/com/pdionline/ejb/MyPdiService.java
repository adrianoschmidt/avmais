package br.com.pdionline.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.pdionline.entity.MyPdi;
import br.com.pdionline.entity.Organization;

@Stateless
public class MyPdiService {

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private OrganizationService organizationService;
    
	public String save(MyPdi pdi) {
		String email = pdi.getUser().getEmail();
		boolean existsMyPdiWithEmail = this.checkIfExistsMyPdiWithEmail(email);
		
		if (existsMyPdiWithEmail) {
			return "Esse questionário já foi respondido para o e-mail digitado. Em caso de dúvidas consulte o RH.";
		}
		
		Organization organization = this.organizationService.getLoggedOrganization();
		pdi.getUser().setOrganization(organization);

		this.em.persist(pdi);
		
		return null;
	}

	/**
	 * Verifica se existe um registo na tabela MyPdi para o email passado como parametro
	 * @return false se nao existe e true se existe 
	 */
	public boolean checkIfExistsMyPdiWithEmail(String email) {
		Query query = this.em.createQuery("SELECT count(o) FROM MyPdi o WHERE o.user.email = :email");
		query.setParameter("email", email);
		Object count = query.getSingleResult();
		
		if (count.equals(0L)) {
			return false;
		} else {
			return true;
		}
	}
}
