package com.example.appmusickotlin.model

import java.io.Serializable

data class Song(
    val id : String,
    val name : String,
    val duration : Long,
    val albumId : Long,
)