package com.spring.app.modelBeean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="ms_school_details")
@Entity
public class School implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public School(){
		
	}
	public School(Integer schoolId,String schoolName,String schoolAddrs,Date createdDate,String email,String fax,String comment)
	{
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddrs = schoolAddrs;
		this.createdDate = createdDate;
		this.email = email;
		this.fax = fax;
		this.comment = comment;
	}
	
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "school_id_n_sequence_generator")
	@SequenceGenerator(name="school_id_n_sequence_generator", sequenceName = "ms_school_details_school_id_n_seq")
	@Column(name = "school_id_n", updatable = false, nullable = false)
	private Integer schoolId;
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddrs() {
		return schoolAddrs;
	}
	public void setSchoolAddrs(String schoolAddrs) {
		this.schoolAddrs = schoolAddrs;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name="schoolname_v")
	private String schoolName;
	
	@Column(name="schooladdress_v")
	private String schoolAddrs;
	
	@Column(name="created_date_dt")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time_dt",insertable=false)
	private Date lastUpdatedDate;
	
	@Column(name="email")
	private String email;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="comment")
	private String comment;

	@OneToMany(mappedBy ="school", cascade = CascadeType.ALL)
	private List<Teacher> liTeachers = new ArrayList<Teacher>();

	public List<Teacher> getLiTeachers() {
		return liTeachers;
	}
	public void setLiTeachers(List<Teacher> liTeachers) {
		this.liTeachers = liTeachers;
	}
	
	
}

