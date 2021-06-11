package com.assessment.westwingcampaign.utils

import androidx.fragment.app.Fragment

fun Fragment.checkOrientation(): Int {
    return resources.configuration.orientation
}
