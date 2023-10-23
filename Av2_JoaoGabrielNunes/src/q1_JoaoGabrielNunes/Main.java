package q1_JoaoGabrielNunes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// array para guardar os dados;
		ArrayList nicks = new ArrayList();
		
		//perguntas para pegar os dados;
		System.out.println("Say name of company:");
		Company c = new Company(s.nextLine());

		
		System.out.println("Say name of Employs:");
		Employee e = new Employee(s.next());
		
		System.out.println("Say your registration number and transmission:");
		Car cs = new Car(s.next(),s.nextLine());
	
		System.out.println("Say your registration number and mass:");
		Truck t = new Truck(s.next(),s.nextInt());
		
		//exibição de dados;
		System.out.println("\n --- SUCEFULLY CREATE COMPANY ---");
		System.out.println("Name company: "+c.getName());
		
		System.out.println("\n --- NEW EMPLOY CREATE ---");
		System.out.println("Name employs: "+e.getName());
		
		// decisão de carro ou truck;
		System.out.println("Choose 1 for car and 2 for tryuck:");
		if(s.nextInt() == 1) {
			System.out.println("\n --- NEW CAR IS CREATED ---");
			System.out.println("Registration: "+cs.getRegistrationNumber());
			System.out.println("Transmission: "+cs.getTransmission());
		}else {
			System.err.println("\n --- NEW TRUCK IS CREATED ---");
			System.out.println("Registration: "+t.getRegistrationNumber());
			System.out.println("Mass truck: "+t.getMass());
		}
		s.close();
		//para armazenar os dados;
		nicks.add(c.getName());
		nicks.add(e.getName());
		nicks.add(cs.getRegistrationNumber());
		nicks.add(cs.getTransmission());
		nicks.add(t.getMass());
		nicks.add(t.getRegistrationNumber());
		
		}
	

}
	