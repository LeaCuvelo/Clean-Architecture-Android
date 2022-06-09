package com.leacuvelo.core.data

data class Note (
    val title: String,
    var content: String,
    var creationTime: Long,
    var updateTime: Long,
    var id: Long = 0
)