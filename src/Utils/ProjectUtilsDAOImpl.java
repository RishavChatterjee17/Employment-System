package Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Project;
public class ProjectUtilsDAOImpl implements ProjectUtilsDAO {

	Connection con = null;
	Statement st = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	int rowCount = 0;
	public boolean addProject(Project project) {
		boolean projectAdded = false;
		con = DBUtils.getConnection();
		String sql = "insert into project (p_name,p_location,p_sdate) values (?,?,now())";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, project.getP_name());
			pst.setString(2, project.getP_location());
			//pst.setDate(3, (Date) project.getP_sdate());
			//pst.setDate(4, (Date) project.getP_edate());
			
			rowCount = pst.executeUpdate();
			if(rowCount > 0)
				projectAdded = true;
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projectAdded;
	}

	
	public List<Project> getAllProject() {
		List<Project> project1 = new ArrayList<Project>();
		Project project = null;
		con = DBUtils.getConnection();
		String sql = "select * from project";
		st = DBUtils.getStatement();
		try{
			rs = st.executeQuery(sql);
			while(rs.next()){
				project = new Project();
				project.setP_id(rs.getInt("p_id"));
				project.setP_name(rs.getString("p_name"));
				project.setP_location(rs.getString("p_location"));
				project.setP_sdate(rs.getDate("p_sdate"));
				project.setP_edate(rs.getDate("p_edate"));
			    project1.add(project);
			}			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project1;
	}

	
	public Project getProject(int p_id) {
		Project project = null;
		con = DBUtils.getConnection();
		String sql = "select * from project WHERE p_id="+p_id;
		st = DBUtils.getStatement();
		try{
			rs = st.executeQuery(sql);
			while(rs.next()){
				project = new Project();
				project.setP_id(rs.getInt("p_id"));
				project.setP_name(rs.getString("p_name"));
				project.setP_location(rs.getString("p_location"));
				project.setP_sdate(rs.getDate("p_sdate"));
				project.setP_edate(rs.getDate("p_edate"));
			}			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
	}


	
	public boolean updateProject(Project project) {
		String sql = "update project SET p_name=?,p_location=?,p_sdate=?,p_edate=? WHERE p_id=?";
		return false;
	}

	public boolean registerProject(Project project) {
		boolean projectRegistered = false;
		con = DBUtils.getConnection();
		String sql = "insert into worker (p_name,p_location,p_sdate,p_edate) values (?,?,now(),now())";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, project.getP_name());
			pst.setString(2, project.getP_location());
			rowCount = pst.executeUpdate();
			if(rowCount > 0)
				projectRegistered = true;
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projectRegistered;
	}
	
}
