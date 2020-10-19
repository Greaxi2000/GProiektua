package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class SukurtsalDibisa implements Serializable {
@XmlID	
@XmlJavaTypeAdapter(IntegerAdapter.class)
@Id
private Integer ID;
private float kop;
private int irabazteKomisioa;

@XmlIDREF
private Sukurtsal sukurtsal;
@XmlIDREF
private Dibisa dibisa;

public SukurtsalDibisa() {}

public SukurtsalDibisa(Integer ID, float kop, int irabazteKomisioa, Sukurtsal sukurtsal, Dibisa Dibisa) {
	this.ID = ID;
	this.kop = kop;
	this.irabazteKomisioa = irabazteKomisioa;
	this.sukurtsal = sukurtsal;
	this.dibisa = Dibisa;
}

public Dibisa getDibisa() {
	
	return this.dibisa;
	
}

public float getKop() {
	return this.kop;
}

public void batuEtaSetKop(float kop) {
	this.kop = this.kop+kop;
}

public void kenduEtaSetKop(float kop) {
	this.kop = this.kop - kop;
}


public int getKomisioa() {
	return this.irabazteKomisioa;
}

public Sukurtsal getSukurtsal() {
	return this.sukurtsal;
}

public int getId() {
	return this.ID;
}

public void setID(Integer iD) {
	ID = iD;
}

public int getIrabazteKomisioa() {
	return irabazteKomisioa;
}

public void setIrabazteKomisioa(int irabazteKomisioa) {
	this.irabazteKomisioa = irabazteKomisioa;
}

public void setKop(float kop) {
	this.kop = kop;
}

public void setSukurtsal(Sukurtsal sukurtsal) {
	this.sukurtsal = sukurtsal;
}

public void setDibisa(Dibisa dibisa) {
	this.dibisa = dibisa;
}

}

