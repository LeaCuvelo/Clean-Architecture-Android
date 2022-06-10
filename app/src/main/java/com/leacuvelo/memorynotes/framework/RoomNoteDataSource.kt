package com.leacuvelo.memorynotes.framework

import android.content.Context
import com.leacuvelo.core.data.Note
import com.leacuvelo.core.repository.NoteDataSource
import com.leacuvelo.memorynotes.framework.db.DatabaseService
import com.leacuvelo.memorynotes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context) : NoteDataSource {

    private val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNotes().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNote(NoteEntity.fromNote(note))

}