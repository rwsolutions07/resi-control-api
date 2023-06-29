package rw.solutions.api.resi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rw.solutions.api.resi.model.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
	
	@Query("SELECT morador FROM Morador morador WHERE morador.apartamento.id = :apartamentoID")
	List<Morador> getMoradoresByApartamento(@Param("apartamentoID") Long apartamentoID);

}
