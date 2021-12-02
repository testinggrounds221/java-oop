/**
 *
 * @author Nishanth
 */
public class Node {
	Node next;
	Node prev;
	String data;

	void setData(String v)
	{
		data = v;
	}

	void setNext(Node n)
	{
		next = n;
	}

	String getData()
	{
		return data;
	}

	Node getNext()
	{
		return next;
	}

	void setPrev(Node n)
	{
		prev = n;
	}

	Node getPrev()
	{
		return prev;
	}
}

    

