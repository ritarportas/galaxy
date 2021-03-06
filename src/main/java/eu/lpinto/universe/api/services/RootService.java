package eu.lpinto.universe.api.services;

import eu.lpinto.universe.util.UniverseFundamentals;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis Pinto <code>- luis.pinto@petuniversal.com</code>
 */
@Path("/")
public class RootService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> get() {
        Map<String, String> result = new HashMap<>(2);
        result.put("application", UniverseFundamentals.APP_NAME);

        return result;
    }
}
