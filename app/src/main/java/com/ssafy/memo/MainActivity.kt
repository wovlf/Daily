package com.ssafy.memo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.memo.Util.Utils
import com.ssafy.memo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<MemoItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //초기 데이터 설정
        MemoItemMgr.add(MemoItem("메모 앱 만들기 1", "123123", Utils.getTime()))

        //listView 연결
        listView = binding.listview
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MemoItemMgr.getList())
        listView.adapter = adapter

        // listview를 클릭했을 때
        binding.listview.setOnItemClickListener{parent, view, position, id ->
            val selectedMemo = MemoItemMgr.search(position)
            val intent = Intent(this, MemoEditActivity::class.java)
            intent.putExtra("title", selectedMemo.title)
            intent.putExtra("content", selectedMemo.content)
            intent.putExtra("regDate", selectedMemo.regDate)
            intent.putExtra("flag", "edit") // listview 클릭시에는 수정 가능
            intent.putExtra("position", position)
            memoLauncher.launch(intent)

        }

        // 등록버튼을 눌렀을 때
        binding.setBtn.setOnClickListener {
            val intent = Intent(this, MemoEditActivity::class.java)
            intent.putExtra("flag", "create") // 등록버튼일때는 수정 불가
            memoLauncher.launch(intent)
        }
    }
    private val memoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){  result ->
        if(result.resultCode == RESULT_OK){
            // 데이터가 바뀌면 어댑터 새로고침
            adapter.notifyDataSetChanged()
        }
    }
}


