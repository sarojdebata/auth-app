package com.spring.app.modelBeean;

import java.io.Serializable;

public class Constant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String constant;
	public String getConstant() {
		return constant;
	}
	public void setConstant(String constant) {
		this.constant = constant;
	}
	public String getConstname() {
		return constname;
	}
	public void setConstname(String constname) {
		this.constname = constname;
	}
	private String constname;

	
	
}
