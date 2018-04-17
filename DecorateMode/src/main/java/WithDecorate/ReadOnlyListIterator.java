package WithDecorate;

import java.util.ListIterator;

public class ReadOnlyListIterator<E> implements ListIterator<E> {

	private ListIterator<E> target;


	public ReadOnlyListIterator(ListIterator<E> target) {
		super();
		this.target = target;
	}

	@Override
	public boolean hasNext() {
		return target.hasNext();
	}

	@Override
	public E next() {
		return target.next();
	}

	@Override
	public boolean hasPrevious() {
		return target.hasPrevious();
	}

	@Override
	public E previous() {
		return target.previous();
	}

	@Override
	public int nextIndex() {
		return target.nextIndex();
	}

	@Override
	public int previousIndex() {
		return target.previousIndex();
	}

	@Override
	public void remove() {
		throw new RuntimeException("Only read list");
	}

	@Override
	public void set(E e) {

		throw new RuntimeException("Only read list");
	}

	@Override
	public void add(E e) {

		throw new RuntimeException("Only read list");
	}


  /*  //Important right below

    @Override
    public Iterator<E> iterator() {
        //return target.iterator();//todo：这里有漏洞
        return this.listIterator();
    }
    @Override
    public ListIterator<E> listIterator() {
        //return target.listIterator();//todo：这里有漏洞
        return new ReadOnlyListIterator<E>(target.listIterator());
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        //return target.listIterator(index);//todo：这里有漏洞
        return new ReadOnlyListIterator<E>(target.listIterator(index));
    }
*/
}
