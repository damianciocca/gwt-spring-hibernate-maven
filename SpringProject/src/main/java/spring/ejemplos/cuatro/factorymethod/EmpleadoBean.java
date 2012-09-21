package spring.ejemplos.cuatro.factorymethod;

public class EmpleadoBean {
	
		private String name;
		private String surname;
		private static EmpleadoBean empleadoBean = new EmpleadoBean();
		
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
		public static EmpleadoBean createInstance(){
			System.out.println("EmpleadoBean => createInstance()");
			return empleadoBean;
		} 
		
}
