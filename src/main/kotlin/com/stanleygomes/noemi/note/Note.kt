package com.stanleygomes.noemi.note

import java.util.UUID

data class Note(
    var id: String = UUID.randomUUID().toString(),
    var title: String = "",
    var content: String = "",
    var createdAt: Long = System.currentTimeMillis()
)
