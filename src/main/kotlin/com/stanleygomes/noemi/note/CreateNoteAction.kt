package com.stanleygomes.noemi.note

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class CreateNoteAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val dialog = CreateNoteDialog()
        if (dialog.showAndGet()) {
            val note = Note(
                title = dialog.getNoteTitle(),
                content = dialog.getNoteContent()
            )
            NoteService.getInstance().addNote(note)
        }
    }
}
