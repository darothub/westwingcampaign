package com.assessment.westwingcampaign.ui.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import com.assessment.westwingcampaign.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class LandingFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        hiltRule.inject()
        launchFragmentInHiltContainer<LandingFragment> {}
    }

    @Test
    fun testThatLandingFragmentIsLaunched() {
        onView(allOf(withId(R.id.landing_layout), isDisplayed()))
    }

    @Test
    fun testRecyclerviewIsDisplayed() {
        onView(allOf(withId(R.id.campaign_list_rcv), isDisplayed())).perform(click())
    }
}
