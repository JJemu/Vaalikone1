

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import Calculator.answerCalc;

/**
 * Servlet implementation class ShowResults
 */
@WebServlet("/ShowResults")
public class ShowResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	private answerCalc calc;
       
	
	public void init() {
		dao = new Dao();
		dao.getConnection();
		calc = new answerCalc();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int i = 0;
		//out.println(request.getParameter("vastaus1"));
		ArrayList <Integer> answerList = new ArrayList <>();
		while(request.getParameter("vastaus"+i)!= null) {
			answerList.add(Integer.parseInt(request.getParameter("vastaus"+i)));
			i++;
		}
		
		out.println(calc.matchCandidates(answerList));
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
