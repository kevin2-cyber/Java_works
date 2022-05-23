package com.codelab.buildandroid

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codelab.buildandroid.MainActivity.Companion.ANONYMOUS
import com.codelab.buildandroid.databinding.ImageMessageBinding
import com.codelab.buildandroid.databinding.MessageBinding
import com.codelab.buildandroid.model.FriendlyMessage
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class FriendlyMessageAdapter(
    private val options: FirebaseRecyclerOptions<FriendlyMessage>,
    private val currentUserName: String?
)
    : FirebaseRecyclerAdapter<FriendlyMessage, RecyclerView.ViewHolder>(options){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return if (viewType == VIEW_TYPE_TEXT) {
                val view = inflater.inflate(R.layout.message, parent, false)
                val binding = MessageBinding.bind(view)
                MessageViewHolder(binding)
            } else {
                val view = inflater.inflate(R.layout.image_message, parent, false)
                val binding = ImageMessageBinding.bind(view)
                ImageMessageViewHolder(binding)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, model: FriendlyMessage) {
        if (options.snapshots[position].text != null) {
            (holder as MessageViewHolder).bind(model)
        } else {
            (holder as ImageMessageViewHolder).bind(model)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (options.snapshots[position].text != null) VIEW_TYPE_TEXT else VIEW_TYPE_IMAGE
    }

    inner class MessageViewHolder(private val binding: MessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FriendlyMessage) {
            //TODO: implement
        }

        private fun setTextColor(userName: String?, textView: TextView) {
            if (userName != ANONYMOUS && currentUserName == userName && userName != null) {
                textView.setBackgroundResource(R.drawable.rounded_message_blue)
                textView.setTextColor(Color.WHITE)
            } else {
                textView.setBackgroundResource(R.drawable.rounded_message_gray)
                textView.setTextColor(Color.BLACK)
            }
        }
    }

    inner class ImageMessageViewHolder(private val binding: ImageMessageBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: FriendlyMessage) {
                    //TODO: implement
                }
            }

    private fun loadImageIntoView(view: ImageView, url: String) {
        if (url.startsWith("gs://")) {
            val storageReference = Firebase.storage.getReferenceFromUrl(url)
            storageReference.downloadUrl
                .addOnSuccessListener { uri ->
                    val downloadUrl = uri.toString()
                    Glide.with(view.context)
                        .load(downloadUrl)
                        .into(view)
                }
                .addOnFailureListener { e ->
                    Log.w(
                        TAG,
                        "Getting download url was not successful.",
                        e
                    )
                }
        } else {
            Glide.with(view.context).load(url).into(view)
        }
    }

    companion object {
        const val TAG = "MessageAdapter"
        const val VIEW_TYPE_TEXT = 1
        const val VIEW_TYPE_IMAGE = 2
    }
}