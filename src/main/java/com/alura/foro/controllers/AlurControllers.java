package com.alura.foro.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alura.foro.domain.topicos.Topico;
import com.alura.foro.domain.topicos.TopicoDTO;
import com.alura.foro.domain.topicos.TopicoReadDTO;
import com.alura.foro.domain.topicos.TopicoRepository;
import com.alura.foro.domain.topicos.TopicoUpdateDTO;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/alura")
public class AlurControllers {
	
		@Autowired
		TopicoRepository repository;
	
		@GetMapping
		public ResponseEntity get( @PageableDefault Pageable pageable ){
			var body = repository.findAll().stream().map(TopicoReadDTO::new).toList();
			return ResponseEntity.ok().body(body);
//			var colletion = repository.findAll().stream().map( t -> {
//				Long autor = t.getAutor().getId();
//				Long curso = t.getCurso().getId();
//				return new TopicoDTO(t.getId(),autor,curso, t.getfechaCreacion(),
//						t.getMensaje(), t.getStatus().toString(), t.getTitulo());
//			}).toList();	
		}
		
		@PostMapping
		@Transactional
		public ResponseEntity postCreateOne(@RequestBody TopicoDTO obj ) {
			System.out.println();
			Topico topico = new Topico(obj);
			repository.save(topico);
			return ResponseEntity.ok(topico);
		}
		
		@PutMapping
		@Transactional
		public ResponseEntity putUdate(@RequestBody TopicoUpdateDTO update) {
			Topico topic = repository.getReferenceById(update.id());
			
			if(update.titulo() != null) {
				topic.setTitulo(update.titulo());
			}
			if(update.mensaje() != null) {
				topic.setMensaje(update.mensaje());
			}	
			return ResponseEntity.ok().body(new TopicoReadDTO(topic));
		}

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity delete(@PathVariable Long id){
			Topico topic = repository.getReferenceById(id);
			repository.delete(topic);
			return ResponseEntity.noContent().build();
		}


}
