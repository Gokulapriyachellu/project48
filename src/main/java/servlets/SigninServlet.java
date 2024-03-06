package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.SigninModel;
import models.SignupModel;

import java.io.IOException;

import controllers.SigninController;


/**
 * Servlet implementation class SigninServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SigninModel sn =new SigninModel();
	    sn.setName(request.getParameter("username"));
	    sn.setPass(request.getParameter("password"));
	    System.out.println(sn.getName()+sn.getPass());
	   //System.out.println(name+pass+email+phoneno);
	    SigninController sc = new SigninController(sn);
	    sc.toGet();
	    if(sc.toGet()) {
		    response.sendRedirect("Welcome.html");

	    }else {
			response.getWriter().append("Login error");

	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
