package com.isagiongo.kotlinbasic.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.isagiongo.kotlinbasic.models.Note

@RestController
@RequestMapping("notes")
class NoteController {
	
	@GetMapping
	fun list(): List<Note>{
		return listOf(Note("Leitura", "Livro de Spring Boot"), Note("Pesquisa","Angular Básico"))
	}
}