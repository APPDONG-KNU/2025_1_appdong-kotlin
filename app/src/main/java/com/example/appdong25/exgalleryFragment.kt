package com.example.appdong25

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class ExgalleryFragment : Fragment(R.layout.fragment_gallery) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 뒤로가기 버튼 클릭 리스너
        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            // 이전 Fragment로 돌아가기
            requireActivity().supportFragmentManager.popBackStack()
        }

        val imageViews = listOf(
            R.id.img1 to R.drawable.ad1,
            R.id.img2 to R.drawable.ad2,
            R.id.img3 to R.drawable.ad3,
            R.id.img4 to R.drawable.ad4,
            R.id.img5 to R.drawable.ad5,
            R.id.img6 to R.drawable.ad6,
            R.id.img7 to R.drawable.ad7,
            R.id.img8 to R.drawable.ad8,
            R.id.img9 to R.drawable.ad9
        )

        imageViews.forEach { (viewId, drawableId) ->
            view.findViewById<ImageView>(viewId).setOnClickListener {
                val fullscreen = FullscreenImageFragment.newInstance(drawableId)
                fullscreen.show(parentFragmentManager, "fullscreen")
            }
        }
    }
}
