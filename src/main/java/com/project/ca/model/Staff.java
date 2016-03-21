package com.project.ca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.validation.constraints.Max;
import java.sql.Date;
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "staff")
public class Staff {
	
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
private String staffid;
private int roleid;
private String firstname;
private String lastname;
private String gender;
private String address;
private String phoneno;
private String email;
private String pwd;
private String managerid;
private String createdby;
private String updatedby;
private Date createddate;
private Date updateddate;



public String getStaffid() {
	return staffid;
}
public void setStaffid(String staffid) {
	this.staffid = staffid;
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getManagerid() {
	return managerid;
}
public void setManagerid(String managerid) {
	this.managerid = managerid;
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
