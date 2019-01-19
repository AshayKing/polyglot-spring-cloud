package io.github.ashayking.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

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
@Table("customer")
public class Customer {

	@PrimaryKey("customer_id")
	private UUID customerId;

	@Column("first_name")
	private String firstName;

	@Column("last_name")
	private String lastName;

	@Column("email")
	private String email;

	@Column("password")
	private String password;

	@Column("created")
	private Date createDate;

	public Customer(UUID customerId, String firstName, String lastName, String password, Date createDate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createDate = (createDate != null) ? createDate : new Date();
	}
}
