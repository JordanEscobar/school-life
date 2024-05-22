package com.schoollife.web.Service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RutValidationServiceImpl implements RutValidationService{


	@Override
	@Transactional
	public boolean isValidRut(String rut) {
		if (rut == null || rut.isEmpty()) {
            return false;
        }
        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        try {
            int rutNumber = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutNumber != 0; rutNumber /= 10) {
                s = (s + rutNumber % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv != (char) (s != 0 ? s + 47 : 75)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
	}
	

}
