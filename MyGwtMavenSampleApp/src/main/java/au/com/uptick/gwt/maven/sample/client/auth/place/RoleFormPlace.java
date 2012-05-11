package au.com.uptick.gwt.maven.sample.client.auth.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RoleFormPlace extends Place {

	private Long roleId;
	
	public RoleFormPlace(Long id) {
		
	}
	
	public static class Tokenizer implements PlaceTokenizer<RoleFormPlace> {

		public String getToken(RoleFormPlace place) {
			
			return place.roleId == null ? "" : place.roleId.toString();
		}

		public RoleFormPlace getPlace(String token) {
			
			try{
				Long id = Long.parseLong(token);
				return new RoleFormPlace(id);
			}catch(Exception e){
				return new RoleFormPlace(null);
			}
		}
	}

	public Long getRoleId() {
		return roleId;
	}

}
