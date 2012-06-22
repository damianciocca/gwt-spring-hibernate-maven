package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.utils.FormTypeEnum;
import au.com.uptick.gwt.maven.sample.client.auth.place.HomePlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.MenuPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleFormPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.client.auth.view.HomeView;
import au.com.uptick.gwt.maven.sample.client.auth.view.MenuView;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleFormView;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleListView;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

/**
 * Mapea las actividades que deben comenzar dado un place y retorna
 * el activity/presenter
 *  
 * @see http://tbroyer.posterous.com/gwt-21-activities
 * @author dciocca
 *
 */
public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	private final SecurityServiceAsync securityService = GWT.create(SecurityService.class);

	public AppActivityMapper(ClientFactory clientFactory) {
		
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity.
	 * 
	 */
	public Activity getActivity(Place place) {
		
		
		if (place instanceof MenuPlace){
			return new MenuPresenter(new MenuView(), clientFactory);
			
		} else if (place instanceof HomePlace){
			return new HomePresenter(new HomeView(), clientFactory);
			
		} else if (place instanceof RoleListPlace){
			return new RoleListPresenter((RoleListPlace)place, clientFactory, securityService, new RoleListView());
			
		} else if (place instanceof RoleFormPlace){
			RoleFormPlace roleFormPlace = (RoleFormPlace)place;
			if (roleFormPlace.getRoleId() != null){
				return new RoleFormPresenter((RoleFormPlace)place, clientFactory, securityService, new RoleFormView(), FormTypeEnum.EDIT_FORM);
			} else {
				return new RoleFormPresenter((RoleFormPlace)place, clientFactory, securityService, new RoleFormView(), FormTypeEnum.ADD_FORM); 
			}
		}
		
		
		return null;
	}

}
