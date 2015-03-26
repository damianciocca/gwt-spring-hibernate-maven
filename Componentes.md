Componentes de este proyecto:


---


---


Maven: para el manejo del ciclo de construcción y despliegue del proyecto. Esta integrado con un plugin llamado CARGO que permite deployar automaticamente el WAR generado en un TOMCAT e inicializar el mismo. El despliegue se llevara a cabo en la fase de INSTALL de maven.

Se utilizo el plugin de CARGO para el deployment sobre el tomcat de forma automática.


---


---


GWT: Frontend

GWT - Mejores practicas

Ver: http://www.google.com/intl/es-419/events/io/2009/sessions/GoogleWebToolkitBestPractices.html

GWT - Antipatterns

http://www.zackgrossbart.com/hackito/antiptrn-gwt/
http://www.zackgrossbart.com/hackito/antiptrn-gwt2/

GWT - MVP & Event Bus (clase HandlerManager)

Ver: https://developers.google.com/web-toolkit/articles/mvp-architecture

Ver: http://gwtquickstart.blogspot.com.ar/2010/03/eventbus-and-mvp.html

Ver: http://code.google.com/intl/es-419/webtoolkit/articles/mvp-architecture.html

Ver codigo ejemplo: http://code.google.com/p/gwt-eb/source/browse/trunk/src/net/phiz/gwteb#gwteb%253Fstate%253Dclosed

GWT - mvp4g (no se va a tener en cuenta)

Ver:http://code.google.com/p/mvp4g/


---


---


GWT - Manejo del historial (clase History). Para esto se tendra una clase llamada AppController que sera la que escuchara los eventos del browser (atrás, adelante)

GWT - Manejo del historial con estado de las paginas: (Place & activities) => Esto reemplaza al AppController que escucha los eventos del browser (no lo vamos a tener mas). Ademas la clase HandlerManager es reemplazada por la clase EventBus.

Ver: http://www.bright-creations.com/blog/gwt-2-1-mvp-client-factory-example/

Integrated the new ClientFactory class required to pass the EventBus and PlaceController around. En nuestro caso, casi casi que no la vamos a necesitar ya que las vistas las vamos a pasar por parametro al constructor del Presenter (como lo indica MVP) y el eventBus nos llegara por parametro en el metodo start de cada Presenter/Activity.

ClientFactory can also be used to get references to the views (las vistas la vamos a seguir manteniendo mediante el Display en cada Presenter)

I’ve replaced the HandlerManager with the new EventBus class used in GWT 2.1

I’ve ditched the AppController class for the new GWT 2.1 PlaceController

Presenters are no longer called presenters, instead they use Activities. En nuestro ejemplo, vamos a seguir manteniendo el nombre de Presenter en lugar de Activities, donde cada Presenter extendera de una AbstractActivity

Added the AppActivityMapper and the AppPlaceHistoryMapper classes recommended for GWT 2.1

Created places Ej: ContactPlace which can be used for accessing the url based locations

No longer use events to jump from url to url, now use the PlaceController to go to new Place. Antes utilizamos los eventos para ir de una sitio al otro, ahora solo vamos a invocar a la clase PlaceController. El eventBus lo vamos a dejar solo para registrar los handlers mas orientado al negocio en si.

http://stackoverflow.com/questions/4978134/state-management-in-gwt

http://stackoverflow.com/questions/4401303/preserving-navigation-history-state-in-gwt-with-mvp-pattern

http://stackoverflow.com/questions/5510571/gwt-mvp-with-places-activities-wheres-the-model

Well, there's nothing forcing you to do MVP with GWT 2.1 activities & Places, but it sure settles the basements for MVP: the Activity will be your presenter and the IsWidget you'll give back to the AcceptsOneWidget will be your view.

http://www.bright-creations.com/blog/gwt-2-1-mvp-client-factory-example/

Ejemplo codigo fuente completo (muy util) donde se utliza A&P + MVP + EventBus:

https://bitbucket.org/gardellajuanpablo/gwt-sample/wiki/Home

Problemas con el eventBus en el método start de la actividad:
http://comments.gmane.org/gmane.org.google.gwt/75197
Solucion: http://stackoverflow.com/questions/6367576/problem-with-order-of-event-registeringe-sending-receiving-and-activities-plac

IMPORTATE: Problemas con el manejo del History: Se ha intentando hacer varias pruebas y para algunos casos funciona correctamente (desde un listado ir a un formulario pasando el ID de la entidad via URL con los places) pero para otros casos no se ha podido encontrale la vuelta (cuando vuelvo al listado, lo ideal seria que me mantegna seleccionado los items del listado como asi tmb los filtros y eso se complica ya que la URL del listado no incluye de entrada las cosas que vos a seleccionar)

Es decir, cuando ingreso al listado la URL es:

http://127.0.0.1:8888/MyGwtMavenSampleApp.html?gwt.codesvr=127.0.0.1:9997#RoleListPlace:

y cuando vamos a la edicion del registro, vemos esta URL:

http://127.0.0.1:8888/MyGwtMavenSampleApp.html?gwt.codesvr=127.0.0.1:9997#RoleFormPlace:51

Con esto permite que haciendo back and forward con el browser nos mantenga los valores de los formularios, pero no así del listado (el o los items seleccionados) Es aqui donde encontramos un problema y por ahora no le dimos una solucion!! (PENDIENTE => IMPORTANTE)

Conclusion: El tema del manejo del history en un principio se utilizo la clase History con una clase custom llamado AppController que escucha los eventos del browser, ademas se utilizo la clase HandlerManager como eventBus teniendo eventos que se disparaban para la navegacion de una pantalla a otro, lo cual me genero demasiados eventos que no aportaban demasiado. En reemplazo de esto, se utilizo el framework que trae a partir de la version 2.1 de gwt, activities and places, lo cual simplifica mucho el tema del history y la navegacion entre las paginas ya que no se dispararan mas eventos para cambiar de URL, sino que los eventos ahora semas mas por temas de negocio, como por ejemplo, se dispara el evento para la eliminacion de un rol de la aplicacion. Por otra parte este framework nos quedo medio chico a la hora de mantener el estado de las paginas (si bien para algunas no hubo problemas, para otras si, como por ejemplo, para mantener los filtros y elementos seleccionados de una pantalla de listado). Por otra parte, recomiendan utilizar el eventBus que trae el activity directamente.

Solo un dato mas para el manejo del historial en la paginacion:

https://groups.google.com/group/google-web-toolkit/tree/browse_frm/month/2011-02/00594fd97cee11e4?rnum=231&_done=%2Fgroup%2Fgoogle-web-toolkit%2Fbrowse_frm%2Fmonth%2F2011-02%3F


---


---


GWT - TableModel (modelos para las grillas, permitiendo obtener objetos tipados en lugar de Strings)

GWT - SimplListModel (modelo para los combos, permitiendo obtener objetos tipados en lugar de Strings) Eso no se usaria ya que para los Combos se utilizaria directmante el SimpleListBox.

GWT - SimpleListBox que extiende de ListBox: para el manejo de combos. Esto inlcuye un modelo de datos tipado e implementa una interface necesaria para poder integrara con el concepto de MVP ya que estos tipos de widgets no tienen una interface adecuada para agregarla al Display (interface de la vista requerida por MVP). Al final este componente lo deprecamos ya que se opto por hacer otro mucho mas simple extendiendo directamente de ListBox llamado SimpleListBox

"According to the Model-View-Presenter approach to GWT development, presenters should not know about specific Widgets in views, but rather call methods on interfaces like HasValue and HasClickHandlers. In practice, this works well with relatively simple widgets like TextBox whose behavior can be described to the presenter in terms of a single interface such as HasValue. However, GWT doesn’t yet provide suitable interfaces for all Widgets. One such example is the ListBox, which implements only HasChangeHandlers and HasName. Wouldn’t it be nice if there were a HasValue equivalent for ListBox that would let you get and set the selected value as well as populate the list?"

URLs utiles para los combos y MVP:

http://turbomanage.wordpress.com/2010/04/01/selectonelistbox-for-use-with-gwtmvp/

https://gist.github.com/337159/3ec29ec0e41e7f554e876429262c0e2c8d0166b5


---


---


GWT - Gwt-Dispatch (no se va a tener en cuenta)

http://code.google.com/p/gwt-dispatch/wiki/GettingStarted
http://code.google.com/p/gwt-dispatch/wiki/ServerConfigurationWithSpring
https://github.com/rombert/gwt-dispatch-sample
http://architects.dzone.com/articles/gwt-architecture-best

NOTA: Al final no me convence demasiado ya que no solo que vamos a tener muchas clases para el action (command) y el result sino que tambien no queda claro como manejar la transaccionabilidad, es decir, si en el handler vamos a tener q inyectar el service de spring. Porque la idea es poder utilizar los @Service de Spring.

Vi un ejemplo donde a los Handlers para un action y un result lo transforman a un BEAN de Spring para poder inyectarle el servicio y el handler queda como un pasamano a un service. Me parece mucho codigo para una simple llamada a un servicio. Mucho pasamano.

Ver: https://bitbucket.org/gardellajuanpablo/gwt-sample/wiki/Home

Por un lado esta bueno, pero vamos a tener muchas clases y pasamamos, cuando en realidad lo podemos resolver directamente mediante un service de Spring.


---


---


GWT - CellTable con paginacion (no usar FlexTable):

Para el tema de la paginacion encontramos que a partir de la version 2.1 de GWT, encontramos con un nuevo widget llamado CellTable: "CellTable is one of the new widgets that supports pagination. Therefore, there no need to use PagingScrollTable in the gwt incubator or implementations in other third-party libraries".

http://www.mytechtip.com/2010/11/gwt-celltable-example-using_8168.html

http://gwt.google.com/samples/Showcase/Showcase.html#!CwCellTable

http://learneverywhere.wordpress.com/java/gwt/pagination-in-gwt-cell-table/

http://google-web-toolkit.googlecode.com/svn/javadoc/2.1/com/google/gwt/user/cellview/client/CellTable.html

http://java-all-frameworks.blogspot.com.ar/2011/08/gwt-panels-widgets.html

CellTable con MVP

http://stackoverflow.com/questions/9751854/achieving-mvp-architecture-with-a-celltable

http://stackoverflow.com/questions/6558476/how-to-expose-table-widget-to-presenter-in-mvp-pattern-with-gwt


BUG del componente a la hora de paginar (no mostraba bien el ultimo resultado):


http://stackoverflow.com/questions/7240871/celltable-paging-with-simplepager

https://groups.google.com/forum/?fromgroups#!topic/google-web-toolkit/RedwgreWKB0

Para corregir este BUG que trae el componente (por lo menos en la version de gwt 2.1.1) tendremos que sobreescribir en la vista el SimplePager que trae por defecto, ya que trula a la hora de obtener el start y end para lograr efectivamente la paginacion.

Igualmente cuando lo sobreescribimos, nos queda un bug que a la hora de completarse el tope de registros por pagina (por ejemplo, tenemos 3 registros listados cuando el limite por pagina para la paginacion es de 3) presionamos siguiente y nos lleva a la siguiente pagina sin ningun sentido y sin valores algunos. Esto no ocurre cuando en la pagina no se llega a dicho tope de registros.

Otro problema que se nos presento es que a la hora de realizar una selección multiple con el checkbox e ir paginando (saltando de una pagina a otra), si bien te mantiene los registros seleccionados (lo cual esta bueno), no los visualiza (no te los muestra seleccionados), con lo cual uno se piensa q no estan seleccionados, pero en realidad si. Aca hay que darle una vuelta de tuerca. Es decir, no se mantiene el estado de los registros seleccionados en el momento de la paginacion. La solucion a esto es sobreescribir el equals y hashcode del objeto de la grilla:

http://stackoverflow.com/questions/8329855/gwt-remember-state-of-checkboxes-after-rangechangeevent-sent-to-table


En conclusión, nos quedaron dos problemas por solucionar:

1. Problema que surge al hacer clic en el boton next cuando tenemos la cantidad de registros igual al maximo por pagina (es decir, si la cantidad max por pagina son 10 registros y solo se tienen 10 registros, nos va a dejar presionar next - por mas q este disabled)

2. Problema con el SELECT ALL cuando paginamos:

https://groups.google.com/forum/?fromgroups#!topic/google-web-toolkit/VvVRO3Cc0EE



---


---

QueryBuilder

Para el tema de la paginacion, vamos a necesitar una clase que se encargue de hacer el wrapper de la paginacion.
Que tenga algo del estilo:

query = em.createQuery(hql.toString());
if (firstResult != null) {
> query.setFirstResult(firstResult);
}
if (maxResults != null) {
> query.setMaxResults(maxResults + 1); // Para saber si hay mÃ¡s registros en la base de datos.
}
for (String paramName : parameterMap.keySet()) {
> > query.setParameter(paramName, parameterMap.get(paramName));
}
return query;

y algo del estilo:

executeQueryWithCount(..)

Q me devuelva tanto el listado como el COUNT del mismo. Util para la paginación y no tener que repetir en todos lados la misma lógica.


---


---


GWT - Problemas con como recuperar los datos de un formulario. Se vuelve sincronica ya que el usuario debera ver todos los datos de una sin esperar que se le vayan completando los campos, filtros, etc..

Para esto se opta por tener un método que se encargue de recuperar todos los datos de la pantalla de una devolviendo un objeto con varios atributos (ej retriveRoleListPage()).


---


---


GWT - HTML (HOME con el header, menu, el footer, el logout, etc)

MENU:

A la hora de armar el menu, se nos presentaron dos problemas:

1. Integrarlo a MVP: Lo cual se resolvió creando una clase custom que extiende de MenuItem e implemente una interface custom llamada HasCommand para luego hacer referencia a HasCommand en la vista (Display) y no al MenuItem directamente.

2. Al agregar un nuevo DIV en el HTML donde se va a alojar el menu, se nos presento el problema de como manejarlo con Activities and Places ya que en el entryPoint de la App solo va a registrar un solo Place. Esto queda pendiente de resolver.

Este tema se resolvió agregando como único Place uno vació llamado HomePlace.java. Siguiendo la lógica de creación del ClientFactory, ActivityMapper y el PlaceHistoryHandler. Dicho Place estará vinculado con un SimplePanel vacio que sera el que se asocie al DIV del HOME

Luego se agrego al DIV del MENU (HTML) una nueva VIEW con su PRESENTER y ClientFactory creado previamente (para compartir el eventbus y el PlaceController). Dicho vista y presentador no utilizan activity and places ya que no es necesario. Solo se respetara el patrón MVP.

MenuView mainView = new MenuView();
MenuPresenter mp = new MenuPresenter(mainView, clientFactory);
RootPanel.get(MENU\_DIV).add(mainView);


---


---


GWT - Popup generico que se lanze para los errores

GWT - Bloqueo de los botones luego de hacer un clic, para evitar que vaya N veces a la BD. Y volverlo a habilitar cuando el server de una respuesta.

GWT - Extender el AsyncCallback y armar uno generico con los mensajes de error correspondientes


---


---


GWT & Hibernate -

NO llevar las entities de JPA clientside: Lazy properties issue : when trying to send a partially loaded Hibernate POJO to the client-side of GWT (Javascript), the GWTcompiler throws a Serialization exception because it the CGLIB generated proxy does not belong to the JRE emulation.

Type issue : Hibernate replaces some basic Java types with various subclassed implementation (such as java.sql.Timestamp instead of  java.util.Date or PersistentList for List collections).

Javascript serialization of these classes will fail, since they do not belong to the JRE emulation supported by GWT 1.4 (note : the Java
SQL dates are now supported by GWT 1.5)


---


---


Spring Security: Para le manejo de la autenticacion y autorización.

GWT - Link de logout con SpringSecurity

GWT - Usuario logueado en el HTML via SpringSecurity

GWT & Spring security - que sucede si al hacer para atras o adelante desde el browser y la session expiro ?
http://stackoverflow.com/questions/8957131/keeping-gwt-history-hashes-thru-spring-security-login

Ver: http://www.javacodegeeks.com/2010/12/securing-gwt-apps-with-spring-security.html

Ver: http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=utilizaciondegruposenspringsecurity

Ver: http://code.google.com/p/google-web-toolkit-incubator/wiki/LoginSecurityFAQ

Ver: http://groups.google.com/group/google-web-toolkit/browse_thread/thread/c6dfd91b52eea79a/05ef63f01d7b2b8f?lnk=gst&q=session#05ef

Ver: http://groups.google.com/group/google-web-toolkit/browse_thread/thread/c5ede413a44b3737/b1ee110ccc3b9b1e?lnk=dice

Manejar la seguridad a nivel de permisos en la aplicación y no a nivel de roles. Una buena practica es no harcodear los roles en la aplicación para que estos se puedan dar de alta dinamicamente.

Un tema oscuro de spring security con gwt es que no esta pensado 100%$ para aplicaciones JavaScripts-AJAX puras, donde gran parte de la lógica de presentación esta del lado cliente, ya que cuestan en ciertos puntos poder integrarlas a ambos de manera transparente.
Con un framework para la capa de presentación como JSF u Spring MVC seguramente resulte mas fácil su integración.
Mas que nada porque nos topamos con problemas como por ejemplo, cuando spring security nos redirige al login form, por algun problema de authenticacion, dicho direccionamiento no termina saliendo por el browser y se termina viendo por consola del IDE de desarrollo. Esto es un claro ejemplo de como todavía estas dos tecnologías no están taaan emparentadas, donde dichos problemas se los tiene que resolver a mano.


---


---


JasperReport & iReport


---


---


Spring: Middleware



---


---



JPA/Hibernate: Persistencia


Manejo de CAPTCHA: http://www.javacodegeeks.com/2010/06/add-captcha-gwt-application.html

Transacciones

Manejo de excepciones

Paginacion

JTA/Datasource

Cache de 2do nivel de hibernate

Dependency Injection

Place Service