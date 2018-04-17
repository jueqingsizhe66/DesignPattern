import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocxFileReader implements ITextReader {
	@Override
	public boolean accept(File file) {
		String ext = FilenameUtils.getExtension(file.getName());
		return ext.equalsIgnoreCase("docx---"); // test
		
	}
	
	@Override
	public String readAsString(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file);
		     XWPFDocument xdoc = new XWPFDocument(fis);
		     XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);) {
			String text = extractor.getText();
			return text;
		}
		
	}
}
