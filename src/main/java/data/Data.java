package data;

import java.util.ArrayList;

public class Data {
	@SuppressWarnings("rawtypes")
	private ArrayList<ArrayList> data;

	@SuppressWarnings("rawtypes")
	public Data() {
		data = new ArrayList<ArrayList>();
	}
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> getData() {
		return data;
	}

	@SuppressWarnings("rawtypes")
	public void setData(ArrayList<ArrayList> data) {
		this.data = data;
	}
	
}
