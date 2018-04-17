package WithDecorate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StringLenLimitList implements List<String> {
	private List<String> target;
	private int maxStringLen;


	public StringLenLimitList(List<String> target) {
		this.target = target;
		this.maxStringLen = maxStringLen;
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

	@Override
	public Iterator<String> iterator() {
		return target.iterator();
	}

	@Override
	public Object[] toArray() {
		return target.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return target.toArray(a);
	}

	@Override
	public boolean add(String e) {
		if (e.length() <= maxStringLen) {
			return target.add(e);
		} else {
			throw new RuntimeException("字符串长度超长");
		}
	}

	@Override
	public boolean remove(Object o) {
		return target.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return target.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		for (String s : c) {
			if (s.length() > maxStringLen) {
				throw new RuntimeException("字符串" + s + "长度超长");
			}
		}
		return target.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		for (String s : c) {
			if (s.length() > maxStringLen) {
				throw new RuntimeException("字符串" + s + "长度超长");
			}
		}
		return target.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return target.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return target.retainAll(c);
	}

	@Override
	public void clear() {
		target.clear();
	}

	@Override
	public String get(int index) {
		return target.get(index);
	}

	@Override
	public String set(int index, String element) {
		if (element.length() <= maxStringLen) {
			return target.set(index, element);
		} else {
			throw new RuntimeException("字符串长度超长");
		}
	}

	@Override
	public void add(int index, String element) {
		if (element.length() <= maxStringLen) {
			target.add(index, element);
		} else {
			throw new RuntimeException("字符串长度超长");
		}

	}

	@Override
	public String remove(int index) {
		return target.remove(index);
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
	public ListIterator<String> listIterator() {
		return target.listIterator();
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		return target.listIterator(index);
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		return target.subList(fromIndex, toIndex);
	}

}
