package services;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Emp;
import controller.ListEmp;
import controller.constants;

@Path("empp")
public class Service {
	
	ObjectMapper mapper = new ObjectMapper();

	// Browse all songs
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response browseSongs(@QueryParam("offset") int offset,
			@QueryParam("count") int count) {
		ListEmp command = new ListEmp();
		ArrayList<Emp> list = command.execute();
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put(constants.Pagination.DATA, list);
		hm.put(constants.Pagination.OFFSET, offset);
		hm.put(constants.Pagination.COUNT, count);
		String songString = null;
		try {
			songString = mapper.writeValueAsString(hm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(songString).build();
	}

}
