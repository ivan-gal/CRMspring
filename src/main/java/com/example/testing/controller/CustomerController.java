package com.example.testing.controller;

import com.example.testing.entity.Customer;
import com.example.testing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService costumerService;


    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //Solution 1
      /*  List<Customer> customerList = new ArrayList<Customer>();
        costumerService.getCustomers().forEach(customerList::add);
        Collections.sort(customerList);*/

        //Alternative solution creating anotherquery.

        theModel.addAttribute("customers", costumerService.getCustomerByLastName());

        return "list-customers";
    }

    @GetMapping("add")
    public String addCustomer(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "new-customer";
    }

    @PostMapping("/createCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        costumerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        Customer theCustomer = costumerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "new-customer";

    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        costumerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }




}
