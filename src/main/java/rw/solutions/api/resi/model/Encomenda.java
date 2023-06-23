package rw.solutions.api.resi.model;

import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
	
	@Column(name = "assinado_por")
	private String assinadoPor;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private EncomendaStatus status;
	
	@Lob
	@Column(name = "foto_arquivo", nullable = true)
	private byte[] arquivo;
	
	@Column(name = "data_entrega")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate dataEntrega;
	
	@Column(name = "data_retirada")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate dataRetirada;
	
	@Column(name = "origem", nullable = false)
	@Enumerated(EnumType.STRING)
	private OrigemEncomenda origem;
	
	@Column(name = "tipo_encomenda", nullable = false)
	private TipoEncomenda tipoEncomenda;
	
	@Column(name = "cadastrado_por", nullable = false)
	private String cadastradoPor;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;
	
	
	public Encomenda(DadosCadastroEncomenda cadastro, Morador morador, Apartamento apartamento, Portaria portaria) {
		this.nome = cadastro.nome();
		this.morador = morador;
		this.apartamento = apartamento;
		this.status = EncomendaStatus.PENDENTE;
		this.origem = cadastro.origem();
		this.tipoEncomenda = cadastro.tipo();
		this.assinadoPor = "";
		this.arquivo = null;
		this.dataEntrega = LocalDate.now();
		this.cadastradoPor = portaria.getNome();
		this.codigo = cadastro.codigoEncomenda() + "-" + morador.getId();
	}
	
}
