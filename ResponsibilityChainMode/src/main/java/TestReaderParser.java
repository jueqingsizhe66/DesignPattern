import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

public class TestReaderParser {
	/*
	compositon rule
	 */
	private static LinkedList<ITextReader> readers = new LinkedList<>();
	
	static {
        /*
	这里把Driver类的对象调用registerDriver注册到了DriverManager中。
	Class.forName()就是加载Driver类，就会触发静态代码块的执行，完成Driver注册。

         */

        /*

            责任链模式也是一种桥接模式!

         */
		try (InputStream inStream = TestReaderParser.class.getResourceAsStream("readers.txt")) {
			//加载同包下的readers.txt文件，所有的ITextReader实现类每行一个配置到readers.txt中
			List<String> lines = IOUtils.readLines(inStream, Charset.forName("UTF-8"));
			for (String className : lines) {
				Class clz = Class.forName(className);
				//反射创建对象，放到readers集合中
				ITextReader reader = (ITextReader) clz.newInstance();
				readers.add(reader);
			}
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} catch (InstantiationException ex) {
			throw new RuntimeException(ex);
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	public static String readAsString(File file) throws IOException {
		for (ITextReader reader : readers) {
			if (reader.accept(file)) {
				return reader.readAsString(file);
			}
			
		}
		throw new RuntimeException("No Reader Engine for you");
	}
	
	public static void main(String[] args) throws IOException {
		//    String s1=TestReaderParser.readAsString(new File("C:\\Users\\yzl\\Desktop\\paperForTorque\\test.txt")); //OK
//        String s1=TestReaderParser.readAsString(new File("C:\\Users\\yzl\\Desktop\\paperForTorque\\Yplus.html"));// OK
		String s1 = TestReaderParser.readAsString(new File("D:\\java\\DesignPattern\\ResponsibilityChainMode\\src\\main\\resources\\readers.txt"));//OK, OK 2
		System.out.println(s1);
	}
}
