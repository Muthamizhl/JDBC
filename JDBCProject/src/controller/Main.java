package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int choice, option;
		
		Login login =new Login();
		LoginDAO logindao =new LoginDAO();
		Product product= new Product();
		ProductDAO productdao= new ProductDAO();
		do {
			System.out.println("1.Adim");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("_________________________________________________");
			choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1: System.out.println("_________________________________________________");
			System.out.println("Enter the username");
			String username = br.readLine();
			System.out.println("Enter the password");
			String password = br.readLine();
			login.setUserName(username);
			login.setPassword(password);
			
			if(logindao.validate(login)) {
				System.out.println("_________________________________________________");
				System.out.println(" Login Successfull");
				
				do
				{
					System.out.println("_________________________________________________");
					System.out.println("1.Add product");
					System.out.println("2.Display Inventory Detail");
					System.out.println("3.Logout");
					System.out.println("_________________________________________________");
					option = Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Enter the product id:");
					int productId = Integer.parseInt(br.readLine());
					System.out.println("Enter the product Name:");
					String productname= br.readLine();
					System.out.println("Enter the min selling quantity:");
					int minsell= Integer.parseInt(br.readLine());
					System.out.println("Enter the product price:");
					int price= Integer.parseInt(br.readLine());
					System.out.println("Enter the product quantity:");
					int quantity= Integer.parseInt(br.readLine());
					product.setProductName(productname);
					product.setProductId(productId);
					product.setMinSellQuantity(minsell);
					product.setPrice(price);
					product.setQuantity(quantity);
					
					productdao.addProduct(product);
					break;
					
					case 2: productdao.display();
					break;
					
					case 3: break;			
								
			
					}					
				}while(option!=3);
				
			}
			
			else
			{
				System.out.println("_________________________________________________");
				System.out.println(" check your Username & Password");
				
			}
			break;
			
			case 2:System.out.println("_________________________________________________");
			System.out.println("Enter the username");
			String name = br.readLine();
			System.out.println("Enter the password");
			String pass = br.readLine();
			login.setUserName(name);
			login.setPassword(pass);
			if(logindao.validate(login))
			{
				System.out.println("_________________________________________________");
				System.out.println(" Login Successfull");
				do
				{
					System.out.println("_________________________________________________");
					System.out.println(" 1. show Inventory");
					System.out.println("2. Logout ");

					System.out.println("_________________________________________________");
					option= Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: productdao.display();
					break;
					
					case 2: break;
					
					}
				}while(option!=2);
				
			}
			
				
			}
		}while(choice!=3);
		

	}

}
