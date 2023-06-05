package rw.solutions.api.resi.model;

import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "agenda")
public class Agenda {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "espaco_id", referencedColumnName = "id")
	private Espaco espaco;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "morador_id", referencedColumnName = "id")
	private Morador morador;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "data")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate data;

}
