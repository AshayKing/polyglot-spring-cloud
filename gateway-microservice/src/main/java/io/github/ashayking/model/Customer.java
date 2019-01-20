package io.github.ashayking.model;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Ashay S Patil
 *
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

	private UUID customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Date createDate;

	public Customer(UUID customerId, String firstName, String lastName, String password, Date createDate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createDate = (createDate != null) ? createDate : new Date();
	}
}
