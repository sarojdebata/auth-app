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

@Table(name="ch_subject_details")
@Entity
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Subject(){}
	public Subject(Integer subjectId,String subjectName,Date createdDate,Date lastUpdatedDate,Integer teacherId,Integer classId)
	{
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.teacherId = teacherId;
		this.classId = classId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "subject_id_n_sequence_generator")
	@SequenceGenerator(name="subject_id_n_sequence_generator", sequenceName = "ch_subject_details_subject_id_n_seq")
	@Column(name="subject_id_n", updatable = false, nullable = false)
	private Integer subjectId;
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name="subjectname_v")
	private String subjectName;
	@Column(name="created_date_dt")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time_dt",insertable=false)
	private Date lastUpdatedDate;
	
	@Column(name="teacher_id_n")
	private Integer teacherId;
	@Column(name="class_id_n")
	private Integer classId;
	

}
