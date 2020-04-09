package kg.megacom.auction_demo.controller;

import kg.megacom.auction_demo.model.dto.CustomerDto;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/save")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping(value = "/getAllCustomres")
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }
}
