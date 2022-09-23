package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<TaxPayer> taxPayers = new ArrayList<>();

		System.out.print("Enter the numbers of tax payers: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer data:");
			System.out.print("Individual or Company? (i/c) ");
			char ans = scanner.next().charAt(0);
			scanner.nextLine();

			System.out.print("Name: ");
			String name = scanner.nextLine();

			System.out.print("Anual income: ");
			double anualIncome = scanner.nextDouble();

			if (ans == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = scanner.nextDouble();

				TaxPayer taxPayer = new Individual(name, anualIncome, healthExpenditures);
				taxPayers.add(taxPayer);
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = scanner.nextInt();

				TaxPayer taxPayer = new Company(name, anualIncome, numberOfEmployees);
				taxPayers.add(taxPayer);
			}
		}

		System.out.println("Taxes paid:");

		double sum = 0;
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer);
			sum += taxPayer.tax();
		}

		System.out.println("Total taxes: $" + sum);

		scanner.close();
	}
}
