package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place de la pantalla principal.
 * @author dciocca
 *
 */
public class MainPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		public String getToken(MainPlace place) {
			return "";
		}

		public MainPlace getPlace(String token) {
			return new MainPlace();
		}
	}

}
