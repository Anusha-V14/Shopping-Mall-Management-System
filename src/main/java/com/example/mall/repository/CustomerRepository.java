/*package com.example.mall.repository;

//import com.example.mall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mall.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

*/

package com.example.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mall.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
