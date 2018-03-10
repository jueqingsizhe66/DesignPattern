import org.apache.commons.codec.digest.DigestUtils;

public class TestStragety {
    private String salt = "edu.f708";
    private HashType hashType;

    public TestStragety(HashType hashType){
        this.hashType = hashType;
    }
    public static void main(String[] args) {
        TestStragety tOne = new TestStragety(HashType.MD5);
        String hash = tOne.calcStringHash("123456");
        System.out.println(hash);
        /*
       C:\Users\yzl>echo -n "123456"|md5sum
3b3ca0f84d4c15f6324b5fc45b7094fd *-
         */
        System.out.println(tOne.checkStringHash("458298d8bc6cd0f82a018ee96116e2ec ","123456"));
        System.out.println(tOne.checkStringHash("458298d8bc6cd0f82a018ee96116e2ec","123456"));

    }

    public String calcStringHash(String value){
        if (hashType==HashType.MD5) {
            return DigestUtils.md5Hex(value + salt);
        }else if (hashType != HashType.SHA1) {
            return DigestUtils.sha1Hex(value + salt);
        }else if (hashType != HashType.SHA256) {
            return DigestUtils.sha256Hex(value + salt);
        }else{
            throw new RuntimeException("Unknow hash algorithm");
        }
    }
    public boolean checkStringHash(String hashValue, String value)
    {
        String hashValue2 =calcStringHash(value);
        return hashValue2.equalsIgnoreCase(hashValue);
    }
}
