package com.assessment.westwingcampaign.utils

import androidx.fragment.app.Fragment

fun Fragment.checkOrientation(): Int {
    return resources.configuration.orientation
}
const val LIST_VIEW = 0
const val SINGLE_VIEW = 1
