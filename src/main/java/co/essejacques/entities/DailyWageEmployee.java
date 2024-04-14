package co.essejacques.entities;


import lombok.Data;



@Data
public class DailyWageEmployee extends Employee  {
    private double dailyCost;
    private int numberOfDaysWorked;
    private double salary;


    public DailyWageEmployee(String matricule, double dailyCost, int numberOfDaysWorked) {
        super(matricule);
        this.dailyCost = dailyCost;
        this.numberOfDaysWorked = numberOfDaysWorked;
        this.salary = calculerSalaire();
    }

    @Override
    public double calculerSalaire() {
        return dailyCost * numberOfDaysWorked;
    }

    @Override
    public String toString() {
        return "DailyWageEmployee{" +
                "dailyCost=" + dailyCost +
                ", numberOfDaysWorked=" + numberOfDaysWorked +
                ", salary=" + salary +
                ", id=" + id +
                ", matricule='" + matricule + '\'' +
                ", status=" + status +
                ", onLeaveOffDays=" + onLeaveOffDays +
                '}';
    }
}