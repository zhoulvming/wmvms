/**
 * Dec 16, 2011
 */
package org.myplay.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

/**
 * @author elgs
 * 
 */
public class TestMVEL {

	public static void main(String[] args) throws Exception {
		// for (int i = 0; i < 10; ++i) {
		// init(i);
		// ParserContext ctx = new ParserContext();
		// ctx.addImport(TestMVEL.class);
		// ctx.addImport("sum", TestMVEL.class.getMethod("tdk1", new Class[] {
		// int.class, int.class }));
		// Serializable s = MVEL.compileExpression("sum(1,key)", ctx);
		// Object ans = MVEL.executeExpression(s, cache);
		// System.out.println(ans);
		// }

		ParserContext ctx = new ParserContext();
		ctx.addImport(TestMVEL.class);
		ctx.addImport("sum", TestMVEL.class.getMethod("sum", new Class[] { BigDecimal.class, BigDecimal.class }));
		TestMVEL.init();
		Serializable s = MVEL.compileExpression("sum(sum(a,b),2)", ctx);
		Object ans = MVEL.executeExpression(s, cache);
		System.out.println(ans);

	}

	public static Map<String, Object> cache = new HashMap<String, Object>();

	public static void init() {
		cache.put("a", BigDecimal.ONE);
		cache.put("b", BigDecimal.TEN);
	}

	public static BigDecimal sum(BigDecimal i, BigDecimal y) {
		return i.add(y);
	}
}