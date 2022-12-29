package com.kardelen.ervletexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.CostCalculator;
import ejb.Product;
import ejb.ProductBean;
import ejb.ShoppingCart;
import ejb.ShoppingCartBean;
import ejb.combinedTableBean;

@WebServlet("/HelloServlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ProductBean productbean;
	@EJB
	private ShoppingCartBean shoppingcartbean;
	@EJB
	private combinedTableBean combinedBean;
	@EJB
	private CostCalculator costCalculator;

	public Servlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Kardelen");

		Product product1 = new Product(10, "Apple", 500);
		Product product2 = new Product(11, "Sony", 100);

		productbean.addData(product1);
		productbean.addData(product2);

		ShoppingCart shoppingcart1 = new ShoppingCart(1, 10, 5, 123);
		ShoppingCart shoppingcart2 = new ShoppingCart(2, 11, 3, 123);
		ShoppingCart shoppingcart3 = new ShoppingCart(3, 12, 4, 123);

		shoppingcartbean.addData(shoppingcart1);
		shoppingcartbean.addData(shoppingcart2);
		shoppingcartbean.addData(shoppingcart3);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		List<Product> productList = productbean.getdata();
		List<ShoppingCart> shoppingCartList = shoppingcartbean.getdata();
		String table = combinedBean.generateTable(shoppingCartList, productList, costCalculator);

		// out.println(
		// "<table><tr><th>Id</th><th>ProductId</th><th><th>Quantity</th><th>CustomerId</th><th>Name</th><th>Price</th></tr>");
		out.println(table);
	}
}

