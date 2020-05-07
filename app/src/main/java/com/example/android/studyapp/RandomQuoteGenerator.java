package com.example.android.studyapp;

import java.util.Random;

public class RandomQuoteGenerator {
    public static String quoteGenerator () {
        Random random = new Random();
        String[] quotesList = new String[8];
        int randomNumber = random.nextInt(quotesList.length);

        quotesList [0] = "Any fool can know. The point is to understand.\n\n- Albert Einstein";
        quotesList [1] = "I did then what i know how to do. Now that i know better, i do better.\n\n-Maya Agelou";
        quotesList [2] = "Hold fast to dreams,\nFor if dreams die\nLife is a broken-winged bird,\nThat cannot fly.\n\n- Langston Hughes";
        quotesList [3] = "Knowledge is love and light and vision.\n\n- Helen Keller";
        quotesList [4] = "The secret of success is to do the common things uncommonly well.\n\n- John D.Rockefeller";
        quotesList [5] = "I find the harder i work, the more luck i seem to have.\n\n- Thomas Jefferson";
        quotesList [6] = "To acquire knowledge, one must study; but to acquire wisdom, one must observe.\n\n- Marilyn vos Savant";
        quotesList [7] = "Every beginner possesses a great potential to be an expert in his or her chosen field.\n\n- Lailah Gifty Akita";

        return quotesList[randomNumber];
    }
}