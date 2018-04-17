package WithDecorate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReadOnlyListNew<E> implements List<E> {

	// composite rule
	private List<E> target;

	public ReadOnlyListNew(List<E> target) {
		super();
		this.target = target;
	}

	@Override
	public int size() {
		return target.size();
	}

	@Override
	public boolean isEmpty() {
		return target.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return target.contains(o);
	}

/*
    @Override
    public Iterator<E> iterator() {
        return target.iterator();// something missed
    }
*/

	@Override
	public Object[] toArray() {
		return target.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return target.toArray(a);
	}

	@Override
	public boolean add(E e) {
		throw new RuntimeException("Only read list, cannot be added");
	}

	@Override
	public boolean remove(Object o) {
		throw new RuntimeException("Only read list, cannot be removed");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return target.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {

		throw new RuntimeException("Only read list, cannot be added");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new RuntimeException("Only read list, cannot be added");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new RuntimeException("Only read list, cannot be removed");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new RuntimeException("Only read list, cannot be removed");
	}

	@Override
	public void clear() {

		throw new RuntimeException("Only read list, cannot be removed");
	}

	@Override
	public E get(int index) {
		return target.get(index);
	}

	@Override
	public E set(int index, E element) {
		throw new RuntimeException("Only read list, cannot be mmodified");
	}

	@Override
	public void add(int index, E element) {

		throw new RuntimeException("Only read list, cannot be added");
	}

	@Override
	public E remove(int index) {
		throw new RuntimeException("Only read list, cannot  be removed");
	}

	@Override
	public int indexOf(Object o) {
		return target.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {

		return target.lastIndexOf(o);
	}

	@Override
	public Iterator<E> iterator() {
		//return target.iterator();//todo：这里有漏洞
		return this.listIterator();
	}


	@Override
	public ListIterator<E> listIterator() {
		//  return target.listIterator(); //missed  bugs
		return new ReadOnlyListIterator<E>(target.listIterator());
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		//return target.listIterator(index);
		return new ReadOnlyListIterator<E>(target.listIterator());
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return target.subList(fromIndex, toIndex);
	}
}
