package sec08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet03
 */
@WebServlet("/first03")
public class FirstServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// location을 이용한 포워딩
	// 자바스크립트의 location 객체 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<script type='text/javascript'>");
		out.println("location.href='second03';");
		out.println("</script>");
	}

}
