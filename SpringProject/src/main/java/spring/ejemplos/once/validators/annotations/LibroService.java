package spring.ejemplos.once.validators.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;

public class LibroService {

	@Autowired
    private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
