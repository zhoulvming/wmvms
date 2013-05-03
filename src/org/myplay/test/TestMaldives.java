/**
 * Jul 19, 2012
 */
package org.myplay.test;

import com.si.maldives.core.ChainExecutor;

/**
 * @author elgs
 * 
 */
public class TestMaldives {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Object input = "10";
		Object output = ChainExecutor.execute(input, "test");
		System.out.println(output);
	}

}
