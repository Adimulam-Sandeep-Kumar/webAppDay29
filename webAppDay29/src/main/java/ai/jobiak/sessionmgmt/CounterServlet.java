package ai.jobiak.sessionmgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet(description = "Demonstrates Http Session", urlPatterns = { "/count" })
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		int counter = 1;
		
		if(session.isNew()) {
					
			session.setAttribute("visits", counter+"");	//1.the user identity or token or 2. it could be the shopping cart
					
		}else {
			
			String counterStr = (String)session.getAttribute("visits");
			counter = Integer.parseInt(counterStr);
			counter++;
			session.setAttribute("visits", counter+"");
			
		}
		
		response.setContentType("text/html");
		out.println("<h3>You Visited # "+counter);
		out.println("<h3>SessionID"+session.getId());
		out.println("<h3>SessionMaxInterval"+session.getMaxInactiveInterval());
		out.println("<h3>Last Access Time"+session.getLastAccessedTime());	
		out.println("<h3><a href='out'>Signout</a>");
		
	}

}
