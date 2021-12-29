package sec08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet07
 */
@WebServlet("/first07")
public class FirstServlet07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "서울시 강남구");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second07");
		dispatch.forward(request, response);
	}

}
