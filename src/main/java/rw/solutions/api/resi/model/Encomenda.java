package rw.solutions.api.resi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rw.solutions.api.resi.model.record.DadosCadastroEncomenda;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "encomenda")
public class Encomenda {
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "morador_id", referencedColumnName = "id")
	private Morador morador;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartamente_id", referencedColumnName = "id")
	private Apartamento apartamento;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "assinado_por", nullable = false)
	private String assinadoPor;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EncomendaStatus status;
	
	@Lob
	@Column(name = "foto_arquivo", nullable = true)
	private byte[] arquivo;
	
	
	public Encomenda(DadosCadastroEncomenda cadastro, Morador morador, Apartamento apartamento) {
		this.nome = cadastro.nome();
		this.morador = morador;
		this.apartamento = apartamento;
		this.status = EncomendaStatus.PENDENTE;
		this.assinadoPor = "";
		this.arquivo = null;
	}
	
}
