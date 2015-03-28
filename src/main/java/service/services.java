package service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Emp;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.ListEmp;
import controller.constants;


@Path("employee")
public class services {
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
	
	/*
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createSongs(String payload) {
		CreateEmp create = new CreateEmp();
		Emp e = null;
		String i = "";
		try {
			e = mapper.readValue(payload, Emp.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			Response.status(400).entity("could not read string").build();
		}
		try {
			i = create.execute(e);
		} catch (Exception ev) {
			ev.printStackTrace();
			Response.status(500).build();
		}
		return Response.status(200).entity(i).build();
	}
	*/
}
