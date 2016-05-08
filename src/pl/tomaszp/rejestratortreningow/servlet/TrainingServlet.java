package pl.tomaszp.rejestratortreningow.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.tomaszp.rejestratortreningow.dao.TrainingDAOImpl;
import pl.tomaszp.rejestratortreningow.model.Training;

/**
 * Servlet implementation class TrainingServlet
 */
@WebServlet("/TrainingServlet")
public class TrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String tRENING_EDIT = "/training.jsp";
	public static final String tRENING_LIST = "/trainingList.jsp";
	public static final String iNDEX = "/index.jsp";
	private TrainingDAOImpl trainingDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainingServlet() {
		super();
		trainingDao = new TrainingDAOImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equalsIgnoreCase("delete")) {
			int trainingId = Integer.parseInt(request.getParameter("trainingId"));
			trainingDao.deleteTraining(trainingId);
			request.setAttribute("trainings", trainingDao.getAllTrainings());
			dispatcher = request.getRequestDispatcher(tRENING_LIST);
			dispatcher.forward(request, response);
		}

		else if (action.equalsIgnoreCase("edit")) {
			int trainingId = Integer.parseInt(request.getParameter("trainingId"));
			Training training = trainingDao.getTrainingById(trainingId);
			request.setAttribute("training", training);
			dispatcher = request.getRequestDispatcher(tRENING_EDIT);
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("insert")) {
			dispatcher = request.getRequestDispatcher(tRENING_EDIT);
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("listTrainings")) {
			request.setAttribute("trainings", trainingDao.getAllTrainings());
			dispatcher = request.getRequestDispatcher(tRENING_LIST);
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher(iNDEX);
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = null;
		Date time = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date dateDB = new java.sql.Date(date.getTime());
		float distance = Float.parseFloat(request.getParameter("distance"));
		try {
			time = new SimpleDateFormat("HH:mm:ss").parse(request.getParameter("time"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Time timeDB = new java.sql.Time(time.getTime());
		int burnCalories = Integer.parseInt(request.getParameter("burnCalories"));
		String comment = request.getParameter("comment");
		String trainingId = request.getParameter("trainingId");

		Training training = new Training();
		training.setDate(dateDB);
		training.setDistance(distance);
		training.setTime(timeDB);
		training.setBurnCalories(burnCalories);
		training.setComments(comment);

		if (trainingId == null || trainingId.isEmpty())
			trainingDao.addTraining(training);
		else {
			training.setTrainingId(Integer.parseInt(trainingId));
			trainingDao.updateTraining(training);
		}

		request.setAttribute("trainings", trainingDao.getAllTrainings());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(tRENING_LIST);
		dispatcher.forward(request, response);
	}

}
