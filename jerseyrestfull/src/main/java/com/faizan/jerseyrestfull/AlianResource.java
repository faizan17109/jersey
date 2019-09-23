package com.faizan.jerseyrestfull;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.media.jfxmedia.Media;

import sun.security.jgss.spi.MechanismFactory;

@Path("alians")
public class AlianResource {

	AlianRepository repo=new AlianRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alian> getAlians() {
		
		return repo.getAlian();
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("alian/{id}")
//	public Alian getAlian(@PathParam("id") int id) {
	public Alian getAlian(@PathParam("id") int id) {
			
		return repo.getonealian(id);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("alian")
	public Alian create(Alian a) {
		System.out.println(a);
		repo.create(a);
		return a;
	} 
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("alians")
	public Alian update(Alian a) {
		System.out.println(a);
		if(repo.getonealian(a.getId()).getId()==0) {
			repo.create(a);
		}
		else {
			repo.update(a);	
		}
		
		return a;
	}
//	@DELETE
//	public Alian delete(Alian a) {
//		System.out.println(a.getId());
//		if(a.getId()!=0) {
//			repo.delete(a);
//		}
//		return a;
//		
//	}

}
