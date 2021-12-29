package sec07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bookInsert2")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// 클라이언트 --> 서버 : 요청 
	// 요청이 오는 것은 request 객체가 받음
	// 서버 결과 ---> 클라이언트에게 전송 : 응답 response
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청받으면서 데이터 전달 받음
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("book_no");
		String name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String pubNo = request.getParameter("pubNo");
		System.out.println("ㅇㅇ"+no);
		
		// MemberVO에 저장
		BookVO vo = new BookVO();
		vo.setNo(no);
		vo.setName(name);
		vo.setAuthor(author);
		vo.setPrice(Integer.parseInt(price));
		vo.setDate(date);
		vo.setPubNo(pubNo);
		
		
		// 또는
		// MemberVO vo = new MemberVO(id,pwd,name,email);
		
		// 회원 정보 등록 : memberInsert() 호출 => DB에 저장
		BookDAO dao = new BookDAO();
		dao.bookInsert(vo);
		
		// select 결과 페이지로 포워딩 : 서버 --> 클라이언트
		response.sendRedirect("bookSelect2");
	}

}