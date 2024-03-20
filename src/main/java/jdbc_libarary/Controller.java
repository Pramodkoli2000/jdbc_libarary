package jdbc_libarary;

import java.sql.ResultSet;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		User user = new User();
		Book book = new Book();
		CRUD crud = new CRUD();

		System.out.println("WELCOME.....\n Enter the choice:\n 1.SignUp\n 2.LogIn\n 3.Exit");
		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Welcome to SignUp!!!!!");
			System.out.println("Enter id:");
			int id = sc.nextInt();
			System.out.println("Enter Name:");
			String name = sc.next();
			System.out.println("Enter Phone:");
			long phone = sc.nextLong();
			System.out.println("Enter Email:");
			String email = sc.next();
			System.out.println("Enter Password:");
			String password = sc.next();

			user.setEmail(email);
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setPhone(phone);

			int res = crud.signUp(user);
			if (res != 0) {
				System.out.print("SignUp Successfully....");
			} else {
				System.out.println("Plz enter data correctly...");
			}
		}
			break;

		case 2: {
			System.out.println("Welcome to LogIn...");
			System.out.println("Enter Email:");
			String email = sc.next();
			System.out.println("Enter Password:");
			String password = sc.next();

			user.setEmail(email);
			user.setPassword(password);
			ResultSet res = crud.logIn(user, email, password);
			if (res.next()) {
				if (password.equals(res.getString("password"))) {
					System.out.println("Login Sucessfully...");
					System.out.println(
							"Enter the choice:\n 1.Get All Books\n 2.Add Book\n 3.Delete Book\n 4.Update Book\n 5.Get Book By Id\n 6.Get Book By Name\n 7.Get Book By Author\n 8.Get Book By Genre\n 9.Update User Details\n 10.Logout ");
					int choice1 = sc.nextInt();

					switch (choice1) {
					case 1: {
						System.out.println("Get Name of All Book");
						ResultSet set = crud.getAll();
						while (set.next()) {
							System.out.println(set.getString("name"));

						}

					}
						break;

					case 2: {
						System.out.println("Add Book Details");
						System.out.println("Enter the id:");
						int id = sc.nextInt();
						System.out.println("Enter the Name of the Book:");
						String name = sc.next();
						System.out.println("Enter the Author of th Book:");
						String author = sc.next();
						System.out.println("Enter the Price of the Book:");
						double price = sc.nextDouble();
						System.out.println("Enter the Genre:");
						String genre = sc.next();
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setPrice(price);
						book.setGenre(genre);

						int set = crud.addBook(book);
						if (set != 0) {
							System.out.println("Inserted successfully...");
						} else {
							System.out.println("Not Inserted...");
						}

					}
						break;

					case 3: {
						System.out.println("Delete the Book Details by Id:");
						System.out.println("Enter the Id:");
						int id = sc.nextInt();
						int res1 = crud.deleteBook(id);
						if (res1 != 0) {
							System.out.println("Deleted successfully...");
						} else {
							System.out.println("Not Deleted...");
						}

					}
						break;

					case 4: {
						System.out.println("Update the Details of the Book");
						System.out.println("Enter the Id to update the Book Details:");
						int id = sc.nextInt();
						System.out.println("Enter the Name of the Book:");
						String name = sc.next();
						System.out.println("Enter the Author of th Book:");
						String author = sc.next();
						System.out.println("Enter the Price of the Book:");
						double price = sc.nextDouble();
						System.out.println("Enter the Genre:");
						String genre = sc.next();
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setPrice(price);
						book.setGenre(genre);

						int res2 = crud.updateBook(book);
						if (res2 != 0) {
							System.out.println("Updated successfully...");
						} else {
							System.out.println("Not Updated...");
						}

					}
						break;

					case 5: {
						System.out.println("Get the Book Name  By Id:");
						System.out.println("Enter the Id to get book Details:");
						int id = sc.nextInt();
						ResultSet resultset1 = crud.bookNameById(id);
						if (resultset1.next()) {
							System.out.println(resultset1.getString("name"));
						}

					}
						break;

					case 6: {
						System.out.println("Get the Book Name By Name:");
						System.out.println("Enter the Name of the book to get book Details:");
						String name = sc.next();
						ResultSet resultset1 = crud.bookNameByName(name);
						if (resultset1.next()) {
							System.out.println(resultset1.getString("name"));
							System.out.println(resultset1.getString("author"));
							System.out.println(resultset1.getString("price"));
							System.out.println(resultset1.getString("genre"));
							System.out.println(resultset1.getString("id"));
						}

					}
						break;

					case 7: {
						System.out.println("Get the Book Name By Author:");
						System.out.println("Enter the Author of the book to get book Details:");
						String author = sc.next();
						ResultSet resultset1 = crud.bookNameByAuthor(author);
						while (resultset1.next()) {
							System.out.println(resultset1.getString("id"));
							System.out.println(resultset1.getString("name"));
							System.out.println(resultset1.getString("author"));
							System.out.println(resultset1.getString("genre"));
							System.out.println(resultset1.getString("price"));
							System.out.println("---------------------------------");

						}

					}
						break;

					case 8: {
						System.out.println("Get the Book Name By Genre:");
						System.out.println("Enter the Genre of the book to get book Details:");
						String genre = sc.next();
						ResultSet resultset1 = crud.bookNameByGenre(genre);
						while (resultset1.next()) {
							System.out.println(resultset1.getString("id"));
							System.out.println(resultset1.getString("name"));
							System.out.println(resultset1.getString("author"));
							System.out.println(resultset1.getString("genre"));
							System.out.println(resultset1.getString("price"));
							System.out.println("---------------------------------");
						}

					}
						break;

					case 9: {
						System.out.println("Get the User details to get updated:");
						System.out.println("Enter the id of the user to get updated:");
						int id = sc.nextInt();
						System.out.println("Enter the Name of the user to get updated:");
						String name = sc.next();
						System.out.println("Enter the Phone of the user to get updated:");
						long phone = sc.nextLong();
						System.out.println("Enter the Email of the user to get updated:");
						String email1 = sc.next();
						System.out.println("Enter the Password of the user to get updated:");
						String password1 = sc.next();
						user.setId(id);
						user.setName(name);
						user.setPhone(phone);
						user.setEmail(email1);
						user.setPassword(password1);

						ResultSet resultset1 = crud.updateUser(user);
						if (resultset1.next()) {
							System.out.println("Updated Successfully....");
						} else {
							System.out.println("Not Updated");
						}

					}
						break;

					case 10: {
						System.out.println("Logout Successfully...");

					}
						break;

					}

				} else {
					System.out.println("Invalid Password");
				}
			} else {
				System.out.println("User not register");
			}
		}
			break;

		default:
			System.out.println("Exit Sucessfully...");
			break;
		}

	}

}