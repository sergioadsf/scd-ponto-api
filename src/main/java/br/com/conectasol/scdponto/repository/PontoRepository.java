package br.com.conectasol.scdponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conectasol.scdponto.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

}
