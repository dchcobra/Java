package raceManagerSystem;
import java.util.Scanner;

import raceManagerObjects.*;

public class Program {
	public static final int menuStars = 65;
	private static InfiniteSkillsRace isr;
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		printWelcome();
		boolean completedEntries = false;
		while (!completedEntries) {
			int choice = printMenu();
			switch(choice) {
				case 1:
					isr = new InfiniteSkillsRace();
					System.out.println("Created a new Race");
					break;
				case 2:
					if (checkRaceCreated()) {
						System.out.println("What is the racer name?");
						String n = input.nextLine();
						System.out.println("What is the racer age?");
						int a = Integer.parseInt(input.nextLine());
						System.out.println("What type of racer is this [B, S , R]");
						String t = input.nextLine();
						Athlete aRacer = null;
						
					if (t.equalsIgnoreCase("b")) {
						System.out.println("Does this biker use clips [y/n]?");
						String uci = input.nextLine();
						boolean uc = false;
						if (uci.charAt(0) == 'y' || uci.charAt(0) == 'Y') {
							uc = true;
						}
						aRacer = new Biker(n, a, 0, uc);
						} else if(t.equalsIgnoreCase("s")) {
							aRacer = new Swimmer(n,a,0) ;
						} else {
							System.out.println("What brand of shoes does this runner use?");
							String shoes = input.nextLine();
							aRacer = new Runner(n,a,0,shoes);
						}
						
						if (aRacer != null) {
							boolean addRacer = isr.addRacer(aRacer);
							if (addRacer) {
								printRacer("Succesfully added racer: ", aRacer);
							} else {
								System.out.println("Could not add the racer!");
							}
						}
					}
					else {
						System.out.println("You must create the race first!");
					}
					break;
				case 3:
					if (checkRaceCreated()) {
						System.out.println("What is the nadme of the racer to remove=");
						String n = input.nextLine();
						boolean removed = isr.removeRacer(n);
						if (removed) {
							System.out.println("Succesfully Removed Athlete" + n);
						} else {
							System.out.println("Could not remove athlete with name; " + n);
						}
					} else {
						System.out.println("You must create the race first!");
					}
					break;
				case 4:
					if (checkRaceCreated()) {
						System.out.println("What is the name of the racer to find?");
						String n = input.nextLine();
						Athlete a = isr.getRacer(n);
						if (a != null) {
							printRacer("Racer Detauks; ", a);
						} else {
							System.out.println("Could not find athlete with name " + a);
						}
					
					} else {
						System.out.println("You must create the race first");
					}
					break;
				case 5:
					if (checkRaceCreated()) {
						Athlete a = isr.getWinner();
						if (a != null) {
							printRacer("The winner is: ", a);
						}
					} else {
						System.out.println("You must create the race first");
					}
					break;
				case 6:
					if (checkRaceCreated()) {
						Athlete[] racers = (Athlete[])isr.getRacers();
						if (racers != null && racers.length > 0) {
							for (Athlete a : racers) {
								printRacer("Next racer: ", a);
							}
						} else {
							System.out.println("Please add some racers first");
						}
					} else {
						System.out.println("You must create the race first.");
					}
					break;
				case 7:
					default:
						completedEntries = true;
				}
			}
			printCompleted();
		}
	

	public static int printMenu() {
		stars(menuStars);
		System.out.println("Enter 1 to create a new race");
		System.out.println("Enter 2 to add a new race");
		System.out.println("Enter 3 to remove a new race");
		System.out.println("Enter 4 to find a new race");
		System.out.println("Enter 5 to get a new race");
		System.out.println("Enter 6 to list a new race");
		System.out.println("Enter 7 to quit");
		stars(menuStars);
		return Integer.parseInt(input.nextLine());
	}
	
	public static void printRacer(String message, Athlete a) {
		dashes(menuStars);
		String outputDetails = "%s] Name: %s Age: %s RacerId: %s Activity: %s %s";
		String t = null;
		String extra = null;
		if (a instanceof Runner) {
			t = "Runner";
			Runner r = (Runner)a;
			extra = "Shoes; " + r.getShoeBrand();
		} else if (a instanceof Biker) {
			t = "Biker";
			Biker b = (Biker)a;
			extra = "Using Clips; " + b.getUsingClips();
		} else if (a instanceof Swimmer) {
			t = "Swimmer";
			extra = "";
		}
		System.out.println(String.format(outputDetails
										, t
										, a.getName()
										, a.getAge()
										, a.getRacerId()
										, extra));
		dashes(menuStars);	
	}
	
	public static boolean checkRaceCreated() {
		return isr != null;
	}

	public static void printWelcome() {
		stars(menuStars);
		System.out.println("Welcome to the Infinite Sills Race Manager");
		System.out.println("What Would you like to do today?");
		stars(menuStars);
	}
	
	public static void printCompleted() {
		stars(menuStars);
		System.out.println("Ty for using Infinite Sills Race Manager");
		
		stars(menuStars);
	}
	
	public static void stars(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("*");
		}
		System.out.println("\n");
	}
	
	public static void dashes (int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("-");
		}
		System.out.println("\n");
	}
	
}