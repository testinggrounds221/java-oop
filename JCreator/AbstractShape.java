abstract class Shape{
	private int len;
	private int breadth;
	public int getLen(){return len;}
	public int getBreadth(){return breadth;}
	public void setMes(int l, int b){
		this.len = l;
		this.breadth= b;
		}
	abstract void printArea();
}

class Rectangle extends Shape{
	Rectangle(int l, int b){
		setMes(l,b);
	}
	void printArea()	{
		System.out.println("Area is "+ getLen()*getBreadth());
		}
}

public class AbstractShape{
	static void printArea(Shape s){ // UPCASTING
		s.printArea();
	}

	public static void main (String[] args) {
		printArea(new Rectangle(2,4));
  }
}