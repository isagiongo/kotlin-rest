package com.isagiongo.kotlinbasic.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
data class Note(@Id @GeneratedValue val id: Long = 0L, val title: String = "", val description: String = "")