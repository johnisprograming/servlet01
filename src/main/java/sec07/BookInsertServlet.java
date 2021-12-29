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
	// Ŭ���̾�Ʈ --> ���� : ��û 
	// ��û�� ���� ���� request ��ü�� ����
	// ���� ��� ---> Ŭ���̾�Ʈ���� ���� : ���� response
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��û�����鼭 ������ ���� ����
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("book_no");
		String name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String pubNo = request.getParameter("pubNo");
		System.out.println("����"+no);
		
		// MemberVO�� ����
		BookVO vo = new BookVO();
		vo.setNo(no);
		vo.setName(name);
		vo.setAuthor(author);
		vo.setPrice(Integer.parseInt(price));
		vo.setDate(date);
		vo.setPubNo(pubNo);
		
		
		// �Ǵ�
		// MemberVO vo = new MemberVO(id,pwd,name,email);
		
		// ȸ�� ���� ��� : memberInsert() ȣ�� => DB�� ����
		BookDAO dao = new BookDAO();
		dao.bookInsert(vo);
		
		// select ��� �������� ������ : ���� --> Ŭ���̾�Ʈ
		response.sendRedirect("bookSelect2");
	}

}