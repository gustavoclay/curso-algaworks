package com.algaworks.algamoney.api.repository.filter;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LancamentoFilterImpl implements LancamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter) {
		// Configuração Criteria
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);

		// Criar restrições
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);

		// Return Query
		TypedQuery<Lancamento> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder, Root<Lancamento> root) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(builder
							.lower(root.get("descricao")), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}

		if (lancamentoFilter.getDataVencimentoDe() != null) {
			//predicates.add(e);
		}

		if (lancamentoFilter.getDataVencimentoAte() != null) {
			//predicates.add(e);
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
