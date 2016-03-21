package com.project.ca.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leavetype") 
public class LeaveType {
@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
private int leaveid;
private String leavetype;
private float limitdays;
private String createdby;
private String updatedby;
private Date createddate;
private Date updateddate;
public int getLeaveid() {
	return leaveid;
}
public void setLeaveid(int leaveid) {
	this.leaveid = leaveid;
}
public String getLeavetype() {
	return leavetype;
}
public void setLeavetype(String leavetype) {
	this.leavetype = leavetype;
}
public float getLimitdays() {
	return limitdays;
}
public void setLimitdays(float limitdays) {
	this.limitdays = limitdays;
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



}
