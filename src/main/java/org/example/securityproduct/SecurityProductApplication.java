package org.example.securityproduct;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class SecurityProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProductApplication.class, args);
//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//		String base64key = Encoders.BASE64.encode(key.getEncoded());
//
//		System.out.println(base64key);
	}

}
