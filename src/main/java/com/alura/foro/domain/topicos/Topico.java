package com.alura.foro.domain.topicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.bind.Name;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.usuarios.Usuario;
import com.alura.foro.domain.usuarios.UsuarioDTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name="Topico")
@Table(name="topicos")
public class Topico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String mensaje;

	private String fechaCreacion = LocalDateTime.now().toString();
	
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor_id") 
	private Usuario autor;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Curso curso;
	public Topico() {
		
	}
	//private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}
	

	public Topico(Long id, String titulo, String mensaje, String fechaCreacion, StatusTopico status, Usuario autor,
			Curso curso) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.status = status;
		this.autor = autor;
		this.curso = curso;
	}


	public Topico(TopicoDTO obj) {
		// TODO Auto-generated constructor stub
		this.mensaje = obj.mensaje();
		this.titulo = obj.titulo();
		this.status =  obj.status();
		this.autor = new Usuario(obj.autor());
		this.curso = new Curso(obj.curso());
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

//	public List<Respuesta> getRespuestas() {
//		return respuestas;
//	}

//	public void setRespuestas(List<Respuesta> respuestas) {
//		this.respuestas = respuestas;
//	}

}
