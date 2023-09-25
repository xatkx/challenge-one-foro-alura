package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.CursoDTO;
import com.alura.foro.domain.usuarios.UsuarioDTO;

public record TopicoDTO(
		long id, UsuarioDTO autor, CursoDTO curso,
		String mensaje,
		StatusTopico status,String titulo
		) {

//	public TopicoDTO(Topico topico) {
//
//		this(
//				topico.getId(),
//				 topico.getAutor().getId(),
//				topico.getCurso().getId(),
//				topico.getfechaCreacion(),
//				topico.getMensaje().toString(),
//				topico.getStatus().toString(),
//				topico.getTitulo()
//				);
//		
//	}
	

}
