/**
 *
 * @author Nishanth
 */
public class DLinkedList {
    Node first;
	Node last;

	void insert(String v)
	{
		Node p = new Node();
		p.setData(v);
		if(first == null)
		{
			p.setPrev(null);
			first = p;
			last = p;
		}
		else
		{
			Node q = first;
			while(q.getNext() != null)
			{
				q = q.getNext();
			}
			q.setNext(p);
			p.setPrev(q);
			last = p;
		}
	}

	void Traverse()
	{
		Node temp = first;
		System.out.println("Ascending Traverse");
		while(temp != null)
		{
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		/*
		temp = last;
		System.out.println("Descending Traverse");
		while(temp != null)
		{
			System.out.println(temp.getData());
			temp = temp.getPrev();
		}
	*/
	}

	void delete(String v)
	{
		Node q = first;
		while(q.getNext() != null)
		{
			if((q.getPrev() == null) && (q.getData() == v))
			{
				q.getNext().setPrev(q.getPrev());
				first = q.getNext();
				break;
			}

			else
			{
				if(q.getData() == v)
				{
					q.getPrev().setNext(q.getNext());
					q.getNext().setPrev(q.getPrev());
					break;
				}
			}

			q = q.getNext();
		}
		if(q.getNext() == null && q.getData() == v)
		{
			last = q.getPrev();
			last.setNext(null);
		}
	}
    
}
