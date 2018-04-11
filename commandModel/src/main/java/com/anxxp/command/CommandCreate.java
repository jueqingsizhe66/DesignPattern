package com.anxxp.command;

public class CommandCreate implements Command {
	Makefile makeFile;
	
	public CommandCreate(Makefile makeFile) {
		this.makeFile = makeFile;
	}
	
	@Override
	public void execute(String name) throws Exception {
	makeFile.createFile(name);
	}
}
