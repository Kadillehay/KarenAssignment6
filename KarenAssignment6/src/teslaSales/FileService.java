package teslaSales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.time.YearMonth;
import java.util.Map;
import java.util.stream.Collectors;


public class FileService {

	public List<Cars> readCars(String filename, String model) throws IOException {
		List<Cars> salesDataList = new ArrayList<>();

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMM");

		Files.lines(Paths.get(filename)).skip(1).map(line -> line.split(",")).map(parts -> {
			String[] dateParts = parts[0].split("-");
			int year = Integer.parseInt("20" + dateParts[1]);
			String monthAbb = dateParts[0];

			int sales = Integer.parseInt(parts[1]);

			return new Cars(year, monthAbb, sales, model ,monthAbb);
		}).forEach(salesDataList::add);

		return salesDataList;

	}

	public void salesForYear(List<Cars> salesDataList) {
		Map<Integer, Integer> salesMap = salesDataList.stream()
				.collect(Collectors.groupingBy(Cars::getYear, Collectors.summingInt(Cars::getSales)));

//		System.out.println("Yearly Sales");
//		System.out.println("--------------------");

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
	    DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMM");
	    Map<YearMonth, Integer> salesMap = salesDataList.stream()
	        .filter(car -> car.getMonth() != null)
	        .collect(Collectors.groupingBy(
	            car -> YearMonth.of(car.getYear(), Month.parse(car.getMonth(), monthFormat)),
	            Collectors.summingInt(Cars::getSales)
	        ));
	    Optional<Map.Entry<YearMonth, Integer>> minEntry = salesMap.entrySet().stream()
	        .min(Comparator.comparingInt(Map.Entry::getValue));
	    return minEntry.map(Map.Entry::getKey).orElse(null);
	}
	}
	
	
   





