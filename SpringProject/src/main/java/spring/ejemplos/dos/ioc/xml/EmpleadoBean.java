package spring.ejemplos.dos.ioc.xml;

public class EmpleadoBean {
	
		private String name;
		private String surname;
		private CuentaBean cuenta;

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
		
		@Override
		public String toString() {
			return "EmpleadoBean [name=" + name + ", surname=" + surname
					+ ", cuenta=" + cuenta.getNumber() + " - " + cuenta.getName() + "]";
		}
		
}
