package co.essejacques.services;

import co.essejacques.entities.Employee;
import co.essejacques.repository.interfaces.IEmployeeRepository;

import co.essejacques.repository.list.EmployeeRepository;
import co.essejacques.services.Transfert.Transfert;

import java.util.List;


public class EmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    public void takeLeave(Long employeeId, int days) {
        Employee employee = employeeRepository.findById(employeeId);
        employee.setOnLeaveOffDays(days);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void paySalary(int employeeId, double amount, Transfert tranfert) {
        Employee employee = employeeRepository.findById((long) employeeId);
        tranfert.process(employee, amount);
    }
}