package previsaotempoapi.cidade;

import java.io.Serializable;

import previsaotempoapi.cidade.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String idOpenWeather;
	private String country;
	
	public CidadeDTO() {}
	
	public CidadeDTO(Cidade cidade) {
		id = cidade.getId();
		nome = cidade.getNome();
		idOpenWeather = cidade.getIdOpenWeather();
		country = cidade.getCountry();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdOpenWeather() {
		return idOpenWeather;
	}

	public void setIdOpenWeather(String idOpenWeather) {
		this.idOpenWeather = idOpenWeather;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
