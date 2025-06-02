package com.rk.rgr_android

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class GameDialogFragment : DialogFragment() {
    interface GameDialogListener {
        fun onDialogDismissed()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val message = arguments?.getString("message") ?: ""
        return AlertDialog.Builder(requireContext())
            .setMessage(message)
            .setPositiveButton("OK") { _, _ ->
                (parentFragment as? GameDialogListener)?.onDialogDismissed()
            }
            .create()
    }

    companion object {
        fun newInstance(message: String): GameDialogFragment {
            val fragment = GameDialogFragment()
            fragment.arguments = bundleOf("message" to message)
            return fragment
        }
    }
}