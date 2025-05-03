package com.ssafy.memo

object MemoItemMgr { //object 로 선언하면 singletone 클래스가 된다.
    // 메모를 담는 ArrayList
    private var memos = arrayListOf<MemoItem>()

    // 전체 목록 반환
    fun getList():ArrayList<MemoItem> {
        return memos;
    }

    // Memo의 개수를 받아오는 함수
    fun size():Int{
        return memos.size
    }

    // index를 가지고 원하는 메모를 받아오는 함수
    fun search(index :Int): MemoItem{
        return memos.get(index)
    }

    // Memo 를 추가하는 함수
    fun add(item:MemoItem){
        memos.add(item)
    }

    // Memo 를 수정하는 함수
    fun update(index: Int, item: MemoItem){
        memos[index].title = item.title
    }

    // Memo 를 삭제하는 함수
    fun remove(index: Int){
        memos.removeAt(index)
    }

    // 메모리스트 전체 삭제하는 함수
    fun clear(){
        memos.clear()
    }
}