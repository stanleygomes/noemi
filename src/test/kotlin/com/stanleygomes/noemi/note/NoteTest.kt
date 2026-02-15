package com.stanleygomes.noemi.note

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NoteTest {

    @Test
    fun `should create note with default values when no arguments provided`() {
        val note = Note()

        assertTrue(note.id.isNotBlank())
        assertEquals("", note.title)
        assertEquals("", note.content)
        assertTrue(note.createdAt > 0)
    }

    @Test
    fun `should create note with specified values when arguments provided`() {
        val note = Note(
            id = "custom-id",
            title = "My Title",
            content = "My Content",
            createdAt = 12345L
        )

        assertEquals("custom-id", note.id)
        assertEquals("My Title", note.title)
        assertEquals("My Content", note.content)
        assertEquals(12345L, note.createdAt)
    }

    @Test
    fun `should generate unique ids when multiple notes created with defaults`() {
        val note1 = Note()
        val note2 = Note()

        assertNotEquals(note1.id, note2.id)
    }
}
