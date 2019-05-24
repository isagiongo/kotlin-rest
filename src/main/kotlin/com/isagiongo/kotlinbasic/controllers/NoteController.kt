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
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("notes")
class NoteController (private val noteService : NoteService) {
	
	@GetMapping
	fun list(): ResponseEntity<List<Note>>{
		val allNotes = noteService.findAll().toList()
		return ResponseEntity.ok(allNotes)
	}
	
	@PostMapping
	fun add(@RequestBody note: Note): ResponseEntity<Note>{
		val savedNote = noteService.save(note)
		return ResponseEntity.ok(savedNote)
	}
	
	@PutMapping("{id}")
	fun update(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
		if(noteService.existsById(id)){
			val alteredNote = noteService.update(id, note)
			return ResponseEntity.ok(alteredNote)
		}
		return ResponseEntity.notFound().build()
	}
	
	@DeleteMapping("{id}")
	fun delete(@PathVariable id: Long) : ResponseEntity<Unit>{
		if(noteService.existsById(id)){
			noteService.deleteById(id)
			return ResponseEntity.ok().build()
		}
		return ResponseEntity.notFound().build()
	}
}