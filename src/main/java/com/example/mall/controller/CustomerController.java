


package com.example.mall.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.web.bind.annotation.*;
import com.example.mall.entity.Customer;
import com.example.mall.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")  // allows frontend (Angular/HTML) to access backend
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // POST → Add a new customer
    // Example: POST http://localhost:8080/api/customers
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // GET → Fetch a single customer by ID
    // Example: GET http://localhost:8080/api/customers/1
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    // PUT → Update existing customer
    // Example: PUT http://localhost:8080/api/customers/1
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    // DELETE → Remove a customer by ID
    // Example: DELETE http://localhost:8080/api/customers/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            customerService.delete(id);
            response.put("message", "Customer deleted successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Customer not found or could not be deleted!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    // GET → Fetch all customers
    // Example: GET http://localhost:8080/api/customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
