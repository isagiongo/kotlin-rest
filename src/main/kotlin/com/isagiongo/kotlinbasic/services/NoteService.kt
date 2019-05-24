package com.isagiongo.kotlinbasic.services

import com.isagiongo.kotlinbasic.repositories.NoteRepository
import com.isagiongo.kotlinbasic.models.Note
import org.springframework.stereotype.Service

@Service
class NoteService (private val noteRepository : NoteRepository) {
	
	fun findAll() : List<Note>{
		return noteRepository.findAll().toList()
	}
	
	fun existsById(id : Long) : Boolean {
		return noteRepository.existsById(id)
	}
	
	fun save(note : Note ): Note {
		return noteRepository.save(note)
	}
	
	fun update(id : Long, note : Note) : Note{
		var safeNote = note.copy(id = id)
		return noteRepository.save(safeNote)
	}
	
	fun deleteById(id : Long){
		return noteRepository.deleteById(id)
	}
}