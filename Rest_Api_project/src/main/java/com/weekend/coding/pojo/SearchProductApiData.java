package com.weekend.coding.pojo;



public class SearchProductApiData {

	private String searchText;

	public SearchProductApiData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchProductApiData(String searchText) {
		super();
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "SearchProductApiData [searchText=" + searchText + "]";
	}
	
}

