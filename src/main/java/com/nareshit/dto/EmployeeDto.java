package com.nareshit.dto;

public class EmployeeDto {

	private Long eid;
	private String ename;
	private Double sal;
	private String mobileNum;

	public EmployeeDto() {
		System.out.println("EmpDto contructor...");
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", mobileNum=" + mobileNum + "]";
	}

}
