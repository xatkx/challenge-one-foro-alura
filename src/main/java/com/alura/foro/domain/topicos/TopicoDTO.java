package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.CursoDTO;
import com.alura.foro.domain.usuarios.UsuarioDTO;

public record TopicoDTO(
		long id, UsuarioDTO autor, CursoDTO curso,
		String mensaje,
		StatusTopico status,String titulo
		) {

}
