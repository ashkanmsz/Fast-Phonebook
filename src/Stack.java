
public class Stack {

	LinkedList l = new LinkedList();

	public Stack() {
		
	}
	
	public Stack(Node head) {
		l.setHead(head);
		l.setTail(head);
		l.size++;
	}

	public void push(Object d) {
		l.addLast(d);
	}

	public Node pop() {
		Node top=new Node();
		top=l.getLast();
		l.deleteLast();
		return top;
	}

	public Node peek() {
		return l.getLast();
	}
	
	public Node getlast() {
		return l.getFirst();
	}

	public long size() {
		return l.size;
	}

	public void clear() {
		l.clear();
	}

	public boolean isEmpty() {
		return l.isEmpty();
	}

}
