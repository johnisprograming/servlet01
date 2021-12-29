package sec08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet05
 */
@WebServlet("/second05")
public class SecondServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// url  뒤에 붙어서 전송된 데이터 받기 : "second05?name=lee"
		String name = request.getParameter("name");
		
		out.println("<html><body>");
		out.println("이름 : " + name);
		out.println("<br> dispatch 이용한 포워딩");
		out.println("</body></html>");
	}

}
