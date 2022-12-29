package ejb;

import java.util.List;

public interface ShoppingCartBeanInterface {
    public List<ShoppingCart> getdata();
    public void  addData(ShoppingCart shoppingcart);
}
