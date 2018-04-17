import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class TXTFileReader implements ITextReader {
	@Override
	public boolean accept(File file) {
		String ext = FilenameUtils.getExtension(file.getName());
		return ext.equalsIgnoreCase("txt");
	}
	
	@Override
	public String readAsString(File file) throws IOException {
		return FileUtils.readFileToString(file, Charset.forName("UTF-8"));
	}
}
