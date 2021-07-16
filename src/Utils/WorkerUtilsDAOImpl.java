package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Project;
import beans.Workers;

public class WorkerUtilsDAOImpl implements WorkerUtilsDAO {
	Connection con = null;
	Statement st = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	int rowCounts = 0;
	public boolean registerWorker(Workers worker) {
		boolean workerRegistered = false;
		con = DBUtils.getConnection();
		String sql = "insert into worker (w_name,w_adhar,w_address,P_ID,w_adate) values (?,?,?,?,now())";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, worker.getW_name());
			pst.setInt(2, worker.getW_adhar());
			pst.setString(3, worker.getW_address());
			pst.setInt(4, worker.getProject().getP_id());
			rowCounts = pst.executeUpdate();
			if(rowCounts > 0)
				workerRegistered = true;
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return workerRegistered;
	}

	public List<Workers> getAllWorker() {
		List<Workers> worker1 = new ArrayList<Workers>();
		Workers worker = null;
		con = DBUtils.getConnection();
		String sql = "select * from student";
		st = DBUtils.getStatement();
		try{
			rs = st.executeQuery(sql);
			while(rs.next()){
				worker = new Workers();
				worker.setW_id(rs.getInt("w_id"));
				worker.setW_name(rs.getString("w_name"));
				worker.setW_adhar(rs.getInt("w_adhar"));
				worker.setW_address(rs.getString("w_address"));
				int w_p_id = rs.getInt("P_ID");
				Project p = new Project();
				p.setP_id(w_p_id);
				worker.setProject(p);
				worker.setW_adate(rs.getDate("w_adate"));
				worker1.add(worker);
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return worker1;
	}

	public Workers getWorkersDetails(int w_id) {
		Workers worker = null;
		con = DBUtils.getConnection();
		String sql = "select w_id,w_name,w_adhar,w_address,P_ID_id,p_id,p_name from worker,project WHERE worker.P_ID=project.p_id AND w_id="+w_id;
		st = DBUtils.getStatement();
		try{
			rs = st.executeQuery(sql);
			while(rs.next()){
				worker = new Workers();
				worker.setW_id(rs.getInt("w_id"));
				worker.setW_name(rs.getString("w_name"));
				worker.setW_adhar(rs.getInt("w_adhar"));
				worker.setW_address(rs.getString("w_address"));
				int w_p_id = rs.getInt("P_ID");
				Project p = new Project();
				p.setP_id(w_p_id);
				worker.setProject(p);
				worker.setW_adate(rs.getDate("w_adate"));
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return worker;
	}

}
