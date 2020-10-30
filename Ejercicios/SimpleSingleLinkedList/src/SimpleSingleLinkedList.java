import java.util.Iterator;

public class SimpleSingleLinkedList<E> implements Iterable {
	private DataLink<E> header = null;
	private int size;
	
	public SimpleSingleLinkedList() {
		header = new DataLink<E>(null);
		size = 0;
	}
	
	public DataLink(E theData) {
		data = theData;
		nextDataLink = null;
	}
	
	
}
