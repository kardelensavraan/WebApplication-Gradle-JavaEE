package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ProductBean implements ProductBeanInterface {
	public List<Product> productList = new ArrayList<Product>();
	

	@Override
	public List<Product> getdata() {
		return productList;
	}

	@Override
	public void addData(Product product) {
		this.productList.add(product);

	}

}
