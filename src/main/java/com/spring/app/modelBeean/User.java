package com.spring.app.modelBeean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_details")
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="user_id_n")
	private long userId;
	
	@Column(name="username_v")
	private String userName;
	@Column(name="password_v")
	private String password;
	
	@Column(name="created_date_dt")
	private Date createdDateTime;
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Date getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}
	public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	@Column(name="last_updated_time_dt")
	private Date lastUpdatedDateTime;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName){
		this.userName =userName;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
}
