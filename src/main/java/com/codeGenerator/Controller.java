package com.codeGenerator;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/api/random/{code}")
	public String generateCode(@PathVariable String code) {

		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (char c : code.toCharArray()) {

			if (Character.isDigit(c)) {

				sb.append(r.nextInt(9));

			} else if (Character.isAlphabetic(c)) {

				if (Character.isUpperCase(c)) {
					int randomChar = r.nextInt(((int) 'Z' - (int) 'A') + 1) + (int) 'A';
					sb.append((char) randomChar);
				} else {
					int randomChar = r.nextInt(((int) 'z' - (int) 'a') + 1) + (int) 'a';
					sb.append((char) randomChar);
				}

			} else {
				sb.append(c);
			}

		}

		return sb.toString();
	}

}
