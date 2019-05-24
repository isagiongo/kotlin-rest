package com.isagiongo.kotlinbasic.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class Note(
	@JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue
	val id: Long = 0L,
	val title: String = "",
	val description: String = "")