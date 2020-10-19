package domain;

import java.io.Serializable;
import java.util.List;
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
public class Dibisa implements Serializable{

@XmlID	
@Id
private String mota;
private float balioEur;
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private Vector<SukurtsalDibisa> SukurtsalDibisa=new Vector<SukurtsalDibisa>();

public Dibisa() {}

public Dibisa(String mota, float balioEur) {
	this.mota = mota;
	this.balioEur = balioEur;
}

public Vector<SukurtsalDibisa> getSukurtsalDibisa() {
	return SukurtsalDibisa;
}

public void setSukurtsalDibisa(Vector<SukurtsalDibisa> sukurtsalDibisa) {
	SukurtsalDibisa = sukurtsalDibisa;
}

public void setMota(String mota) {
	this.mota = mota;
}

public void setBalioEur(float balioEur) {
	this.balioEur = balioEur;
}

public void addSukurtsalDibisa(SukurtsalDibisa suDI) {
	SukurtsalDibisa.add(suDI);
	
}

public String getMota() {
	return this.mota;
}

public float getBalioEur() {
	return this.balioEur;
}

public Dibisa gehituGuztiak(List<domain.SukurtsalDibisa> list) {

	this.SukurtsalDibisa.addAll(list);
    return this;
}

	
	
}
