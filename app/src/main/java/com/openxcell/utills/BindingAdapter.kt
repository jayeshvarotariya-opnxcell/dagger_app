package com.openxcell.utills

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import com.openxcell.daggerapplication.R


@BindingAdapter("snackBar")
fun setSnackBar(view: View, message: String? ) {

    message?.let {
        val snackbar = Snackbar.make(view, "" + message, Snackbar.LENGTH_LONG)
        // Get the Snackbar's layout view
        val layout = snackbar.view as Snackbar.SnackbarLayout
        layout.setBackgroundResource(R.color.red)
        snackbar.show()
    }

}
