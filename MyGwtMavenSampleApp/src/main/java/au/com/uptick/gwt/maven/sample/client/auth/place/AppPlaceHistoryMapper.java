package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Mapper donde se definen los PlaceTokenizer de la aplicaci&oacute;n.
 * @author dciocca
 */
@WithTokenizers({ MainPlace.Tokenizer.class,
				  RoleListPlace.Tokenizer.class,
				  RoleFormPlace.Tokenizer.class
			    })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper{

}
