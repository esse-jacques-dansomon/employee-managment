package co.essejacques.entities;

import lombok.Data;

@Data
public class ContractEmployee extends Employee {
    private double salaryBrut;
    private double prime;
    private double retenue;
    private Service service;

    public ContractEmployee(String matricule, double salaryBrut, double prime, double retenue, Service service) {
        super(matricule);
        this.salaryBrut = salaryBrut;
        this.prime = prime;
        this.retenue = retenue;
        this.service = service;
    }


    @Override
    public double calculerSalaire() {
        return salaryBrut + prime - retenue;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "salaryBrut=" + salaryBrut +
                ", prime=" + prime +
                ", retenue=" + retenue +
                ", service=" + service +
                ", id=" + id +
                ", matricule='" + matricule + '\'' +
                ", status=" + status +
                ", onLeaveOffDays=" + onLeaveOffDays +
                '}';
    }
}