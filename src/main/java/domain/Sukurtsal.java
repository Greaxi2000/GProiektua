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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Sukurtsal implements Serializable{

@XmlID
@XmlJavaTypeAdapter(IntegerAdapter.class)
@Id
private Integer sukurtsalID;
private String hiria;
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private Vector<Bezero> bezeroak=new Vector<Bezero>();
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private Vector<SukurtsalDibisa> SukurtsalDibisa=new Vector<SukurtsalDibisa>();

public Sukurtsal() {}

public Sukurtsal(Integer SukurtsalID, String hiria) {
	
	this.sukurtsalID = SukurtsalID;
	this.hiria = hiria;
}



public Integer getSukurtsalID() {
	return sukurtsalID;
}

public void setSukurtsalID(Integer sukurtsalID) {
	this.sukurtsalID = sukurtsalID;
}

public String getHiria() {
	return hiria;
}

public void setHiria(String hiria) {
	this.hiria = hiria;
}

public Vector<Bezero> getBezeroak() {
	return bezeroak;
}

public void setBezeroak(Vector<Bezero> bezeroak) {
	this.bezeroak = bezeroak;
}

public Vector<SukurtsalDibisa> getSukurtsalDibisa() {
	return SukurtsalDibisa;
}

public void setSukurtsalDibisa(Vector<SukurtsalDibisa> sukurtsalDibisa) {
	SukurtsalDibisa = sukurtsalDibisa;
}

public SukurtsalDibisa getSukurtsalDibisa(Dibisa dibisa) {
	
	
	for (SukurtsalDibisa v : this.SukurtsalDibisa) {
		
		SukurtsalDibisaContainer skc = new SukurtsalDibisaContainer(v);
		
		if(dibisa.getMota().equals(skc.getDibisa().getMota()) ) {
			return v;
		}
	}
	
	return null;
}


public SukurtsalDibisa addSukurtsalDibisa(Integer sdID, float kop, int komisioa, Dibisa dibisa)  {
	SukurtsalDibisa sd=new SukurtsalDibisa(sdID, kop, komisioa, this, dibisa);
    this.SukurtsalDibisa.add(sd);
    dibisa.addSukurtsalDibisa(sd);
    return sd;
}

public Sukurtsal gehituGuztiak(List<domain.SukurtsalDibisa> list) {

	this.SukurtsalDibisa.addAll(list);
    return this;
}

public Integer getID() {
	return this.sukurtsalID;
}

}