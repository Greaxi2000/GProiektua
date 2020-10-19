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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kontua implements Serializable {

@XmlID	
@XmlJavaTypeAdapter(IntegerAdapter.class)
@Id
private Integer kontuID;
private float diruKop;
@XmlIDREF
private Bezero Bezero;	
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private Vector<Transakzio> transakzioak=new Vector<Transakzio>();

public Kontua() {}

public Kontua(Integer kontuID, float kop, Bezero bezero) {
	
	this.kontuID = kontuID;
	this.diruKop = kop;
	this.Bezero = bezero;
}
	
public float getDiruKop(){
	return diruKop; 
}
public void kenduEtaSetDiruKop(float kop) {
	this.diruKop = this.diruKop - kop;
}

public void batuEtaSetDiruKop(float kop) {
	this.diruKop = this.diruKop + kop;
}

public int getID() {
	return this.kontuID;
}
	
public void addTransakzio(Transakzio trans){
    this.transakzioak.add(trans);
}

public Integer getKontuID() {
	return kontuID;
}

public void setKontuID(Integer kontuID) {
	this.kontuID = kontuID;
}

public Bezero getBezero() {
	return Bezero;
}

public void setBezero(Bezero bezero) {
	Bezero = bezero;
}

public Vector<Transakzio> getTransakzioak() {
	return transakzioak;
}

public void setTransakzioak(Vector<Transakzio> transakzioak) {
	this.transakzioak = transakzioak;
}

public void setDiruKop(float diruKop) {
	this.diruKop = diruKop;
}	
	
	
	
	
}
