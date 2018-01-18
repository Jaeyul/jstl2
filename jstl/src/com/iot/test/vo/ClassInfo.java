package com.iot.test.vo;

public class ClassInfo {
	
	private int ciNo;
	private String ciName;
	private String ciDesc;
	private String search;
	private String searchType;	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getCiNo() {
		return ciNo;
	}
	public void setCiNo(int ciNo) {
		this.ciNo = ciNo;
	}
	public String getCiName() {
		return ciName;
	}
	public void setCiName(String ciName) {
		this.ciName = ciName;
	}
	public String getCiDesc() {
		return ciDesc;
	}
	public void setCiDesc(String ciDesc) {
		this.ciDesc = ciDesc;
	}
	@Override
	public String toString() {
		return "ClassInfo [ciNo=" + ciNo + ", ciName=" + ciName + ", ciDesc=" + ciDesc + "]";
	}
	
	

}
