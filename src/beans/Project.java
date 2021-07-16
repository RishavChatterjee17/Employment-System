package beans;

import java.util.Date;

public class Project {
	private int p_id;
	private String p_name;
	private String p_location;
	private Date p_sdate;
	private Date p_edate;
	public Project(){}
	public Project(int p_id,String p_name,String p_location,Date p_sdate,Date p_edate){
		super();
		this.p_id=p_id;
		this.p_name=p_name;
		this.p_location=p_location;
		this.p_sdate=p_sdate;
		this.p_edate=p_edate;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_location() {
		return p_location;
	}
	public void setP_location(String p_location) {
		this.p_location = p_location;
	}
	public Date getP_sdate() {
		return p_sdate;
	}
	public void setP_sdate(Date p_sdate) {
		this.p_sdate = p_sdate;
	}
	public Date getP_edate() {
		return p_edate;
	}
	public void setP_edate(Date p_edate) {
		this.p_edate = p_edate;
	}
	public String toString(){
		return p_name;
	}
}
