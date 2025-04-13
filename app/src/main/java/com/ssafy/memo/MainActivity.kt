package com.ssafy.memo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.memo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val memoList = arrayListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        binding.editBtn.setOnClickListener {
            var intent = Intent(this, MemoEditActivity::class.java)
            memoResultLauncher.launch(intent)
        }

        binding.infoBtn.setOnClickListener {
            var intent = Intent(this, MemoInfoActivity::class.java)
            intent.putStringArrayListExtra("memoList", memoList)
            startActivity(intent)
        }
    }

    val memoResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if(result.resultCode == RESULT_OK){
            val memo = result.data?.getStringExtra("memo")
            if(memo != null){
                memoList.add(memo)
                adapter.notifyDataSetChanged()
            }
        }
    }
}


