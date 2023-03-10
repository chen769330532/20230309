package com.example.demo.design.chain;

//设计模式 责任链   当前审批人
public abstract class Approver {
	
	private String name;
	
	private Approver nextApprover;
	
	public abstract boolean commit(int money);
	
	public Approver(Approver approver) {
		this.name = approver.name;
		this.nextApprover = approver.nextApprover;
	};
	
}
