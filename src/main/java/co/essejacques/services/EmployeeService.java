package co.essejacques.services;

import co.essejacques.repository.interfaces.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
}