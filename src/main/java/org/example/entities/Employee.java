package org.example.entities;

import java.time.LocalDate;

/**
 * Date: 22.5.2022 г. Time: 11:35
 * <p>
 *  TODO: WRITE THE DESCRIPTION HERE
 *
 * @author petar
 */
public class Employee
{
  private String    empID;
  private String    ProjectID;
  private LocalDate DateFrom;
  private LocalDate DateTo;

  public Employee()
  {
  }

  public Employee(String empID, String projectID, LocalDate dateFrom, LocalDate dateTo)
  {
    this.empID = empID;
    ProjectID = projectID;
    DateFrom = dateFrom;
    DateTo = dateTo;
  }

  public String getEmpID()
  {
    return empID;
  }

  public void setEmpID(String empID)
  {
    this.empID = empID;
  }

  public String getProjectID()
  {
    return ProjectID;
  }

  public void setProjectID(String projectID)
  {
    ProjectID = projectID;
  }

  public LocalDate getDateFrom()
  {
    return DateFrom;
  }

  public void setDateFrom(LocalDate dateFrom)
  {
    DateFrom = dateFrom;
  }

  public LocalDate getDateTo()
  {
    return DateTo;
  }

  public void setDateTo(LocalDate dateTo)
  {
    DateTo = dateTo;
  }
}
