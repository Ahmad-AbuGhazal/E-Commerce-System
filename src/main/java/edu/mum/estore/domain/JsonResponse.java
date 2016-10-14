package edu.mum.estore.domain;

import java.util.List;

public class JsonResponse {
	private List<Product> data;
	
	public JsonResponse() {}

	public List<Product> getData() {
		return data;
	}

	public void setData(List<Product> data) {
		this.data = data;
	}
}
