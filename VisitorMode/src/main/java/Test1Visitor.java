import org.dom4j.*;

public class Test1Visitor implements Visitor {
    @Override
    public void visit(Document document) {

    }

    @Override
    public void visit(DocumentType documentType) {

    }

    @Override
    public void visit(Element element) {

    }

    @Override
    public void visit(Attribute attribute) {
        System.out.println("Found the Attribute: "+ attribute.getName()+" , value:"+attribute.getValue());
    }

    @Override
    public void visit(CDATA cdata) {

    }

    @Override
    public void visit(Comment comment) {

    }

    @Override
    public void visit(Entity entity) {

    }

    @Override
    public void visit(Namespace namespace) {

    }

    @Override
    public void visit(ProcessingInstruction processingInstruction) {

    }

    @Override
    public void visit(Text text) {
        String txt = text.getText().trim();
        if (txt.trim().length()>0) {
            System.out.println("Found text"+txt);
        }
    }
}
