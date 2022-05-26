package com.codeclan.example.courseBooking.components;

import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepo customerRepo;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("Bob", "Edinburgh", 50);
        customerRepo.save(customer1);
    }
}
