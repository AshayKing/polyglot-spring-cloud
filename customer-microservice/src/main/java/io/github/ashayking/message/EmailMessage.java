package io.github.ashayking.message;

import org.springframework.util.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class EmailMessage {

	private String emailId;

	@JsonProperty("emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public byte[] toBytes() {
		return SerializationUtils.serialize(this);
	}

}