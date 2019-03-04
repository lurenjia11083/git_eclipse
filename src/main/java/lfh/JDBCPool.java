package lfh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCPool {
	private static String url = "jdbc:mysql://localhost:3306/book_shop?serverTimezone=GMT";
	private static String username = "root";
	private static String password = "";
	private static Connection cn = null;
	private static PreparedStatement pstmt=null;

	public static void main(String[] args) {
		try {
			/*mysql驱动包6.0.6名称改为"com.mysql.cj.jdbc.Driver"如果仍旧使用"com.mysql.jdbc.Driver"会产生"Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'"警告*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,username,password);
			
			int size=10;
			int pageNum=1;
			 pstmt = cn.prepareStatement("select * from tb_book limit ?,?");
			 pstmt.setInt(1, (pageNum-1)*size);
			 pstmt.setInt(2, size);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					String title=rs.getString("title");
					int max_length=30;
					if(title.length()>max_length){
						title = title.substring(0,max_length);
					}
					System.out.println(title+"\n");
				}
				while(rs.next());
			}			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null){
					pstmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
