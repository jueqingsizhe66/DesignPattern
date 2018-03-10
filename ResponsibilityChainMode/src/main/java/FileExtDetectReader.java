import org.apache.commons.io.FilenameUtils;

import java.io.File;

public abstract class FileExtDetectReader implements ITextReader{
    @Override
    public boolean accept(File file) {
        String ext = FilenameUtils.getExtension(file.getName());
        String[] acceptExtNames = getAcceptExtNames();
        for(String acceptExtName : acceptExtNames)
        {
            if(ext.equalsIgnoreCase(acceptExtName))
            {
                return true;
            }
        }
        return false;

    }

    public abstract String[] getAcceptExtNames();
}
