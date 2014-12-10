package org.jboss.as.quickstarts.kitchensink.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.jboss.as.quickstarts.kitchensink.model.TeamMemberPdi;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

@ManagedBean
@RequestScoped
public class PdiMBean {

	private TeamMemberPdi pdi = new TeamMemberPdi();

	public void register() throws Exception {
		System.out.println("salvou " + pdi.getName());
	}

	public TeamMemberPdi getPdi() {
		return pdi;
	}

	public void setPdi(TeamMemberPdi pdi) {
		this.pdi = pdi;
	}

	public TagCloudModel getPositivePointsSugestions() {
		TagCloudModel model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Pró-ativo", 1));
        model.addTag(new DefaultTagCloudItem("Raciocício Rápido", 2));
        model.addTag(new DefaultTagCloudItem("Trabalho em equipe", 1));
        model.addTag(new DefaultTagCloudItem("Aprende rápido", 2));
        model.addTag(new DefaultTagCloudItem("Humildade", 1));
        model.addTag(new DefaultTagCloudItem("Excelente técnico", 2));
        model.addTag(new DefaultTagCloudItem("Divertido", 1));
        model.addTag(new DefaultTagCloudItem("Assume Responsabilidades", 2));
        model.addTag(new DefaultTagCloudItem("Disciplina", 1));
        return model;
	}
	
	public TagCloudModel getPointsToImproveSugestions() {
		TagCloudModel model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Aprimoramento Técnico", 1));
        model.addTag(new DefaultTagCloudItem("Assumir mais responsabilidades", 2));
        model.addTag(new DefaultTagCloudItem("Ser mais flexível", 1));
        model.addTag(new DefaultTagCloudItem("Não ser tão expansivo", 2));
        return model;
	}
	
	public TagCloudModel getExpectativesSugestions() {
		TagCloudModel model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Mudar de cargo", 1));
        model.addTag(new DefaultTagCloudItem("Receber aumento", 2));
        model.addTag(new DefaultTagCloudItem("Poder assumir mais responsabilidades", 1));
        model.addTag(new DefaultTagCloudItem("Ser promovido", 2));
        return model;
	}
	
	public TagCloudModel getActionsSugestions() {
		TagCloudModel model = new DefaultTagCloudModel();
		model.addTag(new DefaultTagCloudItem("Tirar uma certificação", 1));
		model.addTag(new DefaultTagCloudItem("Ler um determinado livro", 2));
		model.addTag(new DefaultTagCloudItem("Fazer um curso", 1));
		return model;
	}
	
	public TagCloudModel getWhatManagerCanDoSugestions() {
		TagCloudModel model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Indicar o que estudar", 1));
        model.addTag(new DefaultTagCloudItem("Me dar mais feedbacks", 2));
        model.addTag(new DefaultTagCloudItem("Explorar meu potencial", 1));
        return model;
	}

}
