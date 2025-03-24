package Veterinaria.domain.models;

public class invoice {
	
	private long invoiceID;
	private Pet pet;
	private Person owner;
	private Order order;
	private String medicine;
	private int price;
	private long amount;
	private String date;
	public long getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}//cambio 
