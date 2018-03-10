import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocxFileReaderA extends FileExtDetectReader {
    @Override
    public String[] getAcceptExtNames() {
        return new String[]{"docx"}; // {"docx","doc"}
    }

    @Override
    public String readAsString(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             XWPFDocument xdoc = new XWPFDocument(fis);
             XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);)
        {
            String text = extractor.getText();
            return text;
        }

    }
}
