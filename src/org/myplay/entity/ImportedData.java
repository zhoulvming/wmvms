/**
 * Jun 1, 2012
 */
package org.myplay.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author elgs
 * 
 */
public class ImportedData<T> {
	private Map<String, Object> headers = new HashMap<String, Object>();
	private List<List<T>> block = new ArrayList<List<T>>();

	public Map<String, Object> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}

	public List<List<T>> getBlock() {
		return block;
	}

	public void setBlock(List<List<T>> block) {
		this.block = block;
	}

}
