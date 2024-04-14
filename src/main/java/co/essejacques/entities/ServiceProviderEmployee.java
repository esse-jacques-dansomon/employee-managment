package co.essejacques.entities;

import lombok.Data;


@Data
public class ServiceProviderEmployee extends Employee {
    private String servicePeriod;
    private double serviceCost;


    public double calculerSalaireNet() {
        return serviceCost;
    }

    public ServiceProviderEmployee(String matricule, String servicePeriod, double serviceCost) {
        super(matricule);
        this.servicePeriod = servicePeriod;
        this.serviceCost = serviceCost;
    }
}