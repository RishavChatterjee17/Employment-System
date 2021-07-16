package beans;

import java.util.Date;

public class Workers {
	private int w_id;
	private String w_name;
	private int w_adhar;
	private String w_address;
	private Project project;
	private Date w_adate;
	public Workers(){}
	public Workers(int w_id,String w_name,int w_adhar,String w_address,Project project,Date w_adate){
		super();
		this.w_id=w_id;
		this.w_name=w_name;
		this.w_adhar=w_adhar;
		this.w_address=w_address;
		this.project=project;
		this.w_adate=w_adate;
	}
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public int getW_adhar() {
		return w_adhar;
	}
	public void setW_adhar(int w_adhar) {
		this.w_adhar = w_adhar;
	}
	public String getW_address() {
		return w_address;
	}
	public void setW_address(String w_address) {
		this.w_address = w_address;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Date getW_adate() {
		return w_adate;
	}
	public void setW_adate(Date w_adate) {
		this.w_adate = w_adate;
	}
	public String toString(){
		return w_name;
	}
	
}
