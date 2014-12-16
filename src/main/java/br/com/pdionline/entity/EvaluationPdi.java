package br.com.pdionline.entity;

import java.io.Serializable;

import org.mongojack.Id;
import org.mongojack.ObjectId;

public class EvaluationPdi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ObjectId
	protected String id;

	private User userEvaluator;
	private User userEvaluated;

	private String positivePoints;
	private String pointsToImprove;
	private String studySugestions;
	private String indications;
	private String tipsForDailyBehavior;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUserEvaluator() {
		if (userEvaluator == null) {
			userEvaluator = new User();
		}
		return userEvaluator;
	}

	public void setUserEvaluator(User userEvaluator) {
		this.userEvaluator = userEvaluator;
	}

	public User getUserEvaluated() {
		if (userEvaluated == null) {
			userEvaluated = new User();
		}
		return userEvaluated;
	}

	public void setUserEvaluated(User userEvaluated) {
		this.userEvaluated = userEvaluated;
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

	public String getStudySugestions() {
		return studySugestions;
	}

	public void setStudySugestions(String studySugestions) {
		this.studySugestions = studySugestions;
	}

	public String getIndications() {
		return indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public String getTipsForDailyBehavior() {
		return tipsForDailyBehavior;
	}

	public void setTipsForDailyBehavior(String tipsForDailyBehavior) {
		this.tipsForDailyBehavior = tipsForDailyBehavior;
	}
}
