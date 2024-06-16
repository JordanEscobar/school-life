package com.schoollife.web.Service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PasswordValidatorServiceImpl implements PasswordValidatorService{

	//Valida una contraseña de al menos 8 digitos
	@Override
	@Transactional
	public boolean isValidPassword(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        int letterCount = 0;
        int digitCount = 0;
        boolean hasUpperCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
                if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                }
            } else if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return letterCount >= 6 && digitCount >= 2 && hasUpperCase;
	}

}
