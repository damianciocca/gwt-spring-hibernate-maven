package au.com.uptick.gwt.maven.sample.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/infoService")
public interface InfoService extends RemoteService {

	public String helloWorld(String name);


}
