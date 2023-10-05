package n1exercici1;

import java.util.List;
import java.util.ArrayList;

public class Month {

	private List<String> listMonths;

	public Month() {
		this.listMonths = new ArrayList<String>();
		addMonths();

	}

	public void addMonths() {
		this.listMonths.add("January");
		this.listMonths.add("February");
		this.listMonths.add("March");
		this.listMonths.add("April");
		this.listMonths.add("May");
		this.listMonths.add("June");
		this.listMonths.add("July");
		this.listMonths.add("August");
		this.listMonths.add("September");
		this.listMonths.add("October");
		this.listMonths.add("November");
		this.listMonths.add("December");
	}

	public int getSizeList() {
		return this.listMonths.size();
	}

	public List<String> getList() {
		return this.listMonths;
	}

	public void showList() {
		for (String m : this.listMonths) {
			System.out.println(m);
		}
		System.out.println("\n");
	}

}
