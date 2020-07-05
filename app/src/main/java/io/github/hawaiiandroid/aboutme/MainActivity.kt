package io.github.hawaiiandroid.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}