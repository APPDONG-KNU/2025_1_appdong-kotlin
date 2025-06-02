package com.example.appdong25

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdong25.ui.theme.Appdong25Theme

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity_main.xml을 사용한다고 가정

        val textView2 = findViewById<TextView>(R.id.gal_btn)
        textView2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,galleryFragment())
                .addToBackStack(null)
                .commit()
        }

        // 텍스트 클릭 이벤트 설정
        val goToCalendarText: TextView = findViewById(R.id.cal_btn)
        goToCalendarText.setOnClickListener {
            openCalendarFragment()
        }

        // 버튼 클릭 이벤트 설정 (Toast 메시지 표시)
        val showToastButton: Button = findViewById(R.id.showToastButton) // showToastButton이 XML에 있어야 함
        showToastButton.setOnClickListener {
            Toast.makeText(this, "Toast 버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show()
        }

        val instaButton : Button = findViewById(R.id.insta_btn)
        instaButton.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/knu.appdong?igsh=dGc4YtoZnMzYnJv/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }

    // CalendarFragment로 이동하는 메소드
    private fun openCalendarFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val calendarFragment = Excalendar()  // CalendarFragment 인스턴스 생성
        transaction.replace(R.id.fragment_container, calendarFragment)  // 기존 프래그먼트를 교체
        transaction.addToBackStack(null)  // 백스택에 추가 (뒤로 가기 가능)
        transaction.commit()
    }
}