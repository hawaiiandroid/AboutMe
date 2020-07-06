package io.github.hawaiiandroid.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.github.hawaiiandroid.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName(name = "Tim Wagner")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener { addNickname() }
        binding.nicknameText.setOnClickListener { updateNickname() }
    }

    /**
     * Übernimmt den Spitznamen und blendet das Eingabeelement inkl. Button
     * aus und das versteckte Textelement ein
     * @param view Der "Fertig"-Knopf
     */
    fun addNickname() {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Ausblenden der Tastatur
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(binding.nicknameEdit.windowToken, 0)
    }

    /**
     * Aktualisiert den Spitznamen nach dem Klick auf das Textelement
     * @param view das Textelement
     */
    fun updateNickname() {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE
        binding.doneButton.visibility = View.VISIBLE

        // Setzen des Fokus auf das Eingabefeld
        binding.nicknameEdit.requestFocus()

        // Einblenden der Tastatur
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(binding.nicknameEdit, 0)
    }
}