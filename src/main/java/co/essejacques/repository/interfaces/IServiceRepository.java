package co.essejacques.repository.interfaces;

import co.essejacques.entities.Service;

import java.util.List;

public interface IServiceRepository {
    Service save (Service service);
    Service update (Service service);
    List<Service> findAll();

    Service findById(Long id);

}