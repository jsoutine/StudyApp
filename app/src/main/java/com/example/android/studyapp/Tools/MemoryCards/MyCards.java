package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.studyapp.R;

public class MyCards extends AppCompatActivity {

    boolean onScreen = false;
    boolean flipped = false;
    int correct;
    int incorrect;
    String question = "Hur långt är ett snöre?";
    String answer = "Fem meter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);

        resetCard();
    }

    public void resetCard (){

        flipped = false;

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);

        cardText.setText(question);
        cardText.setAlpha(1);
        cardText2.setText(answer);
        cardText2.setAlpha(0);

        cardImage.setY(0);
        cardImage.setX(-2000);

        cardText.setX(-2000);
        cardText.setY(300);

        cardText2.setY(300);

        cardImage.animate().rotation(-1800).setDuration(0);
        cardText.animate().rotation(-1800).setDuration(0);
        cardText2.animate().rotation(-1800).setDuration(0);
    }

    public void slide(View view){

        Log.i("Info", "New card pressed");

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);


        if(!onScreen){

            onScreen = true;
            resetCard();
            cardText.setText(question);
            cardImage.animate().translationXBy(2050).setDuration(500);
            cardText.animate().translationXBy(2300).setDuration(500);
        }
    }

    public void flip (View view){

        Log.i("Info", "Card pressed");

        flipped = true;

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);

        cardImage.animate().rotation(720).setDuration(1000);
        cardText.animate().rotation(720).setDuration(1000);
        cardText2.animate().rotation(720).setDuration(1000);

        cardText.animate().alpha(0).setDuration(1000);
        cardText2.animate().alpha(1).setDuration(1000);
    }

    public void correctClick(View view) {

        correct++;

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);



        if (onScreen) {

            if (flipped) {

            onScreen = false;

            cardImage.animate().translationYBy(-2000).setDuration(500);
            cardText.animate().translationYBy(-2000).setDuration(500);
            cardText2.animate().translationYBy(-2000).setDuration(500);

            } else {
                Toast toast = Toast.makeText(this, "Press the card to see the answer", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        }
    }

    public void wrongClick(View view) {
        correctClick(view);
        correct --;
        incorrect ++;
    }
}
