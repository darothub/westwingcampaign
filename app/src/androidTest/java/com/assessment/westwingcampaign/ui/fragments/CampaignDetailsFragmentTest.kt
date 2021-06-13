package com.assessment.westwingcampaign.ui.fragments

import android.os.Bundle
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.assessment.westwingcampaign.HiltTestActivity
import com.assessment.westwingcampaign.R
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test

class CampaignDetailsFragmentTest : TestCase() {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<HiltTestActivity> =
        ActivityScenarioRule(HiltTestActivity::class.java)

    @ExperimentalCoroutinesApi
    public override fun setUp() {
        super.setUp()

        launchFragmentInHiltContainer<CampaignDetailsFragment>(fragmentArgs = Bundle()) {}
    }

    @Test
    fun testThatCampaignDetailFragmentIsLaunched() {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.campaign_detail_layout),
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun testRecyclerviewIsDisplayed() {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.campaign_details_vp2),
                ViewMatchers.isDisplayed()
            )
        ).perform(ViewActions.click())
    }
}
