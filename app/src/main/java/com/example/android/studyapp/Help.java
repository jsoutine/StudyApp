package com.example.android.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.studyapp.Hashing.FirstHashingMethod;
import com.example.android.studyapp.Hashing.SecondHashingMethod;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Help extends AppCompatActivity {

    Activity startSwish = new Activity();
    Context swishContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
//        ---------- DETTA VAR FÖR TESTA FÖR MÖTE 3 ------------
//        String test = "hejsebastianhej";
//        System.out.println(test);
//        try {
//            String a = testHashingMethod(test);
//            System.out.println("testing SHA1");
//            System.out.println(a);
//            System.out.println(testReHashingMethod(test, a));
//            System.out.println(testReHashingMethod("hej", a));
//            System.out.println("----testing MD5----");
//            System.out.println(testingMD5(test));
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        //        ---------- DETTA VAR FÖR TESTA FÖR MÖTE 3 ------------

        Button btnPhoneCall = (Button) findViewById(R.id.btnCallUs);
        Button emailUs = (Button) findViewById(R.id.btnEmailUs);
        Button tipTheTeam = (Button) findViewById(R.id.btntipToTeam);

        btnPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialContactPhone("0733719883");
            }
        });

        emailUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailUs();
            }
        });

        tipTheTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchSwish();

            }
        });
    }

//    public String testHashingMethod(String pw) throws InvalidKeySpecException, NoSuchAlgorithmException {
//       String methoddone = SecondHashingMethod.generateHash(pw);
//        return methoddone;
//    }
//    public String testReHashingMethod(String originalPw, String storedPw) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        boolean testReHashing = SecondHashingMethod.validatePin(originalPw, storedPw);
//        String testme = Boolean.toString(testReHashing);
//        return testme;
//    }
//    public String testingMD5(String pw) throws NoSuchAlgorithmException {
//        byte[] salt = FirstHashingMethod.getSalt();
//        String testMD5 = FirstHashingMethod.generateHash(pw,"MD5", salt);
//        return testMD5;
//    }

    public void dialContactPhone(final String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0733719883"));
        startActivity(intent);
    }

    public void emailUs() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "tobiasgustaverik@icloud.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Text here");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {

        }
    }


    public void launchSwish () {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("se.bankgirot.swish");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }

}
