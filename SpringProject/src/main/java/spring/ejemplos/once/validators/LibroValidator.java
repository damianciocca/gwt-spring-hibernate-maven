package spring.ejemplos.once.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LibroValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Libro.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		// Valida si el valor del campo titulo es vacio o es nulo
		ValidationUtils.rejectIfEmpty(errors, "titulo", "titulo.vacio");
		
		if (((Libro)target).getPaginas() == 0){
			errors.reject("paginas.vacia");
		}
		
	}

}
