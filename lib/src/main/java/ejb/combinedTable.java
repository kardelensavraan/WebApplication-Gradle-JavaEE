package ejb;

import java.io.PrintWriter;
import java.util.List;

public class combinedTable {

	public void generateTable(ShoppingCartBean shoppingcartbean, ProductBean productbean, PrintWriter out) {
		String table = "";
		for (ShoppingCart shoppingcart : shoppingcartbean.getdata()) {
			table += "<tr><td>" + shoppingcart.getId() + "</td><td>" + shoppingcart.getProductId() + "</td><td>"
					+ shoppingcart.getQuantity() + "</td><td>" + shoppingcart.getCustomerId();
			for (Product product : productbean.getdata()) {
				if (shoppingcart.getProductId() == product.getId()) {
					table += "<td>" + product.getName() + "</td><td>" + product.getPrice() + "</td></tr>";
					break;
				}
			}
		}
		out.println(table);

	}

}
