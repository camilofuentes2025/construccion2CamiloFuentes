package Veterinaria.adapters.rest.request;

import java.sql.Date;

import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;

public class OrderRequest {
	
	  private long orderID;
	    private Pet pet;
	    private Person owner;
	    private User veterinarian;
	    private String medicine;
	    private Date date;
		public long getOrderID() {
			return orderID;
		}
		public void setOrderID(long orderID) {
			this.orderID = orderID;
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
		public User getVeterinarian() {
			return veterinarian;
		}
		public void setVeterinarian(User veterinarian) {
			this.veterinarian = veterinarian;
		}
		public String getMedicine() {
			return medicine;
		}
		public void setMedicine(String medicine) {
			this.medicine = medicine;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "OrderRequest [orderID=" + orderID + ", pet=" + pet + ", owner=" + owner + ", veterinarian="
					+ veterinarian + ", medicine=" + medicine + ", date=" + date + "]";
		}
  

}
