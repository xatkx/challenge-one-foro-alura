package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.CursoDTO;
import com.alura.foro.domain.usuarios.UsuarioDTO;

public record TopicoReadDTO(
		Long id,
		UsuarioDTO autor,
		CursoDTO curso,
		String fecha_creacion,
		String mensaje,
		String status,
		String titulo
		
		) {
	public TopicoReadDTO(Topico topico) {
		this(
				topico.getId(),
				topico.getAutor().getDTO(),
				topico.getCurso().getDTO(),
				topico.getfechaCreacion(),
				topico.getMensaje(),
				topico.getStatus().toString(),
				topico.getTitulo()
				);
		
	}

}
