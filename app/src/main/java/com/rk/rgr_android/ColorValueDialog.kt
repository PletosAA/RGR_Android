package com.rk.rgr_android

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class ColorValueDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val value = arguments?.getInt("value") ?: 0
        return AlertDialog.Builder(requireContext())
            .setTitle("Item Value")
            .setMessage("Value: $value")
            .setPositiveButton("OK", null)
            .create()
    }

    companion object {
        fun newInstance(value: Int): ColorValueDialog {
            val fragment = ColorValueDialog()
            fragment.arguments = bundleOf("value" to value)
            return fragment
        }
    }
}