/**
 * Jan 6, 2012
 */
package org.myplay.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author elgs
 * 
 */
public class ComparableArrayList<T> extends ArrayList<T> implements Comparable<List<T>> {

	public ComparableArrayList() {
	}

	public ComparableArrayList(Sorter[] sorters) {
		this.sorters = Arrays.asList(sorters);
	}

	private List<Sorter> sorters = new ArrayList<Sorter>();

	public List<Sorter> getSorters() {
		return sorters;
	}

	public void setSorters(List<Sorter> sorters) {
		this.sorters = sorters;
	}

	@Override
	public int compareTo(List<T> o) {
		for (Sorter sorter : sorters) {
			int index = sorter.getSorter();
			boolean desc = sorter.isDesc();
			if (this.get(index) == o.get(index)) {
				continue;
			} else {
				int ret = this.get(index).toString().compareTo(o.get(index).toString());
				if (desc) {
					return -ret;
				} else {
					return ret;
				}
			}
		}
		return 0;
	}
}
