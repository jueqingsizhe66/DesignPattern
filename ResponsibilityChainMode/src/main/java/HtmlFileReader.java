import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class HtmlFileReader implements ITextReader {
	@Override
	public boolean accept(File file) {
		String ext = FilenameUtils.getExtension(file.getName());
		return ext.equalsIgnoreCase("html") || ext.equalsIgnoreCase("htm");
		
	}
	
	@Override
	public String readAsString(File file) throws IOException {
		Document doc = Jsoup.parse(file, null);
		return doc.text();
		
	}
}
