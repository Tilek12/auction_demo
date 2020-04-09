package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.CustomerRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.CustomerDto;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        Customer customer = ClassMapper.INSTANCE.customerDtoToCustomer(customerDto);
        customer = customerRepository.save(customer);
        customerDto = ClassMapper.INSTANCE.customerToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
