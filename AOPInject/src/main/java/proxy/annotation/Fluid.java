package proxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
首先,创建一个注解,用关键字@interface来声明,这是一个注解类.@Target来声明注解目标,
@Retention用来说明该注解类的生命周期.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Fluid {
	public String value() default "Big hei";

	public String Property() default "Empty";
}
