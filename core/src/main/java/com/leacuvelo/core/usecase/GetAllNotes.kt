package com.leacuvelo.core.usecase

import com.leacuvelo.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() = noteRepository.getAllNotes()

}