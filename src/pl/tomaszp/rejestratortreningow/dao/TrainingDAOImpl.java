package pl.tomaszp.rejestratortreningow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.tomaszp.rejestratortreningow.model.Training;
import pl.tomaszp.rejestratortreningow.util.DatabaseUtil;

public class TrainingDAOImpl implements TrainingDAO {

	private Connection con;

	public TrainingDAOImpl() {
		con = DatabaseUtil.getConnection();
	}

	@Override
	public void addTraining(Training training) {
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into Training(date,distance,time, kcal,comment) values (?,?,?,?,?)");
			ps.setString(1, training.getDate().toString());
			ps.setFloat(2, training.getDistance());
			ps.setString(3, training.getTime().toString());
			ps.setInt(4, training.getBurnCalories());
			ps.setString(5, training.getComments());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection problem occurred");
		}

	}

	@Override
	public void updateTraining(Training training) {
		try {
			PreparedStatement ps = con
					.prepareStatement("update Training set date=?, distance=?, time=?, kcal=?,comment=? where id=?");
			ps.setString(1, training.getDate().toString());
			ps.setFloat(2, training.getDistance());
			ps.setString(3, training.getTime().toString());
			ps.setInt(4, training.getBurnCalories());
			ps.setString(5, training.getComments());
			ps.setInt(6, training.getTrainingId());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTraining(int trainingId) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from Training where id=? ");
			ps.setLong(1, trainingId);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Training getTrainingById(int trainingId) {
		Training training = new Training();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Training where id=? ");
			ps.setInt(1, trainingId);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				training.setTrainingId(resultSet.getInt("id"));
				training.setDate(resultSet.getDate("date"));
				training.setDistance(resultSet.getFloat("distance"));
				training.setTime(resultSet.getTime("time"));
				training.setBurnCalories(resultSet.getInt("kcal"));
				training.setComments(resultSet.getString("comment"));
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return training;
	}

	@Override
	public List<Training> getAllTrainings() {
		List<Training> trainings = new ArrayList<Training>();
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Training");
			while (resultSet.next()) {
				Training training = new Training();
				training.setTrainingId(resultSet.getInt("id"));
				training.setDate(resultSet.getDate("date"));
				training.setDistance(resultSet.getFloat("distance"));
				training.setTime(resultSet.getTime("time"));
				training.setBurnCalories(resultSet.getInt("kcal"));
				training.setComments(resultSet.getString("comment"));
				trainings.add(training);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainings;
	}

}
