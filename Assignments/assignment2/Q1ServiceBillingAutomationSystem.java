package assignment2;

import java.util.*;

class NegativeValueException extends Exception {
	int number;

	NegativeValueException(int num) {
		this.number = num;
	}

	public String toString() {
		return "\nError : Model Number - " + number + " Cannot be Negative";
	}
}

class InvalidVehicleNoException extends Exception {
	String vehicleNumber;

	InvalidVehicleNoException(String num) {
		this.vehicleNumber = num;
	}

	public String toString() {
		return "\nError : Vehicle Number - " + vehicleNumber + " is Invalid";
	}
}

public class Q1ServiceBillingAutomationSystem {
	String vehicle_no;
	int Vehicle_model, spare_parts_details;
	double spare_parts_price;
	double water_service_charge;
	double oil_service_charge;

	static final int spare_parts_price_catalog[] = { 1400, 1500, 3600, 7700 };
	static final int water_service_charge_catalog[] = { 2400, 1500, 3600, 7700 };
	static final int oil_service_charge_catalog[] = { 1400, 1500, 3600, 7700 };

	Q1ServiceBillingAutomationSystem(int vModel, String vNo, int spareDetails) {
		this.Vehicle_model = vModel;
		this.vehicle_no = vNo;
		this.spare_parts_details = spareDetails;
	}

	void calculatePrice() {
		this.spare_parts_price = spare_parts_details * spare_parts_price_catalog[this.Vehicle_model];
		this.water_service_charge = water_service_charge_catalog[this.Vehicle_model];
		this.oil_service_charge = oil_service_charge_catalog[this.Vehicle_model];
	}

	double getTotalServiceCharge() {
		return this.spare_parts_price + this.water_service_charge + this.oil_service_charge;
	}

	static void validateModelNumber(int num) throws NegativeValueException {
		if (num <= 0)
			throw new NegativeValueException(num);
	}

	static void validateVehicleRegistration(String vNo) throws InvalidVehicleNoException {
		for (int i = 0; i < vNo.length(); i++) {
			char c = vNo.charAt(i);
			if (!(Character.isDigit(c) || Character.isLetter(c)))
				throw new InvalidVehicleNoException(vNo);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Service Billing Automation System");
		int vNumber = 0, spareDetails = 0;
		String vNumString = "";
		try {
			System.out.println("Enter Vehicle Model Number");
			vNumber = sc.nextInt();
			validateModelNumber(vNumber);

			System.out.println("Enter Spare Details (Number)");
			spareDetails = sc.nextInt();
			validateModelNumber(spareDetails);

			System.out.println("Enter Vehicle Registration Info");
			sc.nextLine();
			vNumString = sc.nextLine();
			validateVehicleRegistration(vNumString);
		} catch (InvalidVehicleNoException ive) {
			System.out.println(ive);
			System.exit(-1);
		} catch (NegativeValueException nve) {
			System.out.println(nve);
			System.exit(-1);
		}

		Q1ServiceBillingAutomationSystem sbas = new Q1ServiceBillingAutomationSystem(vNumber, vNumString, spareDetails);
		sbas.calculatePrice();
		System.out.println("Amount to be Paid : " + sbas.getTotalServiceCharge());
		sc.close();
	}
}