package br.com.conectasol.scdponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ponto.class)
public class Ponto_ {

	public static volatile SingularAttribute<Ponto, Integer> id;
	public static volatile SingularAttribute<Ponto, LocalDate> dataRegistro;
	public static volatile SingularAttribute<Ponto, LocalTime> horaRegistro;
	public static volatile SingularAttribute<Ponto, TipoPonto> tipo;

}
