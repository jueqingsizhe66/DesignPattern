import org.dom4j.Attribute;
import org.dom4j.Text;
import org.dom4j.VisitorSupport;

public class Test2Visitor extends VisitorSupport {

    public void visit(Attribute attribute) {
        System.out.println("Found the Attribute: "+ attribute.getName()+" , value:"+attribute.getValue());

    }

    public void visit(Text text) {
        String txt = text.getText().trim();
        if (txt.trim().length()>0) {
            System.out.println("Found text"+txt);
        }
    }


}
