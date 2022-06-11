package com.leacuvelo.memorynotes.framework.di

import com.leacuvelo.core.repository.NoteRepository
import com.leacuvelo.core.usecase.AddNote
import com.leacuvelo.core.usecase.GetAllNotes
import com.leacuvelo.core.usecase.GetNote
import com.leacuvelo.core.usecase.RemoveNote
import com.leacuvelo.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) =  UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )


}