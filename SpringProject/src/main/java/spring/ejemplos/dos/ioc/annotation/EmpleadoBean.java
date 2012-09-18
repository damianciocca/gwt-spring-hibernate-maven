package spring.ejemplos.dos.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
/**
 * Clase que inyecta todas las clases
 */
public class EmpleadoBean {
	
		private String name;
		
		private String surname;

		//Inyeccion por constructor
		@Autowired 			
		private CuentaBean cuenta;
		
		//Inyeccion por setter
		private DireccionBean direccion;
		
		//Inyeccion por constructor + nombre
		@Autowired 
		@Qualifier("legajo")
		private LegajoBean legajoBean;
		
		//Inyeccion por metodo (prepare(..))
		private PersonaBean personaBean;
	
		@Autowired
		public void prepare(PersonaBean personaBean) {
			System.out.println("Invocando metodo prepare(..)");
			this.personaBean = personaBean;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public CuentaBean getCuenta() {
			return cuenta;
		}
		public void setCuenta(CuentaBean cuenta) {
			this.cuenta = cuenta;
		}
		
		public DireccionBean getDireccion() {
			return direccion;
		}
		
		@Autowired
		public void setDireccion(DireccionBean direccion) {
			this.direccion = direccion;
		}
		
		public LegajoBean getLegajoBean() {
			return legajoBean;
		}
		
		public void setLegajoBean(LegajoBean legajoBean) {
			this.legajoBean = legajoBean;
		}
		
		public PersonaBean getPersonaBean() {
			return personaBean;
		}

		public void setPersonaBean(PersonaBean personaBean) {
			this.personaBean = personaBean;
		}

		@Override
		public String toString() {
			return "EmpleadoBean [name=" + name + ", surname=" + surname
					+ ", cuenta=" + cuenta.getNumber() + " - " + cuenta.getName()
					+ ", legajo=" + legajoBean.getNumero()
					+ ", persona=" + personaBean.getName()
					+ ", direccion=" + direccion.getCalle() + "]";
		}
		
}
