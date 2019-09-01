package previsaotempoapi.cidade;

import java.io.Serializable;

import previsaotempoapi.cidade.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String apelido;
	
	public CidadeDTO() {}
	
	public CidadeDTO(Cidade cidade) {
		id = cidade.getId();
		nome = cidade.getNome();
		apelido = cidade.getApelido();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
}
