package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace  extends Place {

	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		public String getToken(HomePlace place) {
			return "";
		}

		public HomePlace getPlace(String token) {
			return new HomePlace();
		}
	}

}

