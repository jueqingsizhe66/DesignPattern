import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Stragety implements IDigestStragety {
	@Override
	public String digest(String data) {
		return DigestUtils.sha256Hex(data);
	}
}
