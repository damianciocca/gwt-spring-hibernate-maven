package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place de la pantalla principal.
 * @author dciocca
 *
 */
public class MenuPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<MenuPlace> {

		public String getToken(MenuPlace place) {
			return "";
		}

		public MenuPlace getPlace(String token) {
			return new MenuPlace();
		}
	}

}
