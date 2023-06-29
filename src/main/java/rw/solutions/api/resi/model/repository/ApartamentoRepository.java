package rw.solutions.api.resi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rw.solutions.api.resi.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{
	
	@Query("SELECT apartamento FROM Apartamento apartamento WHERE apartamento.torre.id = :torreID")
	List<Apartamento> getApartamentosByTorreID(@Param("torreID") Long torreID);

}
