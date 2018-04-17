package com.f708.actionResult;

import com.f708.core.ControllerContext;

import java.io.IOException;

/**
 * Action执行的返回值封装接口
 */
public interface ActionResult {
	/**
	 * 命令模式封装
	 *
	 * @param context
	 * @throws IOException
	 */
	void execute(ControllerContext context) throws IOException;
}
