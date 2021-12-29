package sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
	// DB ����
	private Connection conDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/servletdb?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if(con != null) System.out.println("DB ���� ����!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// ���� ���� ��ȸ �޼���
	public ArrayList<BookVO> bookSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		try {
			con = conDB();
			
			String query =  "select * from book";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString("bookNo");
				String bookName = rs.getString("bookName");
				String bookAuthor = rs.getString("bookAuthor");
				int bookPrice = rs.getInt("bookPrice");
				Date booDate = rs.getDate("bookDate");
				String pubNo = rs.getString("pubNo");
				
				BookVO vo = new BookVO();
				vo.setBookNo(bookNo);
				vo.setBookName(bookName);
				vo.setBookAuthor(bookAuthor);
				vo.setBookPrice(bookPrice);
				vo.setBooDate(booDate);
				vo.setPubNo(pubNo);
				
				bookList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}
}
