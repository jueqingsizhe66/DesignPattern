package WithDecorate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
限制集合最大大小的SizeLimitList：
 */
public class SizeLimitList <E> implements List<E>  {
    /*
    组合模式  组合原则优于继承模式

    ArrayList : 加 搜 查能力强   加和搜能力强           +  get
    LinkedList  :   减  修改能力强（能力只是单方面)     -  modify


    如果使用extends LikedList<E> 也可以实现  但是不方便拓展， 比如当前情况下既可以是LinkedLsit 也可以是ArrayLIst
    而如果是LinkedList集成，则只能是LinkedList  到ArrayList必须新建一个对象.
     */
    private List<E> target;
    private int maxSize;

    public SizeLimitList(List<E> target,int maxSize) {
        super();
        this.target = target;
        this.maxSize = maxSize;
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
    public Iterator<E> iterator() {
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
    public boolean add(E e) {
        if(target.size()>=maxSize)
        {
            throw new RuntimeException("已经达到最大大小");
        }
        else
        {
            return target.add(e);
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
    public boolean addAll(Collection<? extends E> c) {
        if(target.size()+c.size()>maxSize)
        {
            throw new RuntimeException("加上c之后将会达到最大大小");
        }
        else
        {
            return target.addAll(c);
        }
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
    public boolean addAll(int index, Collection<? extends E> c) {
        if(target.size()+c.size()>maxSize)
        {
            throw new RuntimeException("加上c之后将会达到最大大小");
        }
        else
        {
            return target.addAll(index,c);
        }
    }

    @Override
    public E get(int index) {
        return target.get(index);
    }

    @Override
    public E set(int index, E element) {
        return target.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        if(target.size()>=maxSize)
        {
            throw new RuntimeException("已经达到最大大小");
        }
        else
        {
            target.add(index,element);
        }
    }

    @Override
    public E remove(int index) {
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
    public ListIterator<E> listIterator() {
        return target.listIterator();//todo：这里有漏洞
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return target.listIterator(index);//todo：这里有漏洞
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return target.subList(fromIndex, toIndex);
    }

}
