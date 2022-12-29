package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class combinedTableBean {

	public String generateTable(List<ShoppingCart> shoppingCartList, List<Product> productList,
			CostCalculator costCalculator) {
		String table = "<table>";
		table += "<tr>";
		table += "<th>Id</th>";
		table += "<th>ProductId</th>";
		table += "<th>Quantity</th>";
		table += "<th>CustomerId</th>";
		table += "<th>Name</th>";
		table += "<th>Price</th>";
		table += "<th>Cost</th>";

		table += "</tr>";
		for (ShoppingCart shoppingcart : shoppingCartList) {
			table += "<tr>";
			table += "<td>" + shoppingcart.getId() + "</td>";
			table += "<td>" + shoppingcart.getProductId() + "</td>";
			table += "<td>" + shoppingcart.getQuantity() + "</td>";
			table += "<td>" + shoppingcart.getCustomerId() + "</td>";
			for (Product product : productList) {
				if (shoppingcart.getProductId() == product.getId()) {
					table += "<td>" + product.getName() + "</td>";
					table += "<td>" + product.getPrice() + "</td>";
					double cost = costCalculator.calculateCost(shoppingcart.getQuantity(), product.getPrice());
					table += "<td>" + cost + "</td>";

					break;
				}
			}
			table += "</tr>";
		}
		table += "</table>";
		return table;
	}
}
