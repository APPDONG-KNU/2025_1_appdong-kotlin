package com.example.appdong25

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.DialogFragment

class FullscreenImageFragment : DialogFragment() {

    companion object {
        private const val ARG_IMAGE_RES_ID = "imageResId"

        fun newInstance(imageResId: Int): FullscreenImageFragment {
            val fragment = FullscreenImageFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES_ID, imageResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: 0

        val imageView = ImageView(requireContext()).apply {
            setImageResource(imageResId)
            adjustViewBounds = true
            scaleType = ImageView.ScaleType.FIT_CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val dialog = Dialog(requireContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(imageView)

        imageView.setOnClickListener {
            dismiss() // 클릭 시 닫기
        }

        return dialog
    }
}