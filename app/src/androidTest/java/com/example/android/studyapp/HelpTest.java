package com.example.android.studyapp;

import android.content.Intent;

import com.example.android.studyapp.Events.AddCourse;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

public class HelpTest {

    @Rule
    public ActivityTestRule<Help> activityRule =
            new ActivityTestRule<>(Help.class);

    @Test
    public void onCreate() {
        onView(withId(R.id.btnCallUs))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.btnEmailUs))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.btntipToTeam))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));;
    }

    @Test
    public void dialContactPhone() {
        onView(withId(R.id.btnCallUs))
                .perform(click());
    }

    @Test
    public void emailUs() {
        onView(withId(R.id.btnEmailUs))
                .perform(click());
    }

    @Test
    public void launchSwish() {
        ;
    }
}