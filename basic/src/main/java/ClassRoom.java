import java.util.LinkedList;

public class ClassRoom {
	// do not extends LinkedList<Student> , ClassRoom and LinkedList is very different!
	private LinkedList<Student> list = new LinkedList<Student>();
	
	public Student get(int index) {
		return list.get(index);
	}
	
	public void add(Student s) {
		if (this.list.size() > 50) {
			throw new IllegalArgumentException("One class cannot larger than 50! ");
		}
		list.add(s);
	}
	
}
