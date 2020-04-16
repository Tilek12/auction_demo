package kg.megacom.auction_demo.serviceTest;

import kg.megacom.auction_demo.database.CustomerRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.CustomerDto;
import kg.megacom.auction_demo.model.entity.Customer;
import kg.megacom.auction_demo.service.CustomerService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    private Customer customer;
    private CustomerDto customerDto;

    @Before
    public void init(){
        CustomerDto customerDto = new CustomerDto(){
            {
                setId(1l);
                setPhone("phone");
            }
        };

        customer = ClassMapper.INSTANCE.customerDtoToCustomer(customerDto);

        Mockito.when(customerRepository.save(any()))
                    .thenReturn(customer);

    }

    @Test
    public void testCustomerSave(){
        customerDto = customerService.saveCustomer(customerDto);

        assertEquals(customerDto.getId(), customer.getId());
        assertEquals(customerDto.getPhone(), customer.getPhone());

    }
}
