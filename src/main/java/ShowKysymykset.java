

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Kysymys;
import dao.Dao;


/**
 * Servlet implementation class ShowKysymykset
 */
@WebServlet("/ShowKysymykset")
public class ShowKysymykset extends HttpServlet {
	private Dao dao;
	private static final long serialVersionUID = 1L;
	
    
    public ShowKysymykset() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	dao = new Dao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Kysymys> list=null;
		if (dao.getConnection()) {
			list=dao.lueKysymykset();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("kysymyslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/Kysymykset.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
