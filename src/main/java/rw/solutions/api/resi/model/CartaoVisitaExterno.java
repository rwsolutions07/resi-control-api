package rw.solutions.api.resi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "cartao_visita_externo")
public class CartaoVisitaExterno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "url_whatsapp", nullable = false)
	private String urlWhatsapp;
	
	@Lob
	@Column(name = "foto", nullable = true)
	private byte[] foto;
	
	@Lob
	@Column(name = "logo", nullable = true)
	private byte[] logo;

}
