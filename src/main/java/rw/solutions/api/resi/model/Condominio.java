package rw.solutions.api.resi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "condominio")
public class Condominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "rua", nullable = false)
	private String rua;
	@Column(name = "bairro", nullable = false)
	private String bairro;
	@Column(name = "cidade", nullable = false)
	private String cidade;
	@Column(name = "uf", nullable = false)
	private String uf;
	@Column(name = "CEP", nullable = false)
	private String cep;
	

}
