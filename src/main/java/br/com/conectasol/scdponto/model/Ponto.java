package br.com.conectasol.scdponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ponto")
public class Ponto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_registro", columnDefinition = "DATE")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataRegistro;

	@Column(name = "hora_registro", columnDefinition = "TIME")
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horaRegistro;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoPonto tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public LocalTime getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(LocalTime horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public TipoPonto getTipo() {
		return tipo;
	}

	public void setTipo(TipoPonto tipo) {
		this.tipo = tipo;
	}

}
