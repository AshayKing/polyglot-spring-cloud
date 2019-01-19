package io.github.ashayking.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import io.github.ashayking.model.Customer;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Repository
public interface CustomerRepository extends CassandraRepository<Customer, UUID> {

	Customer findByEmail(String email);

}