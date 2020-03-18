package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
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

    int i = 0;
    boolean onScreen = false;
    boolean flipped = false;
    int correct = 0;
    int total = 0;
    String question;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);

        resetCard();
        results();
    }

    public void cycleDeck() {
        try {
            question = DeckMenu.cardDeck.get(i).getQuestion();
            answer = DeckMenu.cardDeck.get(i).getAnswer();
            i++;
        } catch (IndexOutOfBoundsException e) {
            Toast toast = Toast.makeText(this, "Congratulations, you guessed " + correct + " of " + total +" answers correctly!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            finish();
        }
    }


    public void playSwoosh(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.swoosh);
        mediaPlayer.start();
    }

    public void playSwirl(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.swirl);
        mediaPlayer.start();
    }

    public void resetCard() {

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

        cardText.setX(-1800);
        cardText.setY(300);
        cardText2.setY(300);

        cardImage.animate().rotation(-1800).setDuration(0);
        cardText.animate().rotation(-1800).setDuration(0);
        cardText2.animate().rotation(-1800).setDuration(0);
    }

    public void results() {

        TextView resultText = (TextView) findViewById(R.id.resultText);
        String resultsString = "You have made " + correct + " out of " + total + " correct guesses";

        resultText.setText(resultsString);
    }

    public void slide(View view) {

        Log.i("Info", "New card pressed");

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);

        cycleDeck();


        if (!onScreen) {

            onScreen = true;
            resetCard();
            cardText.setText(question);
            cardImage.animate().translationXBy(2050).setDuration(500);
            cardText.animate().translationXBy(2300).setDuration(500);
            playSwoosh(view);
        }
    }

    public void flip(View view) {

        Log.i("Info", "Card pressed");

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);

        if (!flipped) {
            flipped = true;

            cardImage.animate().rotation(720).setDuration(1000);
            cardText.animate().rotation(720).setDuration(1000);
            cardText2.animate().rotation(720).setDuration(1000);

            cardText.animate().alpha(0).setDuration(1000);
            cardText2.animate().alpha(1).setDuration(1000);
            playSwirl(view);

        } else {

            flipped = false;

            cardImage.animate().rotation(-720).setDuration(1000);
            cardText.animate().rotation(-720).setDuration(1000);
            cardText2.animate().rotation(-720).setDuration(1000);

            cardText.animate().alpha(1).setDuration(1000);
            cardText2.animate().alpha(0).setDuration(1000);
            playSwirl(view);
        }
    }

    public void correctClick(View view) {

        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardText = (TextView) findViewById(R.id.cardText);
        TextView cardText2 = (TextView) findViewById(R.id.cardText2);

        if (onScreen) {

            if (flipped) {

                onScreen = false;
                flipped = false;
                correct++;
                total++;

                cardImage.animate().translationYBy(-2000).setDuration(500);
                cardText.animate().translationYBy(-2000).setDuration(500);
                cardText2.animate().translationYBy(-2000).setDuration(500);
                playSwoosh(view);
                results();

            } else {
                Toast toast = Toast.makeText(this, "Press the card to see the answer", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        }
    }

    public void wrongClick(View view) {
        if (onScreen && flipped) {
            correct--;
            results();
        }
        correctClick(view);
    }
}
