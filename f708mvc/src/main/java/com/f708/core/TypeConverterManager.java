package com.f708.core;

import com.f708.typeConverter.ITypeConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理类型转换器
 */
public class TypeConverterManager {
	private static TypeConverterManager instance =new TypeConverterManager();
	
	public static TypeConverterManager getInstance()
	{
		return instance;
	}
	
	private TypeConverterManager()
	{
	
	}
	
	private Map<Class<?>,ITypeConverter> converters = new HashMap<>();
	
	/**
	 * 注册转换器
	 * @param targetClass
	 * @param converter
	 * @return
	 */
	public TypeConverterManager register(Class<?> targetClass,ITypeConverter converter)
	{
		converters.put(targetClass, converter);
		return this;
	}
	
	/**
	 * 把字符串类型的value转换为targetClass类型
	 * @param targetClass
	 * @param value
	 * @return
	 */
	public Object convert(Class<?> targetClass,String value)
	{
		ITypeConverter typeConverter = converters.get(targetClass);
		if(typeConverter==null)
		{
			throw new IllegalArgumentException("未知的目标类型");
		}
		return typeConverter.convert(value);
	}
}
