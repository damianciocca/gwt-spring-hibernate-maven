package spring.ejemplos.catorce.el;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public class Libro {

	// email regular expression
	private String emailRegEx = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private String title;
	private Date date;
	private String os;
	private int randomValue;
	@Value("d@gmail.com")
	private String emailAddress;
	private boolean isValidEmail;
	@Value("10")
	private int price;
	

	// if this emailAddress contains a valid email address?
	@Value("#{libro.emailAddress matches libro.emailRegEx}")
	public void setValidEmail(boolean isValidEmail) {
		this.isValidEmail = isValidEmail;
	}

	// El operador especial T(type) se puede utilizar para obtener una referencia a una 
	// clase, e invocar sus métodos estáticos
	@Value("#{ T(java.lang.Math).random() * 100 }")
	public void setRandomValue(int randomValue) {
		this.randomValue = randomValue;
	}

	// SpEL se utiliza de la forma "#{ <expresión> }":
	// Las expresiones de SpEL se pueden utilizar con la anotación @Value directamente sobre las 
	// propiedades de los bean, o sobre sus setters correspondientes, para establecer valores por defecto:
	@Value("#{ systemProperties['os.name'] }")
	public void setOs(String os) {
		this.os = os;
	}
	
	public String getOs() {
		return os;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getRandomValue() {
		return randomValue;
	}
	public boolean isValidEmail() {
		return isValidEmail;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailRegEx() {
		return emailRegEx;
	}

	public void setEmailRegEx(String emailRegEx) {
		this.emailRegEx = emailRegEx;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
