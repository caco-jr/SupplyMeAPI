package br.com.supplyme.SuppleMe.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonProperty(value = "gtin14")
	private String ean;
	@JsonProperty(value = "brand_name")
	private String brand;
	private String name;
	@JsonProperty(value = "size")
	private String material;
	@JsonProperty(value = "author")
	private String marca;
	@JsonProperty(value = "publisher")
	private String cor;
	@JsonProperty(value = "ingredients")
	private String urlImage;
	@JsonIgnore(value = true)
	private Integer estoque;

	public Produto() {

	}

	public Produto(Integer id, String ean, String brand, String name, String material, String marca, String cor,
			String urlImages) {
		super();
		this.id = id;
		this.ean = ean;
		this.brand = brand;
		this.name = name;
		this.material = material;
		this.marca = marca;
		this.cor = cor;
		this.urlImage = urlImages;
		this.estoque = 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
