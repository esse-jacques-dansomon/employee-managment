package co.essejacques.services;

import co.essejacques.entities.Service;
import co.essejacques.repository.interfaces.IServiceRepository;

import co.essejacques.repository.list.ServiceRepository;

import java.util.List;


public class ServiceService  {
    private final IServiceRepository serviceRepository = new ServiceRepository();
    public void createService(Service service) {
        serviceRepository.save(service);
    }

    public void update(Service service) {
       serviceRepository.update(service);
    }

    public Service findById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}