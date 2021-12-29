package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec07.BookDAO;
import sec07.BookVO;

/**
 * Servlet implementation class BookInsertServlet2
 */
@WebServlet("/bookInsert2")
public class BookInsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//<form> 태그 안에 입력된 데이터 받아와서 DATABASE에 INSERT 하기
		BookDAO dao = new BookDAO();
		
		ArrayList<BookVO> bookList = dao.bookSelect();
	
		String bookNo = request.getParameter("book_no");
		String bookName = request.getParameter("book_name");
		int bookPrice = Integer.parseInt(request.getParameter("book_Price")); 
		String bookAuthor = request.getParameter("book_author");
		String[] bookDate = request.getParameterValues("book_date");
		String pubNo = request.getParameter("pubNo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = bookDate[0]+"-"+ bookDate[1]+"-" +bookDate[2];
       
        Date inputdate = null;
		try {
			// inputdate = new Date(sdf.parse(strDate).getTime());
			inputdate =	sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		BookVO bv = new BookVO(bookNo, bookName, bookPrice, bookAuthor, inputdate, pubNo);
		
		BookDAO bookDAO = new BookDAO();
		bookDAO.bookInsert(bv);
		
		response.sendRedirect("bookSelect2");
	}

}


