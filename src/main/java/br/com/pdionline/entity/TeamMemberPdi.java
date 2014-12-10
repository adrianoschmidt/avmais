package br.com.pdionline.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TeamMemberPdi implements Serializable {

	private String name;
	private String password;
	private String passwordConfirmation;
	private String positivePoints;
	private String pointsToImprove;
	private String expectatives;
	private String actions;
	private String whatManagerCanDo;

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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getPositivePoints() {
		return positivePoints;
	}

	public void setPositivePoints(String positivePoints) {
		this.positivePoints = positivePoints;
	}

	public String getPointsToImprove() {
		return pointsToImprove;
	}

	public void setPointsToImprove(String pointsToImprove) {
		this.pointsToImprove = pointsToImprove;
	}

	public String getExpectatives() {
		return expectatives;
	}

	public void setExpectatives(String expectatives) {
		this.expectatives = expectatives;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getWhatManagerCanDo() {
		return whatManagerCanDo;
	}

	public void setWhatManagerCanDo(String whatManagerCanDo) {
		this.whatManagerCanDo = whatManagerCanDo;
	}

}
