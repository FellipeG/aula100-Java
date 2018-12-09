package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("BirthDate (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		Order order = new Order(new Date(), status, new Client(name, email, birthDate));
		for(int i=1; i<=items; i++) {
			System.out.println("Enter #" + i + " item data");
			System.out.print("Product name: ");
			sc.nextLine();
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity, price, new Product(pName, price)));
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		sc.close();

	}

}
