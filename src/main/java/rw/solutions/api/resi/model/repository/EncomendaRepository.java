package rw.solutions.api.resi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rw.solutions.api.resi.model.Encomenda;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
	
	@Query("SELECT encomenda FROM Encomenda encomenda WHERE encomenda.apartamento.id = :apartamentoID")
	List<Encomenda> getEncomendasPorApartamento(@Param("apartamentoID") Long apartamentoID);
	
	@Query("SELECT encomenda FROM Encomenda encomenda WHERE encomenda.id = :encomendaID")
	Encomenda getEncomendaPorID(@Param("encomendaID") Long encomendaID);

}
