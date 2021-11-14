import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.*;

interface InnerPlacementSystem {
	static final String[] GENERAL_COMP = { "TCS", "CTS", "Infosys" }; // categ = 3
	static final String[] DREAM_COMP = { "Hitachi", "Yamaha", "Publicis Sapient" }; // categ = 2
	static final String[] SUPER_DREAM_COMP = { "HSBC", "Google", "Goldman" }; // categ = 1
	static final double[] CGPA = { 0, 7.5, 7 }; // categ = 1

	void conductOrientation();

	void getInput();

	void sendDataToIndustry();

	void checkEligibiltyCategory();

	void colllectResume();

	void conductAptitude();

	void startTraining();

	void conductInterview();

	void collectInterviewPerformance();

	void receiveAppoinmentOrders();
}

class Candidate {
	String name;
	double CGPA;
	String regNo;
	int categ;
}

public class PlacementSystem {
	Logger logger;
	Candidate cand;
	int currCateg;
	boolean currRes;
	Scanner sc;

	void getInput() {
		logger.severe("Getting Candidate Details");
		cand = new Candidate();
		System.out.println("Enter name of candidate : ");
		cand.name = sc.next();
		System.out.println("Enter CGPA of candidate : ");
		cand.CGPA = sc.nextDouble();
		System.out.println("Enter regNo of candidate : ");
		cand.regNo = sc.next();
	}

	void conductOrientation() {
		logger.finer("Orientation Started ");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}
		logger.finer("Orientation Completed");
	}

	void colllectResume() {
		logger.severe(String.format("Submit Resume of Candidate %s: ", cand.regNo));
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}
		logger.info(String.format("Resume Collected for Candidate %s: ", cand.regNo));
	}

	void sendDataToIndustry() {
		logger.finest("Sending candidate Data to industries");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}
	}

	void conductInterview() throws Exception {
		logger.info("Conducting interview for candidate " + cand.regNo);
		logger.fine("Conducting for Category " + this.currCateg);
		if (Math.random() < 0.5)
			this.currRes = true;
		else
			this.currRes = false;
		logger.fine("Inteview Completed " + this.cand.regNo);
		System.out.println("Inteview Completed for Candidate ");
		this.receiveAppoinmentOrders();
	}

	void receiveAppoinmentOrders() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		if (!this.currRes) {
			logger.info(cand.regNo + " Did not clear current round");
			System.out.println("Did not clear current round");
			System.out.print("Do you want to Try again or quit?(1 to continue)");

			choice = Integer.parseInt(in.readLine());
			if (choice == 1) {
				logger.info(cand.regNo + " Choose to try Again");
				this.conductInterview();
			} else {
				logger.info(cand.regNo + " Choose to Quit Placement");
				System.out.println(cand.regNo + " Exiting Placement");
				System.exit(0);
			}

		} else {
			logger.info(cand.regNo + " Cleared Category " + this.currCateg);
			System.out.println("Cleared Category " + this.currCateg);

			if (this.currCateg == 1) {
				logger.info(cand.regNo + " Placed in Super Dream");
				System.out.println("Placed in Super Dream");
				logger.info(cand.regNo + " Quit Placement");
				System.out.println(cand.regNo + " Exiting Placement");
				return;
			}
			if (this.currCateg == 2) {
				if (cand.CGPA > 7.5) {
					System.out.println("Do you want to Move up ?(1 to continue) : ");
					choice = Integer.parseInt(in.readLine());
					if (choice == 1) {
						logger.info(cand.regNo + " Choose to Move up");
						this.currCateg--;
						conductInterview();
					}
				} else {
					logger.info(cand.regNo + " Placed in Dream Slot");
					System.out.println("Placed in Dream Slot. Cannot Move Upwards");
					logger.info(cand.regNo + " Quit Placement");
					System.out.println(cand.regNo + " Exiting Placement");
				}
			}
			if (this.currCateg == 3) {
				if (cand.CGPA > 7.0) {
					System.out.println("Do you want to Move up ?(1 to continue) : ");
					choice = Integer.parseInt(in.readLine());
					if (choice == 1) {
						logger.info(cand.regNo + " Choose to Move up");
						this.currCateg--;
						conductInterview();
					}
				} else {
					logger.info(cand.regNo + " Placed in Dream Slot");
					System.out.println("Placed in Dream Slot. Cannot Move Upwards");
					logger.info(cand.regNo + " Quit Placement");
					System.out.println(cand.regNo + " Exiting Placement");
				}
			}
		}
	}

	void collectInterviewPerformance() {

	}

	void checkEligibiltyCategory() {
		if (cand.CGPA > 7.5)
			cand.categ = 1;
		else if (cand.CGPA > 7.0)
			cand.categ = 2;
		else
			cand.categ = 3;
		this.currCateg = cand.categ;
		logger.finer(cand.regNo + " Initially Elegible for Category " + this.currCateg);
	}

	void startTraining() {
		logger.fine("Training Started");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}

		logger.fine("Training Completed");
	}

	PlacementSystem() {
		sc = new Scanner(System.in);
		LogManager logManager = LogManager.getLogManager();
		this.logger = Logger.getLogger("PlacementSystem");
		logger.setLevel(Level.ALL);
		try {
			FileHandler ch = new FileHandler("placementLogger.log");
			ch.setFormatter(new SimpleFormatter());
			logger.addHandler(ch);
		} catch (Exception e) {
			System.out.println("Failed to Initialise Logger");
		}
		logManager.addLogger(logger);
	}

	protected void finalize() {
		sc.close();
	}

	public static void main(String[] args) throws Exception {
		PlacementSystem pc = new PlacementSystem();
		pc.conductOrientation();
		pc.startTraining();
		pc.getInput();
		pc.colllectResume();
		pc.checkEligibiltyCategory();
		pc.sendDataToIndustry();
		pc.conductInterview();
	}
}
