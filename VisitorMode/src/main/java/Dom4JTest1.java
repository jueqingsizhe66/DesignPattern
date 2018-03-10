import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class Dom4JTest1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader read=new SAXReader();
        Document doc=read.read(new File("F:\\NoteForJava\\Maven\\maven-setting.xml"));
        //doc.accept(new Test1Visitor());
        doc.accept(new Test2Visitor());

    }
}
