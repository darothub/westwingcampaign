package com.assessment.westwingcampaign.utils.extensions

/**
 * Get any name
 * @return
 */
fun Any.getName(): String = this::class.qualifiedName!!
