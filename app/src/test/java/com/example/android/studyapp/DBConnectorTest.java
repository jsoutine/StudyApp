package com.example.android.studyapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectorTest {

    @Test
    public void getInstance() {
        String actualInstance = DBConnector.getInstance().toString().substring(0,40);
        String expectedInstance = "com.example.android.studyapp.DBConnector";

        assertEquals(expectedInstance, actualInstance);
    }
}
