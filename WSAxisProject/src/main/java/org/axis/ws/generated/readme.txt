Las clases q se encuentran en la carpeta GENERATED fueron generadas
automaticamente por AXIS mediante los comandos q se detallan a continuacion:

WS - AXIS

	java -cp  axis-ant.jar;axis.jar;commons-discovery-0.2.jar;commons-logging-1.0.4.jar;jaxrpc.jar;log4j-1.2.8.jar;saaj.jar;wsdl4j-1.5.1.jar org.apache.axis.wsdl.WSDL2Java -o target -p org.axis.ws -s calculator.wsdl

	PRUEBA BASICA
	java -cp c:\axis_libs\org\axis\ws\ -p org.axis.ws Calculator

	GENERACION WSDL (se tienen q importar en el classpath los jars que vienen con el directorio lib del axis 1.4):
	java -cp e:\axis_libs\axis-ant.jar;e:\axis_libs\axis.jar;e:\axis_libs\commons-discovery-0.2.jar;e:\axis_libs\commons-logging-1.0.4.jar;e:\axis_libs\jaxrpc.jar;e:\axis_libs\log4j-1.2.8.jar;e:\axis_libs\saaj.jar;e:\axis_libs\wsdl4j-1.5.1.jar;e:\axis_libs org.apache.axis.wsdl.Java2WSDL -o Calculator.wsdl -n urn:org.axis.ws -l http://localhost:8080/axis/services/calculator org.axis.ws.Calculator

	GENERACION CLASES SERVER SIDE Y CLIENT SIDE (se tienen q importar en el classpath los jars que vienen con el directorio lib del axis 1.4):
	java -cp e:\axis_libs\axis-ant.jar;e:\axis_libs\axis.jar;e:\axis_libs\commons-discovery-0.2.jar;e:\axis_libs\commons-logging-1.0.4.jar;e:\axis_libs\jaxrpc.jar;e:\axis_libs\log4j-1.2.8.jar;e:\axis_libs\saaj.jar;e:\axis_libs\wsdl4j-1.5.1.jar;e:\axis_libs org.apache.axis.wsdl.WSDL2Java -o e:\axis_libs\src -p org.axis.ws.generated -s calculator.wsdl
		
	REGISTRACION DEL WS EN AXIS ((Tomcat) Server must be started before executing the following command.)
	java -cp e:\axis_libs\axis-ant.jar;e:\axis_libs\axis.jar;e:\axis_libs\commons-discovery-0.2.jar;e:\axis_libs\commons-logging-1.0.4.jar;e:\axis_libs\jaxrpc.jar;e:\axis_libs\log4j-1.2.8.jar;e:\axis_libs\saaj.jar;e:\axis_libs\wsdl4j-1.5.1.jar;e:\axis_libs org.apache.axis.client.AdminClient  e:\axis_libs\src\org\axis\ws\generated\deploy.wsdd
	
	