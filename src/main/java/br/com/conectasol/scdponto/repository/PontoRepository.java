package br.com.conectasol.scdponto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conectasol.scdponto.model.Ponto;
import br.com.conectasol.scdponto.repository.ponto.PontoRepositoryQuery;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>, PontoRepositoryQuery {

	Long countByDataRegistro(LocalDate dataRegistro);

	List<Ponto> findByDataRegistro(LocalDate dataRegistro);

}
