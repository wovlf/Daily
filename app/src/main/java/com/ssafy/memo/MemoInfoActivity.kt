package com.ssafy.memo

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssafy.memo.databinding.ActivityMemoInfoBinding

class MemoInfoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMemoInfoBinding
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memoList = intent.getStringArrayListExtra("memoList")?: arrayListOf()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memoList)

        binding.listview.adapter = adapter

        binding.returnBtn.setOnClickListener {
            finish()
        }
    }
}