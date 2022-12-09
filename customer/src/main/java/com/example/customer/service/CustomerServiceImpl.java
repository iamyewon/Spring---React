package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired // service에서는 repository(save, findAll..등) 를 당겨와서 써야함
    CustomerRepository customerRepository;

    // 타입이 부모가 아니면 명시적 형변환을 해야함.
    // 그래서 보통 그냥 List로 사용
    @Override
    public ArrayList<Customer> getCustomers() {
        return (ArrayList<Customer>)customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean getCustomerOne(Long customerID) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Long customerID) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer, Long customerID) {
        return false;
    }
}
