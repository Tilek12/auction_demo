package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.CustomerDto;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        Customer customer = ClassMapper.INSTANCE.customerDtoToCustomer(customerDto);
        customerDto = ClassMapper.INSTANCE.customerToCustomerDto(customer);
        return customerDto;
    }
}
