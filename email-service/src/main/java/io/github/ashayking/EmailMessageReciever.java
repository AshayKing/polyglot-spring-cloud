package io.github.ashayking;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@Component
public class EmailMessageReciever {

	public void receiveMessage(byte[] message) throws UnsupportedEncodingException {
		CountDownLatch latch = new CountDownLatch(1);
		Mail mail = new Mail();
		String strMessage = new String(message, "UTF-8");
		log.info("Recieved Message : {} ", strMessage);
		mail.sendEmail(strMessage);
		latch.countDown();
	}

}