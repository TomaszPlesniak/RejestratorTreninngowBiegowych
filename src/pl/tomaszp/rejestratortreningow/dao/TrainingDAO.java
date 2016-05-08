package pl.tomaszp.rejestratortreningow.dao;

import java.util.List;

import pl.tomaszp.rejestratortreningow.model.Training;

public interface TrainingDAO {

	public void addTraining(Training training);

	public void updateTraining(Training training);

	public void deleteTraining(int trainingId);

	public Training getTrainingById(int trainingId);

	public List<Training> getAllTrainings();

}
