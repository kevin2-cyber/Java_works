package com.codelab.buildandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codelab.buildandroid.databinding.ActivitySignInBinding
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult

class SignInActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivitySignInBinding

    // ActivityResultLauncher
    // TODO: Implement

    // Firebase instance variables
    // TODO: implement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FirebaseAuth
        // TODO: implement
    }

    public override fun onStart() {
        super.onStart()
        // TODO: Implement
    }

    private fun signIn() {
        // TODO: implement
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        // TODO: implement
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    companion object {
        private const val TAG = "SignInActivity"
    }
}