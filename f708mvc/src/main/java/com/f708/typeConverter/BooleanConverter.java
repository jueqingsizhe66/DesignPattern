package com.f708.typeConverter;

public class BooleanConverter implements ITypeConverter{
	@Override
	public Object convert(String data) {
		if(data==null)
		{
			return false;
		}
		data = data.toLowerCase();
		if(data.equals("false")||data.equals("off"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
