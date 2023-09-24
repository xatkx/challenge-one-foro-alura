package com.alura.foro.controllers;



import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*
 * Para la creación de un tópico las siguientes informaciones son necesarias:

id

titulo

mensaje

fecha de creación

estatus del tópico

autor

curso
 */

@RestController
@RequestMapping("/alura")
public class AlurControllers {
	
		@GetMapping
		public ResponseEntity<String> get( Pageable pageable ){
			return ResponseEntity.ok("hola mundo");
		}
		
		@PostMapping
		public ResponseEntity postCreateOne(@RequestBody String obj ) {
			
			return ResponseEntity.ok("creado con exito");
		}
}
