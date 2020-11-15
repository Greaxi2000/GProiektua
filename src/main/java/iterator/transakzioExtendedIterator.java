package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import domain.Transakzio;

public class transakzioExtendedIterator implements ExtendedIterator{

	List<Transakzio> transakzioak;
	int position=0;
	
	public transakzioExtendedIterator(List<Transakzio> t) {
		this.transakzioak = t;
	}
	
	@Override
	public Object previous() {
		//Oraingo balioa bueltatu eta aurreko posiziora itzuli
		Transakzio transakzio=transakzioak.get(position);
		position--;
		return transakzio;
	}
	@Override
	public boolean hasPrevious() {
		//Posizioa 0 bada ez du aurrekorik izango
		return position>=0;
	}
	@Override
	public void goLast() {
		//Posizioa azkenekora aldatu
		position = transakzioak.size()-1;
		
	}
	
	@Override
	public void goFirst() {
		
		position = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position<transakzioak.size();
	}

	@Override
	public Object next() {
		Transakzio transakzio=transakzioak.get(position);
		position++;
		return transakzio;
	}

}
