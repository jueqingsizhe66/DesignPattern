package com.f708.typeConverter;

public class IntegerConverter implements ITypeConverter {
	@Override
	public Object convert(String data) {
		if(data==null)
		{
			return 0;
		}
		return Integer.parseInt(data);
	}
}
