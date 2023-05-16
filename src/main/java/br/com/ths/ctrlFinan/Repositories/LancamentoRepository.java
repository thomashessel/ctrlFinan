package br.com.ths.ctrlFinan.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ths.ctrlFinan.Entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
