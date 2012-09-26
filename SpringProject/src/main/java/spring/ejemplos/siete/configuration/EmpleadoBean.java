package spring.ejemplos.siete.configuration;


public class EmpleadoBean {
	
		private String name;
		private String surname;
		
		public EmpleadoBean() {
			super();
			System.out.println("Se inicializa el objeto mediante el constructor => EmpleadoBean");
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

}
