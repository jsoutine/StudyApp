package com.example.android.studyapp.Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

// using hash method MD5
// without salting
public class FirstHashingMethod {

    private String algorithm = "MD5";

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String generateHash(String data, String algorithm, byte [] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.reset();
        md.update(salt);
        byte[] hash = md.digest(data.getBytes());
        return byteToStringHex(hash);
    }


    private static String byteToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    public byte[] getSalt() {
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }
}
