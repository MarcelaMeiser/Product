package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int p = sc.nextInt();
		
		for(int i = 1; i <= p; i++) {
			System.out.printf("\nProduct #%d data:\n", i);
			System.out.print("Commom, used or imported (c/u/i): ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Customs fee:");
				Double fee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, fee);
				products.add(product);
				
			}
			else if (type == 'u') {
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.print("Manufacture date (dd/mm/yyyy): ");
				String date = sc.next();
				Product product = new UsedProduct(name, price, LocalDate.parse(date, fmt));
				products.add(product);
				
			}
			else {
				Product product = new Product(name, price);
				products.add(product);
			}
		}
		
		System.out.println("\nPRICE TAGS:\n");
		
		for (Product pro: products) {
			pro.showInformation(products);
			break;
		}
		
		sc.close();
	}

}
