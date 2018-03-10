import org.apache.commons.codec.digest.DigestUtils;

public class MD5Stragety implements IDigestStragety{
    @Override
    public String digest(String data) {
        return DigestUtils.md5Hex(data);
    }
}
