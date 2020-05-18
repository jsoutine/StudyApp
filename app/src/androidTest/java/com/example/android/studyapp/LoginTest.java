package com.example.android.studyapp;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

public class LoginTest {

    @Rule
    public ActivityTestRule<Login> activityRule =
            new ActivityTestRule<>(Login.class);

    @Test
    public void onCreate() {
        onView(withId(R.id.login))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.register))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
    }

    @Test
    public void mainActivityBtnPressed() {
        onView(withId(R.id.username))
                .perform(typeText("tessst"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(typeText("password"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.login))
                .perform(click());
    }

    @Test
    public void registerBtnPressed() {
        onView(withId(R.id.login))
                .perform(click());
    }
}