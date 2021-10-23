package phoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	private static Scanner sc1;

	public static void main(String[] args) {

		// Initial Array Initialized with 3 persons
		Address johnDoeAdd = new Address("114 Market St", "St Louis", "MO", "63403");
		Person johnDoe = new Person("John", "", "Doe", "2456895241", johnDoeAdd);
		Address johnEDoeAdd = new Address("324 Main St", "St Charles", "MO", "63303");
		Person johnEDoe = new Person("John", "E", "Doe", "8475390126", johnEDoeAdd);
		Address johnMDoeAdd = new Address("574 Pole ave", "St. Peters", "MO", "63333");
		Person johnMDoe = new Person("John Michael", "", "West Doe", "5628592375", johnMDoeAdd);

		Person[] persons = new Person[3];
		persons[0] = johnDoe;
		persons[1] = johnEDoe;
		persons[2] = johnMDoe;
		int choice = 0;
		while (choice != 11) {
			choice = menu();
			switch (choice) {
			case 1:
				System.out.println("Add a new person");
				add();
			case 2:
			case 3:
			case 11:
				break;

			}
		}
	}

	private static int max_size = 10;
	private static int total = 0;
	private static Person persons[];

	public static int menu() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Hello, welcome to the PHONEBOOK!");
		System.out.println("\n1.add new entries" + "\n2.serach by firstName" + "\n3.search by lastName"
				+ "\n4. search by fullName" + "\n5. search by telephoneNumber" + "\n 6. search by city"
				+ "\n7. search by state	 " + "\n8. delete the record for a given telephone number"
				+ "\n9. update a record for a given telephone number" + "\n10.show all records in asc order"
				+ "\n11. exit");

		int choice = sc1.nextInt();
// keyboard.nextLine();
		System.out.println();

		return choice;

	}

	public static void add() {
		Scanner sc1 = new Scanner(System.in);

		expand();
		System.out.println("firstName,lastName,street,city,state,zipode, telephone");

		String input = sc1.nextLine();
		String splits[] = input.split(",");
		for (int i = 0; i < splits.length; i++) {
			splits[i] = splits[i].strip();

		}
		String names[] = splits[0].split(" ", 2);
		Address address = new Address(splits[1], splits[2], splits[3], splits[4]);
		Person p = new Person(names[0], names[1], splits[5], address);
		persons[total] = p;
		total++;

	}

	public static void expand() {
		int new_max = 2 * max_size;
		Person new_persons[] = new Person[new_max];
		for (int i = 0; i < total; i++) {
			new_persons[i] = persons[i];
		}
		max_size = new_max;
		persons = new_persons;
		Address JohnDoeAdd = new Address("114 Market St", "St Louis", "MO", "63403");
		Person JohnDoe = new Person("John", "", "Doe", "2456895241", JohnDoeAdd);
		Address JohnEDoeAdd = new Address("324 Main St", "St Charles", "MO", "63303");
		Person JohnEDoe = new Person("John", "E", "Doe", "8475390126", JohnEDoeAdd);
		Address JohnMDoeAdd = new Address("574 Pole ave", "St. Peters", "MO", "63333");
		Person JohnMDoe = new Person("John Michael", "", "West Doe", "5628592375", JohnMDoeAdd);
		Person[] persons = new Person[3];
		persons[0] = JohnDoe;
		persons[1] = JohnEDoe;
		persons[2] = JohnMDoe;
	}

	public static List<Person> search_firstName() {
		System.out.print("Enter first name:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if (p.getFirstName().equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static List<Person> search_LastName() {
		System.out.print("Enter last name:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if (p.getLastName().equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static List<Person> search_fullName() {
		System.out.print("Enter full name:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if ((p.getFirstName() + " " + p.getLastName()).equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static List<Person> search_telephone() {
		System.out.print("Enter Telephone:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if ((p.getTelephone()).equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static List<Person> search_city() {
		System.out.print("Enter city:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if ((p.getAddress().getCity()).equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static List<Person> search_state() {
		System.out.print("Enter state:");
		String fname = sc1.nextLine();
		List<Person> l = new ArrayList<Person>();
		for (int i = 0; i < total; i++) {
			Person p = persons[i];
			if ((p.getAddress().getState()).equals(fname)) {
				l.add(p);
			}
		}
		return l;
	}

	public static void deleteRecord() {
		System.out.print("Enter telephone number:");
		String fname = sc1.nextLine();
		for (int i = 0; i < total;) {
			if (persons[i].getTelephone().equals(fname)) {
				while (i < total - 1) {
					persons[i] = persons[i + 1];
					i++;
				}
			}
			System.out.print("record deleted");
			total--;
			return;
		}
		System.out.println("The telephone number was not found.");
	}

	public static void updateRecord() {
		System.out.print("Enter telephone number:");
		String fname = sc1.nextLine();
		for (int i = 0; i < total; i++) {
			if (persons[i].getTelephone().equals(fname)) {
				System.out.println(persons[i] + "\n");
				System.out.println("Enter new firstName");
				persons[i].setFirstName(sc1.nextLine());

				System.out.println("Enter new Last Name");
				persons[i].setLastName(sc1.nextLine());

				Address a = persons[i].getAddress();

				System.out.println("Enter new Street");
				a.setStreet(sc1.nextLine());
				System.out.println("Enter new city");
				a.setCity(sc1.nextLine());

				System.out.println("Enter new State");
				a.setState(sc1.nextLine());

				persons[i].setAddress(a);

				System.out.println("Record updated");
				return;
			}
			System.out.println("The telephone number wasnt found");
		}

	}

	public static void sort() {
		for (int i = 0; i < total - 1; i++) {
			int mix_idx = i;
			for (int j = i + 1; j < total; j++)
				if (persons[j].getTelephone().compareTo(persons[mix_idx].getTelephone()) < 0)
					mix_idx = j;
			Person temp = persons[mix_idx];
			persons[mix_idx] = persons[i];
			persons[i] = temp;
		}
		for (int i = 0; i < total; i++)
			System.out.println(persons[i]);

	}

	public static void printList(List<Person> list) {
		for (Person p : list)
			System.out.println(p);
		System.out.println();
	}

//public static void main(String args[])
	{
		sc1 = new Scanner(System.in);
		persons = new Person[max_size];
		while (true) {
			int choice = menu();
			if (choice == 1)
				add();
			else if (choice == 2)
				printList(search_firstName());
			else if (choice == 3)
				printList(search_LastName());
			else if (choice == 4)
				printList(search_fullName());
			else if (choice == 5)
				printList(search_telephone());
			else if (choice == 6)
				printList(search_city());
			else if (choice == 7)
				printList(search_state());
			else if (choice == 8)
				deleteRecord();
			else if (choice == 9)
				updateRecord();
			else if (choice == 10)
				sort();
			else if (choice == 11)
				break;
			else
				System.out.println("Invalid choice");
		}
	}
}

