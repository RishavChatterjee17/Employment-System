package Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;
public class UserUtilsDAOImpl implements UserUtilsDAO{
	Connection con = null;
	Statement st = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	int rowCounts = 0;
	public User validate(String email, String password, String role) {
		User user = null;
		con = DBUtils.getConnection();
		String sql = "select * from user WHERE u_email=? AND u_password=? AND u_role=?";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, role);
			rs = pst.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setU_id(rs.getInt("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_email(rs.getString("u_email"));
				user.setU_password(rs.getString("u_password"));
				user.setU_role(rs.getString("u_role"));
			}
			DBUtils.closeResources();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

}
