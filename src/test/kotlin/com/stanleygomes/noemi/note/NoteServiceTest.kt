package com.stanleygomes.noemi.note

import com.stanleygomes.noemi.note.mocks.NoteMocks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NoteServiceTest {

    private lateinit var noteService: NoteService

    @BeforeEach
    fun setUp() {
        noteService = NoteService()
    }

    @Test
    fun `should add note when valid note is provided`() {
        val note = NoteMocks.createDefaultNote()

        noteService.addNote(note)

        val notes = noteService.getNotes()
        assertEquals(1, notes.size)
        assertEquals("test-id-1", notes[0].id)
        assertEquals("Test Note", notes[0].title)
        assertEquals("Test content", notes[0].content)
    }

    @Test
    fun `should return empty list when no notes exist`() {
        val notes = noteService.getNotes()

        assertTrue(notes.isEmpty())
    }

    @Test
    fun `should remove note when valid id is provided`() {
        val note = NoteMocks.createNoteWithId("remove-me")
        noteService.addNote(note)

        noteService.removeNote("remove-me")

        val notes = noteService.getNotes()
        assertTrue(notes.isEmpty())
    }

    @Test
    fun `should not remove any note when id does not exist`() {
        val note = NoteMocks.createDefaultNote()
        noteService.addNote(note)

        noteService.removeNote("non-existent-id")

        val notes = noteService.getNotes()
        assertEquals(1, notes.size)
    }

    @Test
    fun `should return defensive copy when getNotes is called`() {
        val note = NoteMocks.createDefaultNote()
        noteService.addNote(note)

        val notesCopy = noteService.getNotes()

        assertEquals(1, notesCopy.size)
        assertEquals(1, noteService.getNotes().size)
    }

    @Test
    fun `should notify listener when note is added`() {
        var notified = false
        noteService.addListener { notified = true }
        val note = NoteMocks.createDefaultNote()

        noteService.addNote(note)

        assertTrue(notified)
    }

    @Test
    fun `should notify listener when note is removed`() {
        var notified = false
        val note = NoteMocks.createDefaultNote()
        noteService.addNote(note)
        noteService.addListener { notified = true }

        noteService.removeNote("test-id-1")

        assertTrue(notified)
    }

    @Test
    fun `should not notify listener when listener is removed`() {
        var notifyCount = 0
        val listener: () -> Unit = { notifyCount++ }
        noteService.addListener(listener)
        noteService.addNote(NoteMocks.createDefaultNote())
        assertEquals(1, notifyCount)

        noteService.removeListener(listener)
        noteService.addNote(NoteMocks.createNoteWithId("second"))

        assertEquals(1, notifyCount)
    }

    @Test
    fun `should load state when loadState is called`() {
        val state = NoteService.NoteState()
        state.notes.add(NoteMocks.createDefaultNote())
        state.notes.add(NoteMocks.createNoteWithId("loaded-2"))

        noteService.loadState(state)

        val notes = noteService.getNotes()
        assertEquals(2, notes.size)
        assertEquals("test-id-1", notes[0].id)
        assertEquals("loaded-2", notes[1].id)
    }

    @Test
    fun `should return current state when getState is called`() {
        noteService.addNote(NoteMocks.createDefaultNote())

        val state = noteService.state

        assertEquals(1, state.notes.size)
        assertEquals("test-id-1", state.notes[0].id)
    }

    @Test
    fun `should add multiple notes when addNote is called multiple times`() {
        noteService.addNote(NoteMocks.createNoteWithId("note-1"))
        noteService.addNote(NoteMocks.createNoteWithId("note-2"))
        noteService.addNote(NoteMocks.createNoteWithId("note-3"))

        val notes = noteService.getNotes()
        assertEquals(3, notes.size)
    }
}
