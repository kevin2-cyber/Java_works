package com.codelab.buildandroid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.codelab.buildandroid.databinding.ActivityMainBinding
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding : ActivityMainBinding
    private lateinit var manager: LinearLayoutManager

    private val openDocument = registerForActivityResult(MyOpenDocumentContract()) { uri ->
        onImageSelected(uri)
    }

    // TODO: implement Firebase instance variables
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth and check if the user is signed in
        // TODO: implement

        // Initialize Realtime Database and FirebaseRecyclerAdapter
        // TODO: implement

        // Disable the send button when there's no text in the input field
        // See MyButtonObserver for details
        binding.messageEditText.addTextChangedListener(MyButtonObserver(binding.sendButton))

        // When the send button is clicked, send a text message
        // TODO: implement

        // When the image button is clicked, launch the image picker
        binding.addMessageImageView.setOnClickListener{
            openDocument.launch(arrayOf("image/*"))
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in
        //TODO: implement
    }

    public override fun onPause() {
        super.onPause()
    }

    public override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sign_out_menu -> {
                signOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onImageSelected(uri: Uri) {
        //TODO: implement
    }

    private fun putImageInStorage(storageReference: StorageReference, uri: Uri, key: String?) {
        // Upload the image to cloud storage
        //TODO: implement
    }

    private fun signOut() {
        //TODO: implement
    }

    companion object {
        private const val TAG = "MainActivity"
        const val MESSAGES_CHILD = "messages"
        const val ANONYMOUS = "anonymous"
        private const val LOADING_IMAGE_URL = "https://www.google.com/images/spin-32.gif"
    }
}