package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez saisir le premier nombre...");
		int i = scan.nextInt();
		System.out.println("Veuillez saisir le second nombre...");
		int j = scan.nextInt();
		System.out.println(i+" + "+j+" = " +(i+j));
		System.out.println(i+" - "+j+" = " +(i-j));
		System.out.println(i+" * "+j+" = " +(i*j));
		System.out.println(i+" / "+j+" = " +(i/j));
		System.out.println(i+" % "+j+" = " +(i%j));
	}

}
