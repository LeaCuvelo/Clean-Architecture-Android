package com.leacuvelo.core.usecase

import com.leacuvelo.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)


}