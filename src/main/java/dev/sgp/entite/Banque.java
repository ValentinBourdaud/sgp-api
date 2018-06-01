package dev.sgp.entite;

import javax.persistence.Embeddable;

@Embeddable
public class Banque {

	private String nomBanque;
	private String iban;
	private String bic;

	public Banque() {
		super();
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
