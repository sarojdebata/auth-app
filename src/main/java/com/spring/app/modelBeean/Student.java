package com.spring.app.modelBeean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="ch_student_details")
@Entity
public class Student implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public Student(){
		
	}
	
	public Student(Integer id,String firstName,String lastName,Date createdDate,Integer schoolId)
	{
		this.studentId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.schoolId = schoolId;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "student_id_n_sequence_generator")
	@SequenceGenerator(name="student_id_n_sequence_generator", sequenceName = "ch_student_details_student_id_n_seq")
	@Column(name="student_id_n", updatable = false, nullable = false)
	private Integer studentId;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer teacherId) {
		this.studentId = teacherId;
	}
	
	@Column(name="firstname_v")
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name="lastname_v")
	private String lastName;
	@Column(name="studentaddress_v")
	private String address;
	@Column(name="created_date_dt")
	private Date createdDate;
	
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	@Column(name="school_id_n")
	private Integer schoolId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time_dt",insertable=false)
	private Date lastUpdatedDate;
	
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
}
