package au.com.uptick.gwt.maven.sample.client.auth.view;

import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasCommandHandler;
import au.com.uptick.gwt.maven.sample.client.app.utils.widgets.SimpleMenuItem;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.MenuPresenter;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

public class MenuView extends Composite implements MenuPresenter.Display {
	
	SimpleMenuItem userItem;
	SimpleMenuItem roleItem;
	SimpleMenuItem permissionItem;

	public MenuView() {
			
	    MenuBar adminMenu = new MenuBar(true);
	    userItem = new SimpleMenuItem("Gestion de Usuarios");
	    roleItem = new SimpleMenuItem("Gestion de Roles");
	    permissionItem = new SimpleMenuItem("Gestion de Permisos");
	    adminMenu.addItem(userItem);
	    adminMenu.addItem(roleItem);
	    adminMenu.addItem(permissionItem);
	    
	    MenuBar menu = new MenuBar(false);
	    menu.addItem("Administracion", adminMenu);
	    menu.addItem("Compras", adminMenu);
	    menu.addItem("Ventas", adminMenu);
	    
	    initWidget(menu);
	}

	public HasCommandHandler getMenuAdminUser() {
		
		return userItem;
	}

	public HasCommandHandler getMenuAdminRole() {
		
		return roleItem;
	}

	public HasCommandHandler getMenuAdminPermission() {
		
		return permissionItem;
	}
}
