package sec09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// 생성자에서 DB 연결 설정
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB 연결 성공");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환 : MemberVO 반환)
	//MemberVO를 여러 행 반환 : ArrayList<MemberVO>
	public ArrayList<MemberVO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			con = dataSource.getConnection();
			
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 결과 세트에서 한 행씩 처리
				// 한 행(회원 1명당) 처리 
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				String email = rs.getString("memEmail");
				Date joinDate = rs.getDate("memJoinDate");
				
				// 한 행 정보 가져와서 MemberVO에 저장 : setter 메소드 사용
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				// 각 MemberVO를 ArrayList에 추가(저장)
				memList.add(vo);				
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
		
		return memList;		
	}
	
	
	// 회원 정보 등록하는 메소드 : memberInsert()
	public void memberInsert(MemberVO vo){
		
		//sql문 values에 들어갈 데이터 설정
			
		try {
			con = dataSource.getConnection();
			
			//String sql = "insert into member values(?, ?, ?, ?, default)";
			String sql = "insert into member (memId, memPwd, memName, memEmail)  values(?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId()); 
			pstmt.setString(2, vo.getPwd()); 
			pstmt.setString(3, vo.getName()); 
			pstmt.setString(4,  vo.getEmail());
			
			// 쿼리문 실행 : 영향을 받은 행의 수 반환
			//select : executeQuery - 결과 행 resultSet 반환.
			//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 입력 성공!");
			}
			
			// 모든 객체 close() : 리소스 반납	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
	}
	
	
	// 회원 정보 삭제 메소드
	public void memberDelete(String id ) {
		
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from member where memId=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id); 
			
			// 쿼리문 실행 : 영향을 받은 행의 수 반환
			//select : executeQuery - 결과 행 resultSet 반환.
			//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원 정보 삭제 성공!");
			}
			
			// 모든 객체 close() : 리소스 반납	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
	}
	
}
















