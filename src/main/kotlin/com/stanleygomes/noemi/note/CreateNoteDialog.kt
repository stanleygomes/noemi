package com.stanleygomes.noemi.note

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.util.ui.JBUI
import com.stanleygomes.noemi.MyBundle
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout

class CreateNoteDialog : DialogWrapper(true) {

    private val titleField = JTextField()
    private val contentArea = JTextArea(5, 30)

    init {
        title = MyBundle.message("dialog.create.note.title")
        init()
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel(GridBagLayout())
        val gbc = GridBagConstraints()

        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.insets = JBUI.insets(4)

        gbc.gridx = 0
        gbc.gridy = 0
        gbc.weightx = 0.0
        panel.add(JLabel(MyBundle.message("dialog.create.note.field.title")), gbc)

        gbc.gridx = 1
        gbc.weightx = 1.0
        panel.add(titleField, gbc)

        gbc.gridx = 0
        gbc.gridy = 1
        gbc.weightx = 0.0
        gbc.anchor = GridBagConstraints.NORTH
        panel.add(JLabel(MyBundle.message("dialog.create.note.field.content")), gbc)

        gbc.gridx = 1
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH
        contentArea.lineWrap = true
        contentArea.wrapStyleWord = true
        val scrollPane = JScrollPane(contentArea)
        scrollPane.preferredSize = Dimension(300, 120)
        panel.add(scrollPane, gbc)

        val wrapper = JPanel(BorderLayout())
        wrapper.preferredSize = Dimension(400, 200)
        wrapper.add(panel, BorderLayout.CENTER)
        return wrapper
    }

    override fun doValidate(): ValidationInfo? {
        if (titleField.text.isNullOrBlank()) {
            return ValidationInfo(
                MyBundle.message("dialog.create.note.validation.title.empty"),
                titleField
            )
        }
        return null
    }

    fun getNoteTitle(): String = titleField.text.trim()

    fun getNoteContent(): String = contentArea.text.trim()

    override fun getPreferredFocusedComponent(): JComponent = titleField
}
