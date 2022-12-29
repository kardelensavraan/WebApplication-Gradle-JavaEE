package ejb;

import java.util.List;

public interface ProductBeanInterface {
    public List<Product> getdata();
    public void  addData(Product product);
}
