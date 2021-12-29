package sec06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/memberInsert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받으면서 데이터 전달 받음
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		
		// MemberVO에 저장
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setEmail(email);
		
		// 또는 생성자 사용
		//MemberVO vo = new MemberVO(id, pwd, name, email);
		
		// 회원 정보 등록 : memberInsert() 호출  -> DB에 저장
		MemberDAO dao = new MemberDAO();
		dao.memberInsert(vo);		
		
		// select 결과 페이지로 포워딩
		response.sendRedirect("memberSelect2");
	}

}
