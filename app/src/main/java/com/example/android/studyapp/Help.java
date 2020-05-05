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

import java.net.URISyntaxException;

public class Help extends AppCompatActivity {

    Activity startSwish = new Activity();
    Context swishContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

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

                openSwishWithToken(swishContext, "c28a4061470f4af48973bd2a4642b4fa", "merchant%253A%252F%252F");
            }
        });
    }


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


    public static boolean openSwishWithToken(Context context, String token, String callBackUrl) {
        if ( token == null
                || token.length() == 0
                || callBackUrl == null
                || callBackUrl.length() == 0
                || context == null) {
            return false;
        }

        // Construct the uri
        // Note that appendQueryParameter takes care of uri encoding
        // the parameters
        Uri url = new Uri.Builder()
                .scheme("swish")
                .authority("paymentrequest")
                .appendQueryParameter("token", token)
                .appendQueryParameter("callbackurl", callBackUrl)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        intent.setPackage("se.bankgirot.swish");

        try {
            context.startActivity(intent);
        } catch (Exception e){
            // vet ej varför jag skriver detta
            return false;
        }

        return true;
    }


}
