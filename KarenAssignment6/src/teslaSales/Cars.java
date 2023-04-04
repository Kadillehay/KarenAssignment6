package teslaSales;

public class Cars {
//	replace 4 and 5 w/ yearMonth 
	private String month;
	private int year;
	private int sales;
	private String model;
	private String monthAbb;
	private String yearMonth;
	
	
	public Cars (int year, String month, int sales, String model, String monthAbb, String yearMonth) {
		this.month = month;
		this.year = year;
		this.sales = sales;
		this.model = model;
		this.monthAbb = monthAbb !=null ? monthAbb : "";
		
		
		
	}
	
	@Override
	public String toString() {
		return "Cars [year=" + year + ", month=" + month + ", sales=" + sales + ",model=" + model + "]";
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMonthAbb() {
		return monthAbb.toUpperCase();
	}
	public String yearMonth() {
		return yearMonth;
	}
	}
	
