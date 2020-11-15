package iterator;

import java.util.Iterator;

public interface ExtendedIterator extends Iterator{

	public Object previous();
	
	public boolean hasPrevious();
	
	public void goFirst();
	
	public void goLast();
	
	
	
	
}
