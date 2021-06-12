package com.darotpeacedude.core.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.assessment.westwingcampaign.R

/**
 * Get any name
 * @return
 */
fun Any.getName(): String = this::class.qualifiedName!!

/**
 * Hide view
 *
 */
fun View.hide(): Boolean {
    if (this.visibility == View.VISIBLE || this.visibility == View.INVISIBLE) {
        this.visibility = View.GONE
        return true
    }
    return false
}

/**
 * Show view
 *
 */
fun View.show(): Boolean {
    if (this.visibility == View.INVISIBLE || this.visibility == View.GONE) {
        this.visibility = View.VISIBLE
        return true
    }
    return false
}
/**
 * Navigate to destination id
 *
 * @param destinationId
 */
fun Fragment.goto(destinationId: Int) {
    findNavController().navigate(destinationId)
}

/**
 * Navigate to destination id
 *
 * @param direction
 */
fun Fragment.goto(direction: NavDirections) {
    Navigation.findNavController(requireView()).navigate(direction)
}

/**
 * Navigate up
 *
 */
fun Fragment.gotoUp() {
    Navigation.findNavController(requireView()).navigateUp()
}

fun Activity.hideSystemUI() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.setDecorFitsSystemWindows(false)
        window.insetsController?.let {
            it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
        }
    } else {
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
