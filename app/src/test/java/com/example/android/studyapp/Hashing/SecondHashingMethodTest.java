package com.example.android.studyapp.Hashing;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class SecondHashingMethodTest {

    SecondHashingMethod secHash = new SecondHashingMethod();

    @Test
    public void generateHashTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String expected = "1000";
        String actual = SecondHashingMethod.generateHash("").substring(0,4);
        assertEquals(expected, actual);
    }
}