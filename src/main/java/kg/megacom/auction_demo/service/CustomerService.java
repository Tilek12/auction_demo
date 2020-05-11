package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    List<CustomerDto> findAllCustomers();
}
