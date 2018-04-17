import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocFileReader implements ITextReader {
	@Override
	public boolean accept(File file) {
		String ext = FilenameUtils.getExtension(file.getName());
		return ext.equalsIgnoreCase("doc");
	}
	
	@Override
	public String readAsString(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file);
		     HWPFDocument doc = new HWPFDocument(fis);) {
			Range rang = doc.getRange();
			String text = rang.text();
			return text;
		}
		
	}
}
