package com.leacuvelo.memorynotes.framework

import com.leacuvelo.core.usecase.AddNote
import com.leacuvelo.core.usecase.GetAllNotes
import com.leacuvelo.core.usecase.GetNote
import com.leacuvelo.core.usecase.RemoveNote

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
    )