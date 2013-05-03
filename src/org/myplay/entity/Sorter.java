/**
 * Jan 6, 2012
 */
package org.myplay.entity;

/**
 * @author elgs
 * 
 */
public class Sorter {

	public Sorter(int sorter, boolean desc) {
		this.sorter = sorter;
		this.desc = desc;
	}

	private int sorter;
	private boolean desc;

	public int getSorter() {
		return sorter;
	}

	public void setSorter(int sorter) {
		this.sorter = sorter;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

}
