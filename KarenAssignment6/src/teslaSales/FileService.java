package teslaSales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class FileService {

	public List<Cars> readCars(String filename, String model) throws IOException {
	    List<Cars> salesDataList = new ArrayList<>();

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);

	    Files.lines(Paths.get(filename)).skip(1).map(line -> line.split(",")).map(parts -> {
	        YearMonth yearMonth = YearMonth.parse(parts[0], formatter);
	        int sales = Integer.parseInt(parts[1]);

	        return new Cars(sales,model,yearMonth);
	    }).forEach(salesDataList::add);

	    return salesDataList;
	}

	public void salesForYear(List<Cars> salesDataList) {
		Map<Integer, Integer> salesMap = salesDataList.stream()
				.collect(Collectors.groupingBy(Cars::getYear, Collectors.summingInt(Cars::getSales)));


		salesMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(entry -> System.out.printf("%d->%d\n", entry.getKey(), entry.getValue()));

	}

	public Map.Entry<Integer, Integer> carBestYear(List<Cars> salesDataList) {
		Map<Integer, Integer> salesMap = salesDataList.stream()
				.collect(Collectors.groupingBy(Cars::getYear, Collectors.summingInt(Cars::getSales)));
		;

		return Collections.max(salesMap.entrySet(), Map.Entry.comparingByValue());

	}

	public Map.Entry<Integer, Integer> carWorstYear(List<Cars> salesDataList) {
		Map<Integer, Integer> salesMap = salesDataList.stream()
				.collect(Collectors.groupingBy(Cars::getYear, Collectors.summingInt(Cars::getSales)));
		;

		return Collections.min(salesMap.entrySet(), Map.Entry.comparingByValue());

	}
	public YearMonth worstMonth(List<Cars> salesDataList) {
	    Map<YearMonth, Integer> salesMap = salesDataList.stream()
	        .filter(car -> car.yearMonth() != null)
	        .collect(Collectors.groupingBy(
	            Cars::yearMonth,
	            Collectors.summingInt(Cars::getSales)
	        ));
	    Optional<Map.Entry<YearMonth, Integer>> minEntry = salesMap.entrySet().stream()
	        .min(Map.Entry.comparingByValue());
	    return minEntry.map(Map.Entry::getKey).orElse(null);
	}
	public YearMonth bestMonth(List<Cars> salesDataList) {
	    Map<YearMonth, Integer> salesMap = salesDataList.stream()
	        .filter(car -> car.yearMonth() != null)
	        .collect(Collectors.groupingBy(
	            Cars::yearMonth,
	            Collectors.summingInt(Cars::getSales)
	        ));
	    Optional<Map.Entry<YearMonth, Integer>> maxEntry = salesMap.entrySet().stream()
	        .max(Map.Entry.comparingByValue());
	    return maxEntry.map(Map.Entry::getKey).orElse(null);
	}
}
	
   





