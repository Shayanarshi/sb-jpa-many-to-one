package in.ashokit.runner;

import in.ashokit.model.Customer;
import in.ashokit.model.Order;
import in.ashokit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    OrderRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        saveOrder();
//      fetchOrder();

     deleteOrder();

    }

    private  void deleteOrder(){

        repository.deleteById(32689L);

    }
    private void fetchOrder(){
        Order orderFromDB = repository.findById(77011L).get();
        System.out.println("Order Date :" + orderFromDB.getOrderDate());
        System.out.println("Order Id : "+orderFromDB.getId());
        System.out.println("Order Status : "+ orderFromDB.getStatus());
    }

    private void saveOrder(){
        Order order1 = new Order();
        order1.setId(77011L);
        order1.setOrderDate(LocalDate.of(2026,9,25));
        order1.setStatus("Delivered");


        Order order2 = new Order();
        order2.setId(32689L);
        order2.setOrderDate(LocalDate.of(2026,9,26));
        order2.setStatus("Placed");


        Customer customer = new Customer(1111L,"Shayan");
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        repository.save(order1);
        System.out.println("************************");

        repository.save(order2);

    }

}
