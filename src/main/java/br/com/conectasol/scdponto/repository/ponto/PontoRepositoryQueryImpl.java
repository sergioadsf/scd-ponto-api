package br.com.conectasol.scdponto.repository.ponto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.conectasol.scdponto.model.Ponto;
import br.com.conectasol.scdponto.model.Ponto_;

public class PontoRepositoryQueryImpl implements PontoRepositoryQuery {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Long> sumHoraRegistroGroupByTipo() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Ponto> root = criteria.from(Ponto.class);
		criteria.select(builder.sum(root.get(Ponto_.horaRegistro).as(Long.class))).groupBy(root.get(Ponto_.tipo),
				root.get(Ponto_.dataRegistro));
		criteria.orderBy(builder.desc(root.get(Ponto_.dataRegistro)), builder.desc(root.get(Ponto_.tipo)));
		return manager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Long> sumHoraRegistroGroupByTipo(LocalDate localDate) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Ponto> root = criteria.from(Ponto.class);
		criteria.select(builder.sum(root.get(Ponto_.horaRegistro).as(Long.class))).groupBy(root.get(Ponto_.tipo));
		criteria.where(builder.equal(root.get(Ponto_.dataRegistro), localDate));
		criteria.orderBy(builder.desc(root.get(Ponto_.tipo)));
		return manager.createQuery(criteria).getResultList();
	}

}
