import java.io.File;
import java.io.IOException;

public interface ITextReader {
	/*
	Can or canot read?
	 */
	boolean accept(File file);
	
	/*
	read the content in the postfix
	 */
	String readAsString(File file) throws IOException;
}
