package com.anxxp.command;

public class CommandDelete implements Command {
	
	Makefile makeFile;
	
	public CommandDelete(Makefile makeFile) {
		this.makeFile = makeFile;
	}
	
	@Override
	public void execute(String name) throws Exception {
		makeFile.deleteFile(name);
		
	}
}
