package com.rk.rgr_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class GameFragment : Fragment(R.layout.fragment_game), GameDialogFragment.GameDialogListener {
    private val words = listOf("android", "kotlin", "fragment", "view")
    private var currentWord = ""
    private lateinit var textView: TextView
    private lateinit var input: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView = view.findViewById(R.id.wordTextView)
        input = view.findViewById(R.id.editGuess)
        button = view.findViewById(R.id.buttonSubmit)
        generateWord()

        button.setOnClickListener {
            val guess = input.text.toString()
            if (guess.equals(currentWord, true)) {
                GameDialogFragment.newInstance("Correct!").show(childFragmentManager, "result")
                generateWord()
            } else {
                GameDialogFragment.newInstance("Try again").show(childFragmentManager, "result")
            }
        }
    }

    private fun generateWord() {
        currentWord = words.random()
        textView.text = currentWord.toCharArray().apply { shuffle() }.concatToString()
    }

    override fun onDialogDismissed() {}
}
