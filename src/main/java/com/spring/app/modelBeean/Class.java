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

@Table(name="ch_class_details")
@Entity
public class Class implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Class(){}
	public Class(Integer classId,String className,Date createdDate,Integer teacherId)
	{
		this.classId = classId;
		this.className = className;
		this.createdDate = createdDate;
		this.teacherId = teacherId;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "class_id_n_sequence_generator")
	@SequenceGenerator(name="class_id_n_sequence_generator", sequenceName = "ch_class_details_class_id_n_seq")
	@Column(name="class_id_n", updatable = false, nullable = false)
	private Integer classId;
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time_dt",insertable=false)
	private Date lastUpdatedDate;
	
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name="classname_v")
	private String className;
	@Column(name="created_date_dt")
	private Date createdDate;
	@Column(name="teacher_id_n")
	private Integer teacherId;
}
