package com.example.demothymeleaf.service;

import com.example.demothymeleaf.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements ICrudService<Employee> {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1L,"Thắng", 20, 10000.0, "TN"));
        employeeList.add(new Employee(2L, "Thắng", 25, 20000.0, "TN"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public Employee findById(Long id) {
        for (Employee e : employeeList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }



    @Override
    public void add(Employee employee) {
        if (employee.getId() == null) {
            Long idMax = employeeList.get(0).getId();
            for (Employee e : employeeList) {
                if (e.getId() > idMax) {
                    idMax = e.getId();
                }
            }
            employeeList.add(new Employee(++idMax, employee.getName(), employee.getAge(), employee.getSalary(), employee.getAddress()));
        } else {
            for (Employee e : employeeList) {
                if (e.getId().equals(employee.getId())) {
                    employeeList.set(employeeList.indexOf(e), employee);
                }
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        employeeList.remove(findById(id));
    }

//    @Override
//    public Integer findByIndex(Long id) {
//        int index;
//        for (Employee e : employeeList) {
//            if (e.getId().equals(id)) {
//                index = employeeList.indexOf(e);
//                return index;
//            }
//        }
//        return null;
//    }
}
