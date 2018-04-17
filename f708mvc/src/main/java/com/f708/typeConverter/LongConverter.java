package com.f708.typeConverter;

public class LongConverter implements ITypeConverter {
	@Override
	public Object convert(String data) {
		if(data==null)
		{
			return 0;
		}
		return Long.parseLong(data);
	}
}
