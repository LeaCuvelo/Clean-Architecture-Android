package com.leacuvelo.core.usecase

import com.leacuvelo.core.data.Note
import com.leacuvelo.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    suspend operator fun  invoke(note: Note) = noteRepository.addNote(note)

}