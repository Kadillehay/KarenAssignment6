package teslaSales;

import java.io.IOException;
import java.util.List;

public class TeslaApplication {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();


		System.out.println("Model X yearly sales report: ");
		System.out.println("-----------------------------");
		
		
		 List<Cars> salesDataListModelX= fileService.readCars("modelX.csv", "modelX");
		fileService.salesForYear(salesDataListModelX);
		System.out.println("   ");
		
		System.out.println("Best sales year for Model X: " + fileService.carBestYear(salesDataListModelX));
		System.out.println("Worst sales year for Model X: " + fileService.carWorstYear(salesDataListModelX));
		System.out.println("Best sales Month for Model X: " + fileService.bestMonth(salesDataListModelX));
		System.out.println("Worst sales Month for Model X: " + fileService.worstMonth(salesDataListModelX));
		System.out.println("   ");
		System.out.println("Model S yearly sales report: ");
		System.out.println("-----------------------------");
		

		 List<Cars> salesDataListModelS= fileService.readCars("modelS.csv", "modelS");
			fileService.salesForYear(salesDataListModelS);
			System.out.println("   ");
			System.out.println("Best sales year for Model S: " + fileService.carBestYear(salesDataListModelS));
			System.out.println("Worst sales year for Model S: " + fileService.carWorstYear(salesDataListModelS));
			System.out.println("Best sales Month for Model S: " + fileService.bestMonth(salesDataListModelS));
			System.out.println("Worst sales Month for Model S: " + fileService.worstMonth(salesDataListModelS));
			System.out.println("   ");
			System.out.println("Model 3 yearly sales report: ");
			System.out.println("-----------------------------");
			
			
		 List<Cars> salesDataListModel3= fileService.readCars("model3.csv", "model3");
				fileService.salesForYear(salesDataListModel3);
				System.out.println("   ");
				System.out.println("Best sales year for Model 3: " + fileService.carBestYear(salesDataListModel3));
				System.out.println("Worst sales year for Model 3: " + fileService.carWorstYear(salesDataListModel3));
				System.out.println("Best sales Month for Model 3: " + fileService.bestMonth(salesDataListModel3));
				System.out.println("Worst sales Month for Model 3: " + fileService.worstMonth(salesDataListModel3));
				
				
	}
	

}

