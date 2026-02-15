package com.stanleygomes.noemi.note

import com.intellij.openapi.Disposable
import com.intellij.ui.components.JBScrollPane
import com.intellij.util.ui.JBUI
import com.stanleygomes.noemi.MyBundle
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingUtilities
import java.awt.BorderLayout
import java.awt.FlowLayout

class NoteListPanel : JPanel(BorderLayout()), Disposable {

    private val notesContainer = JPanel()
    private val noteService = NoteService.getInstance()
    private val refreshListener: () -> Unit = { SwingUtilities.invokeLater { refreshNotes() } }

    init {
        notesContainer.layout = BoxLayout(notesContainer, BoxLayout.Y_AXIS)

        val toolbar = JPanel(FlowLayout(FlowLayout.LEFT))
        val createButton = JButton(MyBundle.message("action.create.note.text"))
        createButton.addActionListener {
            val dialog = CreateNoteDialog()
            if (dialog.showAndGet()) {
                val note = Note(
                    title = dialog.getNoteTitle(),
                    content = dialog.getNoteContent()
                )
                noteService.addNote(note)
            }
        }
        toolbar.add(createButton)
        add(toolbar, BorderLayout.NORTH)

        val scrollPane = JBScrollPane(notesContainer)
        add(scrollPane, BorderLayout.CENTER)

        noteService.addListener(refreshListener)
        refreshNotes()
    }

    private fun refreshNotes() {
        notesContainer.removeAll()
        val notes = noteService.getNotes()

        if (notes.isEmpty()) {
            val emptyLabel = JLabel(MyBundle.message("note.list.empty"))
            emptyLabel.border = JBUI.Borders.empty(10)
            notesContainer.add(emptyLabel)
        } else {
            notes.sortedByDescending { it.createdAt }.forEach { note ->
                notesContainer.add(createNoteCard(note))
            }
        }

        notesContainer.revalidate()
        notesContainer.repaint()
    }

    private fun createNoteCard(note: Note): JPanel {
        val card = JPanel(BorderLayout())
        card.border = JBUI.Borders.empty(6, 10)

        val textPanel = JPanel()
        textPanel.layout = BoxLayout(textPanel, BoxLayout.Y_AXIS)
        val titleLabel = JLabel(note.title)
        titleLabel.font = titleLabel.font.deriveFont(java.awt.Font.BOLD)
        textPanel.add(titleLabel)
        if (note.content.isNotBlank()) {
            textPanel.add(JLabel(note.content))
        }
        card.add(textPanel, BorderLayout.CENTER)

        val deleteButton = JButton(MyBundle.message("action.delete.note.text"))
        deleteButton.addActionListener { noteService.removeNote(note.id) }
        card.add(deleteButton, BorderLayout.EAST)

        return card
    }

    override fun dispose() {
        noteService.removeListener(refreshListener)
    }
}
