package au.com.uptick.gwt.maven.sample.client.auth.place;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place de la pantalla de listados de roles.
 * @author dciocca
 *
 */
public class RoleListPlace extends Place {

	List<Long> roleIds = new ArrayList<Long>();

	public RoleListPlace(List<Long> ids) {
		super();
		if (ids != null){
			roleIds.addAll(ids);
		}
	}

	public RoleListPlace() {
		super();
		
	}

	public static class Tokenizer implements PlaceTokenizer<RoleListPlace> {

		public String getToken(RoleListPlace place) {

			List<Long> roleIds = place.getRoleIds();
			if (roleIds != null){
				StringBuffer sb = new StringBuffer();
				for (Long id : roleIds) {
					sb.append(id);
					sb.append(";");
				}
				return sb.toString();
			} else {
				return "";
			}			
		}

		public RoleListPlace getPlace(String token) {

			try{
				List<Long> result = new ArrayList<Long>();
				String[] idsAux = token.split(";");
				for (String id : idsAux) {
					result.add(Long.parseLong(id));
				}
				return new RoleListPlace(result);
			}catch(Exception e){
				return new RoleListPlace(null);
			}
		}
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

}
