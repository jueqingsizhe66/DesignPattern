package com.fengtai.f708mvctest1;

import com.f708.actionResult.*;
import com.f708.annotation.F708Controller;
import com.f708.annotation.RequestParam;
import com.fengtai.models.Person;

@F708Controller
public class PersonController {
	public ActionResult add(@RequestParam("i1")int arg0, @RequestParam("i2")int arg1) {
		int i3 = arg0 + arg1;
		return new ContentResult(String.valueOf(i3));
	}
	
	public ActionResult index(String name) {
		Person p = new Person(666, "yzk");
		return new ViewResultBuilder().model(p).build();
	}
	
	public ActionResult test(int i)
	{
		if(i==1)
		{
			return new AjaxResult(new Person(3,"rupeng.com"));
		}
		else if(i==2)
		{
			return new RedirectResult("http://www.rupeng.com");
		}
		else
		{
			return new ViewResultBuilder().model("hello").viewName("index2").build();
		}
	}
}
