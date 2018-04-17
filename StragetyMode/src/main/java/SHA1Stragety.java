import org.apache.commons.codec.digest.DigestUtils;

public class SHA1Stragety implements IDigestStragety {

	@Override
	public String digest(String data) {
		return DigestUtils.sha1Hex(data);
	}
}
