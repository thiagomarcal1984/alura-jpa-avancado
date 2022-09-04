package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public Cliente(Long id, String nome, String cpf) {
		this.id = id;
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Cliente(){
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public DadosPessoais getDadosPessoais() {
		return this.dadosPessoais;
	}
	
	// Delegar a busca do nome para a propriedade dados pessoais.
	public String getNome() {
		return this.getDadosPessoais().getNome();
	}

	// Delegar a busca do CPF para a propriedade dados pessoais.
	public String getCpf() {
		return this.getDadosPessoais().getCpf();
	}
}
