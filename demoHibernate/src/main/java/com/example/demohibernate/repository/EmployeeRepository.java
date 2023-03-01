package com.example.demohibernate.repository;

import com.example.demohibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

//    Phương thức để truy vấn tất cả DL
    public List<Employee> findAll() {
        String query = "SELECT e FROM Employee AS e";
        TypedQuery<Employee> strQuery = entityManager.createQuery(query, Employee.class);
//        Phương thức getResultList() trả về một danh sách từ truy vấn
        return strQuery.getResultList();
    }

//    Phương thức để truy vấn DL với Đk where
    public Employee findById(Long id) {
        String query = "SELECT e FROM Employee AS e WHERE e.id = :id";
        TypedQuery<Employee> strQuery = entityManager.createQuery(query, Employee.class);
        strQuery.setParameter("id", id);
//        Phương thức getSingResult() trả về một kết quả duy nhất từ truy vấn
        return strQuery.getSingleResult();
    }

//    Phương thức tạo mới một đối tượng vào DB
    public void create(Employee employee) {
//        Tạo đối tượng Session mới và mở phiên làm việc với CSDL
        Session session = sessionFactory.openSession();
//        Bắt đầu giao dịch bằng phương thức beginTransaction()
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
//        Kết thúc giao dịch và lưu các thay đổi vào CSDL bằng phương thức commit()
        transaction.commit();
//        Đóng phiên làm việc với CSDL
        session.close();
    }

//    Phương thức cập nhật dữ liệu
    public void update(Employee employee) {
//        Mở phiên lm việc với CSDL
        Session session = sessionFactory.openSession();
//        Bắt đầu giao dịch
        Transaction transaction = session.beginTransaction();
        session.merge(employee);
//        Kết thúc giao dịch và lưu các thay đổi vào CSDl
        transaction.commit();
//        Đóng phiên làm việc
        session.close();
    }

    public void delete(Long id) {
        Employee employee = findById(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(employee);
        transaction.commit();
        session.close();
    }
}
