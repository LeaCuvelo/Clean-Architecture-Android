package com.leacuvelo.memorynotes.framework.di

import android.app.Application
import com.leacuvelo.core.repository.NoteRepository
import com.leacuvelo.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

}