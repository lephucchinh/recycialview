package com.example.appmusickotlin.model





data class DataListPlayList(
    val title : String
)

object ListAlbums {
    var albumList : MutableList<DataListPlayList>? = null
}

