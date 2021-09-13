package electricConsumption;

import java.io.*;

/**
 * electricityConsumption
 */
public interface ElectricityConsumption {
	int baseAmount = 5;
	int secondLevelAmount = 7;
	int thirdLevelAmount = 11;
	int fourthLevelAmount = 14;

	boolean getInput() throws IOException;

	int calculateBill();

	boolean processPayment() throws IOException;

	void printBill();

}