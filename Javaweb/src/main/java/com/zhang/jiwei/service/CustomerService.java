package com.zhang.jiwei.service;

import java.util.List;
import java.util.Map;

import com.zhang.jiwei.entity.Customer;
import com.zhang.jiwei.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        List<Customer> customerList = cs.getCustomerList();
        System.out.println(customerList.size());
        System.out.println(customerList.get(0).getEmail());
    }

    public List<Customer> getCustomerList() {
        String sql = "select * from ceshi3";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(int id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(int id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
