package com.zhang.jiwei.controller;

import java.util.List;

import javax.xml.ws.Action;

import com.zhang.jiwei.entity.Customer;
import com.zhang.jiwei.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Action(input = "get:/customer")
    public ModelAndView index(){
        List<Customer> customerList = customerService.getCustomerList();
        return new ModelAndView("/WEB-INF/view/customer.jsp").addObject("customerList",customerList);
    }
}
