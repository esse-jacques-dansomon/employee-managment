package co.essejacques.repository.list;

import co.essejacques.entities.Service;
import co.essejacques.repository.interfaces.IServiceRepository;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private final List<Service> services = new ArrayList<>();

    @Override
    public Service save(Service service) {
        services.add(service);
        return service;
    }

    @Override
    public Service update(Service service) {
        // Logic to update service if needed
        return service;
    }

    @Override
    public List<Service> findAll() {
        return services;
    }

    @Override
    public Service findById(Long id) {
        return services.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}