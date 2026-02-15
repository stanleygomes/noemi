package com.stanleygomes.noemi.note

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@Service(Service.Level.APP)
@State(name = "NoemiNotes", storages = [Storage("noemi-notes.xml")])
class NoteService : PersistentStateComponent<NoteService.NoteState> {

    class NoteState {
        var notes: MutableList<Note> = mutableListOf()
    }

    private var state = NoteState()

    private val listeners: MutableList<() -> Unit> = mutableListOf()

    override fun getState(): NoteState = state

    override fun loadState(loadedState: NoteState) {
        state = loadedState
    }

    fun getNotes(): List<Note> = state.notes.toList()

    fun addNote(note: Note) {
        state.notes.add(note)
        notifyListeners()
    }

    fun removeNote(noteId: String) {
        state.notes.removeAll { it.id == noteId }
        notifyListeners()
    }

    fun addListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: () -> Unit) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it() }
    }

    companion object {
        fun getInstance(): NoteService {
            return ApplicationManager.getApplication().getService(NoteService::class.java)
        }
    }
}
