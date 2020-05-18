package com.example.android.studyapp.Events;

import android.content.Intent;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.*;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//@RunWith(AndroidJUnit4.class)

@LargeTest
public class AddCourseTest {

    @Rule
    public ActivityTestRule<AddCourse> activityRule =
           new ActivityTestRule<>(AddCourse.class);

    @Test
    public void onCreate() {
        onView(withHint("name of course")).check(matches(isDisplayed()));
    }

    @Test
    public void addCourseButton() {
        onView(withText("ADD COURSE"))
                .check(matches(isDisplayed()));
        onView(withId(R.id.addButton))
                .check(matches(isClickable()))
                .perform(click());
    }
}