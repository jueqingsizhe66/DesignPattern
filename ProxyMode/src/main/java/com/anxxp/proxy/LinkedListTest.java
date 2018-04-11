package com.anxxp.proxy;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
//栈
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<10;i++)
			stack.push(i);
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		Iterator<Integer> iterator = stack.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next());
		System.out.println();
		//队列
		Queue<Integer> queue = new Queue<Integer>();
		for(int i=0;i<10;i++)
			queue.enqueue(i);
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		iterator = queue.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next());
	}
}
//很使用使用代理模式利用LinkedList实现一个栈
class Stack<T> implements Iterable<T>{
	private LinkedList<T> stack = new LinkedList<T>();
	public T pop(){//出栈，会删除栈顶元素
		return stack.poll();
	}
	public T peek(){//出栈,但不删除栈顶元素
		return stack.peek();
	}
	public void push(T t){//入栈
		stack.push(t);
	}
	@Override
	public Iterator<T> iterator() {
		return stack.iterator();
	}
}
//很使用使用代理模式利用LinkedList实现一个队列
class Queue<T> implements Iterable<T>{
	private LinkedList<T> queue = new LinkedList<T>();
	public void enqueue(T t){
		queue.offer(t);
	}
	public T dequeue(){
		return queue.poll();
	}
	public T peek(){
		return queue.peek();
	}
	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
}
