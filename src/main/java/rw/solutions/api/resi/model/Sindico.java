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
@Table(name = "agenda")
public class Sindico {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condominio_id", referencedColumnName = "id")
	private Condominio condominio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "link_whatsapp")
	private String linkWhatsapp;
	
	@Column(name = "telefone_whatsapp")
	private String telefoneWhatsapp;
	
	
}
