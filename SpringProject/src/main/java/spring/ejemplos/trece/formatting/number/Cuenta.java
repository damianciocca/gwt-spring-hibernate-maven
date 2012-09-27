package spring.ejemplos.trece.formatting.number;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

public class Cuenta {

	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal amount;

	@NumberFormat(style = Style.NUMBER, pattern = "#,###.###")
	private BigDecimal interest;

	@NumberFormat(style = Style.PERCENT)
	private BigDecimal interestRate;
	
	@DateTimeFormat(iso=ISO.TIME)
    private Date fechaPublicacion;

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	

}
