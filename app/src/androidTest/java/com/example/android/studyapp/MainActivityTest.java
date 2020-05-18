package com.example.android.studyapp;

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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onCreate() {

        onView(withId(R.id.personalButton))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.eventsButton))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.toolsButton2))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.buttonCalendar))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

        onView(withId(R.id.helpButton))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));

    }

    @Test
    public void personalClick() {
        onView(withId(R.id.personalButton))
                .perform(click());
    }

    @Test
    public void eventClick() {
        onView(withId(R.id.eventsButton))
                .perform(click());
    }

    @Test
    public void toolsClick() {
        onView(withId(R.id.toolsButton2))
                .perform(click());
    }

    @Test
    public void helpClick() {
        onView(withId(R.id.helpButton))
                .perform(click());
    }

    @Test
    public void calendarClick() {
        onView(withId(R.id.buttonCalendar))
                .perform(click());
    }
}