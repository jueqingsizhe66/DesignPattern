package com.anxxp.command;

//命令抽象接口
public interface Command {
	void execute(String name) throws Exception;
}
