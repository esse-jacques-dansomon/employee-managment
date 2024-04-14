package co.essejacques.entities;

import lombok.Data;


@Data
public class ServiceProviderEmployee extends Employee {
    private String servicePeriod;
    private double serviceCost;



    public ServiceProviderEmployee(String matricule, String servicePeriod, double serviceCost) {
        super(matricule);
        this.servicePeriod = servicePeriod;
        this.serviceCost = serviceCost;
    }

    @Override
    public double calculerSalaire() {
        return serviceCost;
    }
}