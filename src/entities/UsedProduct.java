package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class UsedProduct extends Product{
	
	private LocalDate manufacturedDate;

	public UsedProduct(LocalDate manufacturedDate) {
		super();
		this.manufacturedDate = manufacturedDate;
	}

	public UsedProduct(String name, Double price, LocalDate manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	@Override
	public String priceTag() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return getName() + " (used) $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + fmt.format(getManufacturedDate()) + ")";
	}
	
}
