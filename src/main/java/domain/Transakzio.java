package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Transakzio implements Serializable{

	

private Date data;
private String eragiketa;
@XmlIDREF
private Kontua kontu;

public Transakzio() {}

public Transakzio(Date data, String eragiketa, Kontua kontu) {

	this.data = data;
	this.eragiketa = eragiketa;
	this.kontu = kontu;
}

public Date getData() {
	return data;
}

public void setData(Date data) {
	this.data = data;
}

public String getEragiketa() {
	return eragiketa;
}

public void setEragiketa(String eragiketa) {
	this.eragiketa = eragiketa;
}

public Kontua getKontu() {
	return kontu;
}

public void setKontu(Kontua kontu) {
	this.kontu = kontu;
}
}
