package com.har.journey;

import org.springframework.stereotype.Component;

@Component
public class DBExport {

	private String tableName;
	private String data;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DBExport [tableName=" + tableName + ", data=" + data + "]";
	}
	
}
