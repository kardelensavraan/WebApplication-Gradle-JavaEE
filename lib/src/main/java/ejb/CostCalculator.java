package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class CostCalculator {
	public double calculateCost(int quantity, double price) {
		return quantity * price;
	}

}
