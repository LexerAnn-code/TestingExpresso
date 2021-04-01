package com.app.testingexpresso


import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BasicSample {
   //string to be typed
    private lateinit var stringToBeTyped:String

    //Define the activity to test
    @get:Rule
    var activityRule:ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString(){
        stringToBeTyped="Expresso"
    }

    @Test
    fun change_text_test(){
     //Type text and click on button
        onView(ViewMatchers.withId(R.id.name_input))
            .perform(ViewActions.typeText(stringToBeTyped))

        onView(ViewMatchers.withId(R.id.sign))
            .perform(ViewActions.click())


        //Validation
        onView(ViewMatchers.withId(R.id.textToChange))
            .check(ViewAssertions.matches(ViewMatchers.withText(stringToBeTyped)))
    }



}