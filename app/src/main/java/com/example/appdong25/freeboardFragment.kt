package com.example.appdong25

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import java.time.LocalDate

class FreeboardFragment : Fragment(R.layout.fragment_freeboard) {
    private val posts = mutableListOf<Post>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val titleInput = view.findViewById<EditText>(R.id.titleInput)
        val contentInput = view.findViewById<EditText>(R.id.contentInput)
        val postButton = view.findViewById<Button>(R.id.postButton)
        val postList = view.findViewById<LinearLayout>(R.id.postList)

        postButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val content = contentInput.text.toString().trim()
            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(context, "제목과 내용을 모두 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val post = Post(title, content)
            posts.add(0, post) // 최신 글이 위로
            renderPosts(postList)
            titleInput.text.clear()
            contentInput.text.clear()
        }
    }

    private fun renderPosts(container: LinearLayout) {
        container.removeAllViews()
        for (post in posts) {
            val postView = layoutInflater.inflate(R.layout.item_post, container, false)
            postView.findViewById<TextView>(R.id.postTitle).text = "📝 ${post.title}"
            postView.findViewById<TextView>(R.id.postMeta).text = "${post.author} | ${post.date}"
            postView.findViewById<TextView>(R.id.postContent).text = post.content
            container.addView(postView)
        }
    }
}

data class Post(
    val title: String,
    val content: String,
    val author: String = "익명",
    val date: String = LocalDate.now().toString()
)
