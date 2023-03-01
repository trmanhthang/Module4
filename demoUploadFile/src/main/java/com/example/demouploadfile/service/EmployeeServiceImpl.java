package com.example.demouploadfile.service;

import com.example.demouploadfile.model.Brand;
import com.example.demouploadfile.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements ICrudService<Employee> {
    private final List<Employee> employeeList;
    private BrandServiceImpl brandService;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Thắng", "0329479090", new Brand("C10")));
        employeeList.add(new Employee("Thắng", "0329479090", new Brand("C08")));
        employeeList.add(new Employee("Thắng", "0329479090", new Brand("C08")));
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        for (Employee e : employeeList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(employeeList.get(employeeList.size() - 1).getId() + 1);
            employeeList.add(employee);
        } else {
            Employee employeeUpdate = findById(employee.getId());
            if (employeeUpdate != null) {
                employeeUpdate.setName(employee.getName());
                employeeUpdate.setContactNumber(employee.getContactNumber());
                employeeUpdate.setBrand(employee.getBrand());
            }
        }
    }


    @Override
    public void delete(Employee employee) {
        employeeList.remove(employee);
    }
}
