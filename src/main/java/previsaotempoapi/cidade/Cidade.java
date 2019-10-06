package previsaotempoapi.cidade;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "cidade")
@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String name;
	private String idOpenWeather;
	private String country;

	public Cidade() {}

	public Cidade(String id, String name, String idOpenWeather, String country) {
		super();
		this.id = id;
		this.name = name;
		this.idOpenWeather = idOpenWeather;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
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
