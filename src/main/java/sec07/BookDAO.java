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
	
	// �����ڿ��� DB ���� ���� : Ŀ�ؼ� Ǯ
	public BookDAO() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB ���� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ȸ�� ���� ��ȸ �޼ҵ� ( ��ü ȸ�� ���� SELECT �ؼ� ��ȯ : MemberVO ��ȯ)
	// MemberVO�� ���� �� ��ȯ : ArrayList<MemberVO>
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
			
			while(rs.next()) {		// ��� ��Ʈ���� �� �྿ ó��
				// �� ��(ȸ�� 1���) ó��
				String no = rs.getString("bookNo");
				String name = rs.getString("bookName");
				String author = rs.getString("bookAuthor");
				int price = rs.getInt("bookPrice");
				String date = rs.getString("bookDate");
				//String pubNo = rs.getString("bookPubno");
				String pubNo = rs.getString("pubNo");
				
				// �� �� ���� �����ͼ� MemberVO�� ���� : setter �޼ҵ� ���
				BookVO vo = new BookVO();
				vo.setNo(no);
				vo.setName(name);
				vo.setAuthor(author);
				vo.setPrice(price);
				vo.setDate(date);
				vo.setPubNo(pubNo);
				
				// �� MemberVO�� ArrayList�� �߰�(����)
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
				System.out.println("���� ������ �Է� ����!");
			}
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
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
				System.out.println("���� ���� ���� ����!");
			}
			
			pstmt.close();
			con.close();	
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}
	}
}
