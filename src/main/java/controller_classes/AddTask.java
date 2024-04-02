package controller_classes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_classes.Dao;
import dto_classes.Task;
import dto_classes.User;

@WebServlet("/addtask")
public class AddTask extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskid = Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdescription = req.getParameter("taskdescription");
		String taskpriority = req.getParameter("taskpriority");
		String taskduedate = req.getParameter("taskduedate");
		
		User u = (User) req.getSession().getAttribute("user");
		int userid = u.getUserid();
		
		Task task = new Task(taskid, tasktitle, taskdescription, taskpriority, taskduedate, taskduedate, userid);
		
		Dao dao = new Dao();
		try {
			int res = dao.createTask(task);
			if(res>0) {
				resp.getWriter().println("Task added successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

