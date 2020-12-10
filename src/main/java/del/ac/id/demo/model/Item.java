package del.ac.id.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_item")
public class Item {
	
	@Id
	private String id_item;
	
	private String id_cat, item_name;
	
	private int stock;
	
	private Double price;

	public Item(String id_item, String id_cat, String item_name, int stock, Double price) {
//		super();
		this.id_item = id_item;
		this.id_cat = id_cat;
		this.item_name = item_name;
		this.stock = stock;
		this.price = price;
	}

	public Item() {
//		super();
	}

	public String getId_item() {
		return id_item;
	}

	public void setId_item(String id_item) {
		this.id_item = id_item;
	}

	public String getId_cat() {
		return id_cat;
	}

	public void setId_cat(String id_cat) {
		this.id_cat = id_cat;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
