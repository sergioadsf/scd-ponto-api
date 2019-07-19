package br.com.conectasol.scdponto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.conectasol.scdponto.model.Ponto;
import br.com.conectasol.scdponto.model.Ponto_;
import br.com.conectasol.scdponto.model.TipoPonto;
import br.com.conectasol.scdponto.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository repository;

	public List<Ponto> ultimosPontosBatidos() {
		Pageable pageable = PageRequest.of(0, 10,
				Sort.by(Ponto_.dataRegistro.getName(), Ponto_.horaRegistro.getName()).descending());
		calcularPontoDia();
		return repository.findAll(pageable).stream().collect(Collectors.toList());
	}

	public void calcularPontoDia() {
//		List<Long> pontos = repository.sumHoraRegistroGroupByTipo(LocalDate.of(2019, 07, 17));
		List<Long> pontos = repository.sumHoraRegistroGroupByTipo();
		List<Long> diarias = new ArrayList<>();
		int size = pontos.size() / 2;
		for (int i = 0; i <= size; i += 2) {
			diarias.add(pontos.get(i) - pontos.get(i + 1));
		}

		diarias.stream().forEach(System.out::println);
	}

	public Ponto salvar(Ponto ponto) {
		long count = repository.countByDataRegistro(ponto.getDataRegistro());
		if (count % 2 == 0) {
			ponto.setTipo(TipoPonto.ENTRADA);
		} else {
			ponto.setTipo(TipoPonto.SAIDA);
		}

		return repository.save(ponto);
	}

}
