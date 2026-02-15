package com.stanleygomes.noemi.note.mocks

import com.stanleygomes.noemi.note.Note

object NoteMocks {

    fun createDefaultNote(): Note = Note(
        id = "test-id-1",
        title = "Test Note",
        content = "Test content",
        createdAt = 1000L
    )

    fun createNoteWithTitle(title: String): Note = Note(
        id = "test-id-${title.hashCode()}",
        title = title,
        content = "Content for $title",
        createdAt = 1000L
    )

    fun createNoteWithId(id: String): Note = Note(
        id = id,
        title = "Note $id",
        content = "Content for $id",
        createdAt = 1000L
    )
}
