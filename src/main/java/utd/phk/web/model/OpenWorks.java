package utd.phk.web.model;

import java.io.Serializable;

public class OpenWorks implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String workId;
	private String workDescription;
	private String createdBy;
	private String tsCreated;
	private String tsExpiry;
	private String startLocation;
	private String endLocation;
	private String cost;
	private String fname;
	private String lname;
	private String assignStatus;
	private String assignTo;
	
	
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAssignStatus() {
		return assignStatus;
	}
	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}
	public String getTsCreated() {
		return tsCreated;
	}
	public void setTsCreated(String tsCreated) {
		this.tsCreated = tsCreated;
	}
	public String getTsExpiry() {
		return tsExpiry;
	}
	public void setTsExpiry(String tsExpiry) {
		this.tsExpiry = tsExpiry;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
