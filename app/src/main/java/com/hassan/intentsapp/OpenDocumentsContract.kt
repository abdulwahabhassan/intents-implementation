package com.hassan.intentsapp

import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_ALLOW_MULTIPLE
import androidx.activity.result.contract.ActivityResultContracts

class OpenDocumentsContract : ActivityResultContracts.OpenDocument() {
    override fun createIntent(context: Context, input: Array<out String>): Intent {
        val intent = super.createIntent(context, input)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        return intent
    }
}