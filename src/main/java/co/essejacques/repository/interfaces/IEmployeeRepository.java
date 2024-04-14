package co.essejacques.repository.interfaces;

import co.essejacques.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee findByMatricule(String id);
    Employee save(Employee employee);
    Employee update(Employee employee);
}