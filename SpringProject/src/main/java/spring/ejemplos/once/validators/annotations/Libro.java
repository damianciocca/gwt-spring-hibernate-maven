package spring.ejemplos.once.validators.annotations;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Libro {

	@NotNull()
	@Size(min=1, max=250)
	private String titulo;
	
	@Min(1)
	@Max(99999)
	private int paginas;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

}
