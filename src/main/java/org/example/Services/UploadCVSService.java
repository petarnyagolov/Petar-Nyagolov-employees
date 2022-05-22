package org.example.Services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Date: 22.5.2022 г. Time: 11:31
 * <p>
 *  TODO: WRITE THE DESCRIPTION HERE
 *
 * @author petar
 */
@Service
public class UploadCVSService
{

  public List<Employee> getWhoWorkedLongestPerProject(MultipartFile file) throws IOException
  {
    Reader reader = new InputStreamReader(file.getInputStream());
    CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
    List<String[]> r = csvReader.readAll();
    List<Employee> employees = new ArrayList<>();
    List<Employee> employeesResult = new ArrayList<>();
    long currentMaxDays = 0;
    Employee maxFirst = new Employee();
    Employee maxSecond = new Employee();
    for (int i = 0; i < r.size(); i++) {
      employees.add(new Employee(r.get(i)[0]
          , r.get(i)[1]
          , tryParse(r.get(i)[2])
          , "".equals(r.get(i)[3]) ? LocalDate.now() : tryParse(r.get(i)[3])));
    }
    for (int i = 0; i < employees.size(); i++) {
      for (int j = 0; j < employees.size(); j++) {
        if (i != j && employees.get(i).getProjectID().equals(employees.get(j).getProjectID())) {
          LocalDate dateBefore = LocalDate.MIN;
          LocalDate dateAfter = LocalDate.MAX;
          if (employees.get(i).getDateFrom().isAfter(employees.get(j).getDateFrom()) && employees.get(i).getDateFrom().isBefore(employees.get(j).getDateTo())) {
            dateBefore = employees.get(i).getDateFrom();
            if (employees.get(i).getDateTo().isBefore(employees.get(j).getDateTo())) {
              dateAfter = employees.get(i).getDateTo();

            }
            else {
              dateAfter = employees.get(j).getDateTo();
            }
          }
          if (employees.get(j).getDateFrom().isAfter(employees.get(i).getDateFrom()) && employees.get(j).getDateFrom().isBefore(employees.get(i).getDateTo())) {
            dateBefore = employees.get(j).getDateFrom();
            if (employees.get(i).getDateTo().isBefore(employees.get(j).getDateTo())) {
              dateAfter = employees.get(i).getDateTo();
            }
            else {
              dateAfter = employees.get(j).getDateTo();
            }
          }

          long daysBetween = DAYS.between(dateBefore, dateAfter);
          if (daysBetween > currentMaxDays) {
            maxFirst = employees.get(i);
            maxSecond = employees.get(j);
            currentMaxDays = daysBetween;
          }


        }
      }
    }
    employeesResult.add(maxFirst);
    employeesResult.add(maxSecond);
    return employeesResult;
  }

  LocalDate tryParse(String dateString)
  {
    List<String> formatStrings = Arrays.asList("M/y", "M/d/y", "M-d-y", "YYYY-MM-DD", "yyyy-mm-dd");
    try {


      for (String formatString : formatStrings) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(formatString));
      }
    }
    finally {
      return LocalDate.now();
    }


  }
}
