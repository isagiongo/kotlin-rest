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

@RestController
@RequestMapping("notes")
class NoteController {
	
	@Autowired
	lateinit var noteRepository : NoteRepository
	
	@GetMapping
	fun list(): List<Note>{
		return noteRepository.findAll().toList()
	}
	
	@GetMapping("/title")
	fun findByTitle(@RequestBody title: String): Note{
		return noteRepository.findByTitle(title)
	}
	
	@PostMapping
	fun add(@RequestBody note: Note): Note{
		return noteRepository.save(note)
	}
	
	@PutMapping("{id}")
	fun update(@PathVariable id: Long, @RequestBody note: Note): Note {
		if(noteRepository.existsById(id)){
			val safeNote = note.copy(id)
			return noteRepository.save(safeNote)
		}
		return Note()
	}
}