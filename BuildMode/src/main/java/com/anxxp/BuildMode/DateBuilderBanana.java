package com.anxxp.BuildMode;

public class DateBuilderBanana implements IDateBuilder {
	private MyDate myDate;
	
	public DateBuilderBanana(MyDate myDate) {
		this.myDate = myDate;
	}
	
	@Override
	public IDateBuilder buildDate(int y, int m, int d) {
		myDate.date=y+"*****"+m+"*****"+d;
		return this;
	}
	
	@Override
	public String date() {
		return myDate.date;
	}
}
