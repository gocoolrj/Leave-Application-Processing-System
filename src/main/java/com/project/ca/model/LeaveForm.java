package com.project.ca.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveform")
public class LeaveForm {
	
	@Id
	@GeneratedValue
	@Column(name="leaveformid")
	private int leaveformid;
	private int leaveid;
	private String staffid;
	private Date startdate;
	private String fromshift; 
	private Date enddate;
	private String toshift;
	private float daystaken;
	private String lstatus;
	private String reason;
	private String createdby;
	private String updatedby;
	private Date createddate;
	private Date updateddate;
	private String firstname;
	private String workdissemination;
	
	
	public String getWorkdissemination() {
		return workdissemination;
	}
	public void setWorkdissemination(String workdissemination) {
		this.workdissemination = workdissemination;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	private String Comment;
	public int getLeaveformid() {
		return leaveformid;
	}
	public void setLeaveformid(int leaveformid) {
		this.leaveformid = leaveformid;
	}
	public int getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getFromshift() {
		return fromshift;
	}
	public void setFromshift(String fromshift) {
		this.fromshift = fromshift;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getToshift() {
		return toshift;
	}
	public void setToshift(String toshift) {
		this.toshift = toshift;
	}
	public float getDaystaken() {
		return daystaken;
	}
	public void setDaystaken(float daystaken) {
		this.daystaken = daystaken;
	}
	public String getLstatus() {
		return lstatus;
	}
	public void setLstatus(String lstatus) {
		this.lstatus = lstatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	@Override
	public String toString() {
		return "LeaveForm [leaveformid=" + leaveformid + ", leaveid=" + leaveid
				+ ", staffid=" + staffid + ", startdate=" + startdate
				+ ", fromshift=" + fromshift + ", enddate=" + enddate
				+ ", toshift=" + toshift + ", daystaken=" + daystaken
				+ ", lstatus=" + lstatus + ", reason=" + reason + ", Comment="
				+ Comment + ", createdby=" + createdby + ", updatedby="
				+ updatedby + ", createddate=" + createddate + ", updateddate="
				+ updateddate + "]";
	}
	
	
	

}
