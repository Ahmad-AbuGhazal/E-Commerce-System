package edu.mum.estore.domain;

import java.util.List;

public class JsonResponse<T> {
	private List<T> data;
	
	public JsonResponse() {}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}	
}
