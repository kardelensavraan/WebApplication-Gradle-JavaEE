package ejb;

public class ShoppingCart {
	private int id;
	private int CustomerId;
	private int productId;
	private int Quantity;

	public ShoppingCart(int id, int productId, int Quantity, int CustomerId) {
		this.id = id;
		this.productId = productId;
		this.Quantity = Quantity;
		this.CustomerId = CustomerId;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

}
