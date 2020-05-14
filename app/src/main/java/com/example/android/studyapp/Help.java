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

                launchSwish();

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


    public void launchSwish () {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("se.bankgirot.swish");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }

}
