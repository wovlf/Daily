package com.ssafy.memo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.ssafy.memo.Util.Utils
import com.ssafy.memo.databinding.ActivityMemoEditBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

private const val TAG = "싸피"
class MemoEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode = intent.getStringExtra("flag") // create or edit
        val title = intent.getStringExtra("title")?:""
        val content = intent.getStringExtra("content")?:""
        val regDate = intent.getStringExtra("regDate")?:""
        val position = intent.getIntExtra("position", -1)
        if(mode == "create"){
            binding.time.visibility = View.GONE
            binding.timeText.visibility = View.GONE
            binding.deleteBtn.visibility = View.GONE
        } else {
            binding.todayText.setText(title)
            binding.infoText.setText(content)
            binding.timeText.setText(regDate)
        }


        binding.saveBtn.setOnClickListener {

            val title = binding.todayText.text.toString()
            val content = binding.infoText.text.toString()
            val regDate = Utils.getTime()

            if(title.isNotEmpty() && content.isNotEmpty()){
                if(mode == "create"){
                    MemoItemMgr.add(MemoItem(title, content, regDate))
                }else{
                    MemoItemMgr.update(position, MemoItem(title, content, regDate))
                }
                setResult(RESULT_OK)
                finish()
            }else{
                Toast.makeText(this, "제목 또는 내용을 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.deleteBtn.setOnClickListener {
            MemoItemMgr.remove(position)
            Log.d(TAG, "onCreate: $position")
            setResult(RESULT_OK)
            finish()
        }

        binding.cancelBtn.setOnClickListener {
            finish()
        }
    }
}