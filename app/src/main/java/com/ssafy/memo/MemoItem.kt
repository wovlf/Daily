package com.ssafy.memo

data class MemoItem(var title:String, val content:String, val regDate:String){
    override fun toString(): String {
        return "$title $regDate"
    }
}