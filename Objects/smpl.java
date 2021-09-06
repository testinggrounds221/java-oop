public class smpl {

}

class Car {
	int mileage;
	int state;
	int speed;
	static int count;
	static int no_of_wheels;

	void increaseSpeed() { // Mutator-
		speed++;
	}

	int getSpeed() { // Accessor
		return speed;
	}

	static void incCount() {
		count++;
	}

	public static void main(String[] args) {
		Car volvo = new Car();
		volvo.speed = 10;
		Car c2 = new Car();
		Car c3 = new Car();
		Car.count++;
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		c3.increaseSpeed();
		// c2.incCount();
		// c3.incCount();
		// c3.incCount();
		// c2.incCount();
		System.out.println(volvo.speed);
		System.out.println(c2.speed);

		volvo.mileage = 90;
	}

}
