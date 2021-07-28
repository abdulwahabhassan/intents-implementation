package com.hassan.intentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar
import com.hassan.intentsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedImageView: ShapeableImageView
    private lateinit var imageUriTextView : TextView
    //we register a contract to open gallery when openDocument is launched and make use of
    //the uri in the ActivityResultCallback that is returned when the activity we started via an
    //Intent in our OpenDocument contract returns its result
    private val openDocument = registerForActivityResult(OpenDocumentsContract()) { uri ->
        Snackbar.make(binding.root, "Image $uri selected", Snackbar.LENGTH_LONG).show()
        Glide.with(this).load(uri).into(selectedImageView)
        imageUriTextView.text = uri.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selectedImageView = binding.selectedImageView
        imageUriTextView = binding.imageUriTextView


        binding.openGalleryTextView.setOnClickListener {
            //This executes the openDocument contract, taking an array input of string defining the
            //type of our result to be used in the contract
            openDocument.launch(arrayOf("image/*"))
        }
    }


}
