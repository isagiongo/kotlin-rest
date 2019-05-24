package com.isagiongo.kotlinbasic.repositories

import org.springframework.data.repository.CrudRepository
import com.isagiongo.kotlinbasic.models.Note

interface NoteRepository : CrudRepository<Note, Long>