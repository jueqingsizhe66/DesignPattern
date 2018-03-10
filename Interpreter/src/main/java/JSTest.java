import org.apache.commons.io.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class JSTest {
    /*
如果自己去解析这些公式、脚本是非常难的，这时候可以使用脚本引擎来完成。
	Java6之后内置了JavaScript脚本引擎，可以在Java代码中执行JavaScript代码；在旧版本Java中可以用第三方的V8等脚本引擎。
更全面的支持 https://www.cnblogs.com/duanxz/p/3666620.html
     */
    public static void main(String[] args) throws IOException, ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName ("JavaScript");
        engine.put("基本工资", 3600);
        engine.put("招生人数", 16);
        engine.put("迟到天数", 1);
        engine.put("sys", new SysFunc());
        try(InputStream inStream = JSTest.class.getResourceAsStream("gongzi.js");)
        {
            String js = IOUtils.toString(inStream, Charset.forName("UTF-8"));
            engine.eval(js);
            Object salary = engine.eval("工资");
            System.out.println("工资为："+salary);
        }

    }
}
