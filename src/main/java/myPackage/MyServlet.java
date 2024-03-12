package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] jokes = {
		    "Why do Java developers wear glasses? Because they don't C#!",
		    "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
		    "Why don't programmers like nature? It has too many bugs.",
		    "How many programmers does it take to change a light bulb? None, it's a hardware problem.",
		    "Why did the programmer quit his job? Because he didn't get arrays.",
		    "How do you keep a programmer in the shower forever? Give them a bottle of shampoo with the instructions: Lather. Rinse. Repeat.",
		    "Why do programmers always mix up Halloween and Christmas? Because Oct 31 == Dec 25.",
		    "Why did the programmer go broke? Because he used up all his cache.",
		    "Why did the JavaScript developer leave? Because they didn't get enough events.",
		    "Why did the developer go broke? Too many console logs."
		};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		String str3 = request.getParameter("bt1");
		
		// These values are in the String format. Type-cast to int
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		int ans;
		if(str3.equals("1")) ans = num1 + num2;
		else if(str3.equals("2")) ans = num1 - num2;
		else if(str3.equals("3")) ans = num1 * num2;
		else ans = num1 / num2;
		
		int randomIndex = (int) (Math.random() * jokes.length);
		String randomJoke = jokes[randomIndex];
		
		//response.getWriter().append("Ans =  " + ans);
		//Redirect this to the JSP page.
		response.sendRedirect("ResultPage.jsp?ans=" + ans + "&joke=" + randomJoke);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
