package pl.tomaszp.rejestratortreningow.model;

import java.util.Date;

public class Training {

	private int trainingId;
	private Date date;
	private float distance;
	private Date time;
	private int burnCalories;
	private String comments;

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getBurnCalories() {
		return burnCalories;
	}

	public void setBurnCalories(int burnCalories) {
		this.burnCalories = burnCalories;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
