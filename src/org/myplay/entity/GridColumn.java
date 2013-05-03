package org.myplay.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author elgs
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GridColumn {
	// Grid Column specific
	public int seq();

	public String text();

	public int width() default 80;

	public String xtype() default "";

	public String format() default "";

	public String editor() default "textfield";

	// Store field specific
	public String dateFormat() default "time";

	public String type() default FieldBean.FieldType.TYPE_AUTO;

	public String defaultValue() default "-";

	public boolean hidden() default false;

	public boolean searchable() default false;
	
	public String renderer() default "";

}
