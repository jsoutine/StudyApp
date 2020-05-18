package com.example.android.studyapp;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class RegisterAccountTest {

    @Rule
    public ActivityTestRule<RegisterAccount> activityRule =
            new ActivityTestRule<>(RegisterAccount.class);

    @Test
    public void testTextFieldsFunction() {
        onView(withId(R.id.usernameTextField))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.regEmail))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.regPW))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.verRegPW))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.firstNameEditText))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
        onView(withId(R.id.lastNameEditText))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
    }

    @Test
    public void testTextFieldsInput() {
        onView(withId(R.id.usernameTextField))
                .perform(typeText("The Tester"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.regEmail))
                .perform(typeText("test@test.com"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.regPW))
                .perform(typeText("123test"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.verRegPW))
                .perform(typeText("123test"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.lastNameEditText))
                .perform(typeText("Testsson"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.firstNameEditText))
                .perform(typeText("Testy"))
                .perform(ViewActions.closeSoftKeyboard());
    }

    @Test
    public void registerBtnPressed() {
        onView(withId(R.id.createAccButton))
                .check(matches(isClickable()))
                .check(matches(isCompletelyDisplayed()))
                .check(matches(isEnabled()));
    }
}