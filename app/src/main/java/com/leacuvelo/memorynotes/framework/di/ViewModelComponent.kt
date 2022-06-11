package com.leacuvelo.memorynotes.framework.di

import com.leacuvelo.memorynotes.framework.ListViewModel
import com.leacuvelo.memorynotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {

    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)

}