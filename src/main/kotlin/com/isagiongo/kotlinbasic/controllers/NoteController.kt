package com.isagiongo.kotlinbasic.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.isagiongo.kotlinbasic.models.Note
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.isagiongo.kotlinbasic.repositories.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import com.isagiongo.kotlinbasic.services.NoteService

@RestController
@RequestMapping("notes")
class NoteController (private val noteService : NoteService) {
	
	@GetMapping
	fun list(): List<Note>{
		return noteService.findAll().toList()
	}
	
	@PostMapping
	fun add(@RequestBody note: Note): Note{
		return noteService.save(note)
	}
	
	@PutMapping("{id}")
	fun update(@PathVariable id: Long, @RequestBody note: Note): Note {
		if(noteService.existsById(id)){
			val safeNote = note.copy(id)
			return noteService.save(safeNote)
		}
		return Note()
	}
	
	@DeleteMapping("{id}")
	fun delete(@PathVariable id: Long){
		if(noteService.existsById(id)){
			return noteService.deleteById(id)
		}
	}
}