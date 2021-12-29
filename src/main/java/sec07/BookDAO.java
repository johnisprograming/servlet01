package sec07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// 생성자에서 DB 연결 설정 : 커넥션 풀
	public BookDAO() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 회원 정보 조회 메소드 ( 전체 회원 정보 SELECT 해서 반환 : MemberVO 반환)
	// MemberVO를 여러 행 반환 : ArrayList<MemberVO>
	public ArrayList<BookVO> bookSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		try {
			con = dataSource.getConnection();
			
			String query = "select * from book";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		// 결과 세트에서 한 행씩 처리
				// 한 행(회원 1명당) 처리
				String no = rs.getString("bookNo");
				String name = rs.getString("bookName");
				String author = rs.getString("bookAuthor");
				int price = rs.getInt("bookPrice");
				String date = rs.getString("bookDate");
				//String pubNo = rs.getString("bookPubno");
				String pubNo = rs.getString("pubNo");
				
				// 한 행 정보 가져와서 MemberVO에 저장 : setter 메소드 사용
				BookVO vo = new BookVO();
				vo.setNo(no);
				vo.setName(name);
				vo.setAuthor(author);
				vo.setPrice(price);
				vo.setDate(date);
				vo.setPubNo(pubNo);
				
				// 각 MemberVO를 ArrayList에 추가(저장)
				bookList.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bookList;
	}
	
	public void bookInsert(BookVO vo) {
		try {
			con = dataSource.getConnection();
			
			String sql="insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setString(5, vo.getDate());
			pstmt.setString(6, vo.getPubNo());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("도서 데이터 입력 성공!");
			}
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}
	}
	
	public void bookDelete(String no) {
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from book where bookNo=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("도서 정보 삭제 성공!");
			}
			
			pstmt.close();
			con.close();	
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}
	}
}
