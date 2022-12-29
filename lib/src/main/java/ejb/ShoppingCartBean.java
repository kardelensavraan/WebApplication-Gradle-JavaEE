package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ShoppingCartBean implements ShoppingCartBeanInterface {

	public List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();

	@Override
	public List<ShoppingCart> getdata() {
		return shoppingCart;
	}

	@Override
	public void addData(ShoppingCart shoppingcart) {
		this.shoppingCart.add(shoppingcart);

	}

}
