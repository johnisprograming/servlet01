package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// <form>태그 안에 입력된 데이터 받아오기
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookYear = request.getParameter("bookYear");
		String bookMonth = request.getParameter("bookMonth");
		String bookDate = request.getParameter("bookDate");
		String qtyNo = request.getParameter("qtyNo");
		String pubNo = request.getParameter("pubNo");
				
		
		System.out.println("도서번호: " + bookNo );
		System.out.println("도서명: " + bookName );
		System.out.println("저자: " + bookAuthor );
		System.out.println("가격: " + bookPrice );
		System.out.println("발행일: " + bookYear+"-"+ bookMonth +"-"+bookMonth);
		System.out.println("재고: " + qtyNo );
		System.out.println("출판사번호: " + pubNo );
	}

}
