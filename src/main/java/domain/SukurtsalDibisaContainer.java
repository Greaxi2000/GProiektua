package domain;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD )
public class SukurtsalDibisaContainer {
private Dibisa dibisa;
private SukurtsalDibisa sk;
public SukurtsalDibisaContainer(SukurtsalDibisa s) {
this.sk = s;
this.dibisa=s.getDibisa(); }
public SukurtsalDibisaContainer() {
sk = null;
dibisa = null; }
public Dibisa getDibisa(){
return dibisa; }
public SukurtsalDibisa getSukurtsalDibisa(){
return sk; }
public String toString(){
return sk+"/"+dibisa; }
}
