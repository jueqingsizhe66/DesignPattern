package WithDecorate;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class TestStream {

	public static void main(String[] args) throws IOException {

		try (OutputStream os = new FileOutputStream("E://hello.txt");) {
			Writer osWriter = new OutputStreamWriter(os);
			osWriter.write("hello ..................");
		}

        /*
        装饰一下, 二进制GZIP保存模式（乱码了)
         */
		try (OutputStream os2 = new GZIPOutputStream(new FileOutputStream("E://helloZip.txt"));) {
			Writer osWriter2 = new OutputStreamWriter(os2);
			osWriter2.write("hello ..................");
		}

        /*
        缓存一下，性能提高
         */
		try (OutputStream os2 = new GZIPOutputStream(new FileOutputStream("E://helloZip.txt"));) {
			Writer osWriter2 = new BufferedWriter(new OutputStreamWriter(os2));
			osWriter2.write("hello ..................");
		}
	}


}
