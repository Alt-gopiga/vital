package utilities;

import org.apache.commons.codec.binary.Base64;

public class Encryption {

    //This method is to encrypt password
    public static String encryptPassword(String password){
        byte[] encodedPwdBytes= Base64.encodeBase64(password.getBytes());
        String encodedPwd=new String(encodedPwdBytes);
        return encodedPwd;
    }

    //This method is to decrypt password
    public static String decryptPassword(String password){
        byte[] decodedPwdBytes= Base64.decodeBase64(password.getBytes());
        String decodedPwd=new String(decodedPwdBytes);
        return decodedPwd;
    }

}
