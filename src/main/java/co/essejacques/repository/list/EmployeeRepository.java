package co.essejacques.repository.list;

import co.essejacques.entities.Employee;
import co.essejacques.repository.interfaces.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeToUpdate = findById(employee.getId());
        if (employeeToUpdate != null) {
            employeeToUpdate.setMatricule(employee.getMatricule());
            return employeeToUpdate;
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Employee findByMatricule(String matricule) {
        return employees.stream().filter(employee -> employee.getMatricule().equals(matricule)).findFirst().orElse(null);
    }

}