package org.myplay.repository;

import java.util.List;

public class CommonResult<T> {

	private int total;

	private List<T> data;

	private int offSet;

	public CommonResult() {
	}

	public CommonResult(int total, List<T> list, int startIndex) {
		this.total = total;
		data = list;
		offSet = startIndex;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

}