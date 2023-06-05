package rw.solutions.api.resi.model;

import jakarta.persistence.Column;
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
@Table(name = "torre")
public class Ocorrencia {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "torre_id", referencedColumnName = "id")
	private Torre torre;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "local", nullable = false)
	private String local;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;

}
