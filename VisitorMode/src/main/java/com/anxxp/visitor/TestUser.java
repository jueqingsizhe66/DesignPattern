package com.anxxp.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUser {
	public static void main(String[] args) {
		Visitor visitorImpl = new VisitorImpl();
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(new UserOrdinary("普通用戶反饋"));
		users.add(new UserOrdinary("這是一個普通用戶比較長的反饋"));
		users.add(new UserVIP("VIP用戶短反饋"));
		users.add(new UserVIP("VIP用戶長反饋"));
		
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			iterator.next().accept(visitorImpl);
		}
	}
}
