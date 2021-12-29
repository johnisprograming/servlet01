package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookSelect2")
public class BookSelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// 서버 결과 ---> 클라이언트에게 전송 : 응답 response
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) 요청 받음
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// (2) 비즈니스 로직 처리 : DAO 호출하고 결과 받아옴
		BookDAO dao = new BookDAO();
		
		ArrayList<BookVO> bookList = dao.bookSelect();
		
		// (3) 응답 처리 : 클라이언트에게 결과 전송
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>도서번호</td><td>도서명</td><td>저자</td>"
				+ "<td>도서가격</td><td>발행일</td><td>출판사번호</td></tr>");
		
		for(int i = 0 ; i < bookList.size() ; i++) {
			BookVO vo = (BookVO) bookList.get(i);
			String no = vo.getNo();
			String name = vo.getName();
			String author = vo.getAuthor();
			int price = vo.getPrice();
			String date = vo.getDate();
			String pubNo = vo.getPubNo();
			
			// 한 행씩 출력
			out.print("<tr><td>" + no + "</td><td>" + name + "</td><td>" +
													author + "</td><td>" + price + "</td><td>" +
													date + "</td><td>" + pubNo + "</td><td>" +
													"<a href='/Servlet01/bookDelete?no=" + no + "'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
	}
	
}