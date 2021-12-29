package sec07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec06.MemberDAO;
import sec07.BookDAO;

/**
 * Servlet implementation class BookDeleteServlet2
 */
@WebServlet("/bookDelete2")
public class BookDeleteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		BookDAO dao = new BookDAO();
		String bookNo = request.getParameter("bookNo");
		dao.bookDelete(bookNo);
		
		// select 페이지로 포워딩
		response.sendRedirect("bookSelect2");
	}
}
