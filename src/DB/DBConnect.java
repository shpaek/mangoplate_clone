package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// 객체생성해서 코드 효율적으로 가능한가?

public class DBConnect {
		//db 연결을 객체로 만들자
	   public Connection conn = null; // 데이터베이스 연결을 관리하기 위한 객체

	   public void dbConnection() {
	      try {
	         Class.forName("oracle.jdbc.OracleDriver"); // JVM애 jdbc드라이버 로드
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }

	      // DB와 연결
	      // java.sql.Connection 라이브러리

	      String url = "jdbc:oracle:thin:@192.168.1.20:1521:xe"; // 로컬에 있는 오라클 DB url 넘김
	      String user = "mango";
	      String password = "mango";

	      try {
	         conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	   }
}
