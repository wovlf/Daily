package com.ssafy.memo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssafy.memo.databinding.ActivityMemoEditBinding

class MemoEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_edit)
        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val today_memo = binding.todayText.text.toString()
            val info_memo = binding.infoText.text.toString()
            if(today_memo.isNotEmpty() && info_memo.isNotEmpty()){
                val intent = Intent()
                intent.putExtra("memo", info_memo)
                setResult(RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "메모를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.cancelBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}