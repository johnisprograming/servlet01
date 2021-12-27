package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewMemberServlet2
 */
@WebServlet("/newMember2")
public class NewMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String hp1 = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String year = request.getParameter("year");
		
		String[] interest = request.getParameterValues("interest");
		String department = request.getParameter("department");
		
		// 응답 처리
		// 서버 -> 클라이언트로 setContentType
		response.setContentType("text/html;charset=utf-8");
		
		// 서버에서 클라이언트로 데이터 전송에 자바 I/O 스트림을 이용
		PrintWriter out = response.getWriter();
		
		// HTML 문서 형식으로 데이터 전송
		out.println("<html><head></head><body>");
		out.println("성명 : " + name + "<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("비밀번호 : " + pwd + "<br>");
		out.println("휴대폰 번호 : " + hp1 + "-" + hp2 + "-" + hp3 + "<br>");
		out.println("출생연도 : " + year + "<br>");
		for(String itr : interest) {
			out.print("관심분야 : " + itr + "<br>");
		}
		out.println("학과 : " + department + "<br>");
		out.println("</body></html>");
	}

}