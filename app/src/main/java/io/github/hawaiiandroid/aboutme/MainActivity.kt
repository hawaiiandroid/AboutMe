package io.github.hawaiiandroid.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{ updateNickname(it) }
    }

    /**
     * Übernimmt den Spitznamen und blendet das Eingabeelement + Button aus und das Textelement ein
     * @param view Der Fertig-Button
     */
    fun addNickname(view: View) {
        val nicknameEdit = findViewById<EditText>(R.id.nicknameEdit)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        nicknameText.text = nicknameEdit.text
        nicknameEdit.visibility = View.GONE

        view.visibility = View.GONE

        nicknameText.visibility = View.VISIBLE

        // Ausblenden der Tastatur
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * Aktualisiert den Spitznamen nach dem Klick auf das Textelement
     * @param view das Textelement
     */
    fun updateNickname(view: View) {
        val nicknameEdit = findViewById<EditText>(R.id.nicknameEdit)
        val doneButton = findViewById<Button>(R.id.done_button)

        nicknameEdit.visibility = View.VISIBLE
        view.visibility = View.GONE
        doneButton.visibility = View.VISIBLE

        // Setzen des Fokus auf das Eingabefeld
        nicknameEdit.requestFocus()

        // Einblenden der Tastatur
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(nicknameEdit, 0)
    }
}