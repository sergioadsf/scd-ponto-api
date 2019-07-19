package br.com.conectasol.scdponto.repository.ponto;

import java.time.LocalDate;
import java.util.List;

public interface PontoRepositoryQuery {
	
	List<Long> sumHoraRegistroGroupByTipo();
	List<Long> sumHoraRegistroGroupByTipo(LocalDate localDate);
}
