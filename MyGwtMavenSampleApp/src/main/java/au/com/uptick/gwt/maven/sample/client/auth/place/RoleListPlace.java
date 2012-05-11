package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place de la pantalla de listados de roles.
 * @author dciocca
 *
 */
public class RoleListPlace extends Place {

	public static class Tokenizer implements
			PlaceTokenizer<RoleListPlace> {

		public String getToken(RoleListPlace place) {
			return "";
		}

		public RoleListPlace getPlace(String token) {
			return new RoleListPlace();
		}
	}

}
