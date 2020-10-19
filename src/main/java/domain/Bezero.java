package domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bezero implements Serializable {
@XmlID
@Id	
private String NAN;
private String izena;
private String abizena;
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private Vector<Kontua> kontuak=new Vector<Kontua>();


public Vector<Kontua> getKontuak() {
	return kontuak;
}

public String getNAN() {
	return NAN;
}

public void setNAN(String nAN) {
	NAN = nAN;
}

public String getIzena() {
	return izena;
}

public void setIzena(String izena) {
	this.izena = izena;
}

public String getAbizena() {
	return abizena;
}

public void setAbizena(String abizena) {
	this.abizena = abizena;
}

public void setKontuak(Vector<Kontua> kontuak) {
	this.kontuak = kontuak;
}

public Bezero() {
	
}

public Bezero(String NAN, String Izena, String Abizena) {
	this.NAN = NAN;
	this.izena = Izena;
	this.abizena = Abizena;
}

public Kontua addKontua(int id, float kop)  {
    Kontua k=new Kontua(id,kop, this);
    kontuak.add(k);
    return k;
}

public String getBezeroNan() {
	return NAN;
}













}
