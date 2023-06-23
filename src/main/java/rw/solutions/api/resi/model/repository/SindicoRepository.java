package rw.solutions.api.resi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rw.solutions.api.resi.model.Sindico;

public interface SindicoRepository extends JpaRepository<Sindico, Long> {

	@Query("SELECT sindico FROM Sindico sindico WHERE sindico.condominio.id = :condominioID")
	Sindico getSindicoByCondominioID(@Param("condominioID") Long condominioID);

}
