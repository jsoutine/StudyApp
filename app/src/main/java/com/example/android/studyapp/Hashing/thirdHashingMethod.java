package com.example.android.studyapp.Hashing;


import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

//PBKDF2 stands for Password-based-Key-Derivative-Function
//HMAC stands for Keyed-Hash Message Authentication Code

// hashing using PBKDF2WithHmacSHA512

public class thirdHashingMethod {

    public static String generateHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte [] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException{
        SecureRandom random = SecureRandom.getInstance("SHA512PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static String toHex (byte[] array) throws NoSuchAlgorithmException{
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length*2) - hex.length();
        if (paddingLength > 0){
            return String.format("%0" + paddingLength + "d",0) + hex;
        }else {
            return hex;
        }
    }

    //restoring hashed data
    public static boolean validatePin(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String [] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte [] salt = fromHex(parts[1]);
        byte [] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length*8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte [] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff ==0;
    }

    private static byte[] fromHex(String hex){
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
