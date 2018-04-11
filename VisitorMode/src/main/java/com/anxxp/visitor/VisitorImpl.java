package com.anxxp.visitor;

public class VisitorImpl implements Visitor {
	@Override
	public void visit(UserVIP user) {
		String estimation = user.getEstimate();
		if (estimation.length() > 5) {
			System.out.println("記錄一條有效反饋: " + estimation);
		}
	}
	
	@Override
	public void visit(UserOrdinary user) {
		String estimation = user.getEstimation();
		if (estimation.length()>10) {
			System.out.println("記錄一條有效反饋： "+ estimation);
		}
	}
}
