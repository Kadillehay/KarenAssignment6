package teslaSales;

import java.time.YearMonth;
public class Cars {
//	replace 4 and 5 w/ yearMonth 
	private String month;
	private int year;
	private int sales;
	private String model;
	private String monthAbb;
	private YearMonth yearMonth;
	
	
	public Cars (int sales, String model, YearMonth YearMonth) {
		this.month = YearMonth.getMonth().name();
		this.year = YearMonth.getYear();
		this.sales = sales;
		this.model = model;
		this.monthAbb = monthAbb !=null ? monthAbb : "";
		this.yearMonth = YearMonth;
		
		
		
	}
	
	
	
	



	@Override
	public String toString() {
		return "Cars [month=" + month + ", year=" + year + ", sales=" + sales + ", model=" + model + ", monthAbb="
				+ monthAbb + ", yearMonth=" + yearMonth + "]";
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
	public YearMonth yearMonth() {
		return yearMonth;
	}
	public void setYearMonth (YearMonth YearMonth) {
		this.yearMonth = YearMonth;
	}
	
	}
	
