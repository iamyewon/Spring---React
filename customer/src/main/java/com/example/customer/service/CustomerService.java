package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {
    // interface => 본체 x = {} x  :  통일성을 위해

    // 전체 가져오기
    public ArrayList<Customer> getCustomers();

    // 저장하기 (저장은 한명씩 되고, 저장하고 화면에 띄워줄거면 void가 아님)
    public Customer saveCustomer(Customer customer);

    // 한명 가져오기 : true => boolean
    public boolean getCustomerOne(Long customerID);

    // 삭제하기
    public boolean deleteCustomer(Long customerID);

    // 수정하기
    public boolean updateCustomer(Customer customer, Long customerID);

}
