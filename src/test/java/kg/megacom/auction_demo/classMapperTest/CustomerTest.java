package kg.megacom.auction_demo.classMapperTest;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.CustomerDto;
import kg.megacom.auction_demo.model.entity.Customer;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    @Test
    public void testCustomerDtoToCustomer(){

        CustomerDto actual = new CustomerDto(){
            {
                setId(1l);
                setPhone("phone");
            }
        };

        Customer customer = ClassMapper.INSTANCE.customerDtoToCustomer(actual);
        CustomerDto found = ClassMapper.INSTANCE.customerToCustomerDto(customer);

        assertEquals(actual.getId(), found.getId());
        assertEquals(actual.getPhone(), found.getPhone());
    }
}
