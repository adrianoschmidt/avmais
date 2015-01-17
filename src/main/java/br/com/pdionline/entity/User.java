package br.com.pdionline.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import javax.persistence.*;

import br.com.pdionline.enumeration.ProfileEnum;

@Entity
@Table(name="AVM_USER")
public class User implements Serializable {
	
	/* CONSTANTS */
	private static final long serialVersionUID = 1L;
	
	
	/* FIELDS */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Organization organization;

	@JoinTable(name = "evaluationrelationship", 
			joinColumns = {
				@JoinColumn(name = "avaliado_id", referencedColumnName = "id", nullable = false)},
			inverseJoinColumns = {
				@JoinColumn(name = "avaliador_id", referencedColumnName = "id", nullable = false)})
	@ManyToMany(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<User> evaluatorList;


	@JoinTable(name = "evaluationrelationship",
			joinColumns = {
					@JoinColumn(name = "avaliador_id", referencedColumnName = "id", nullable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "avaliado_id", referencedColumnName = "id", nullable = false)})
	@ManyToMany(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<User> evaluatedList;
	
	private String email;
	private String name;
	private String password;
	private ProfileEnum profile;
	
	
	/* METHODS */
	
	
	/* OVERRIDEN METHODS */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	/* GETTERS N SETTERS */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getEvaluatorList() {
		return evaluatorList;
	}

	public void setEvaluatorList(List<User> evaluatorList) {
		this.evaluatorList = evaluatorList;
	}

	public List<User> getEvaluatedList() {
		return evaluatedList;
	}

	public void setEvaluatedList(List<User> evaluatedList) {
		this.evaluatedList = evaluatedList;
	}
	
	public ProfileEnum getProfile() {
		return profile;
	}
	
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
}
