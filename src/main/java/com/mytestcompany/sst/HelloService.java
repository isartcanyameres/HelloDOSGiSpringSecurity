package com.mytestcompany.sst;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;

import com.mytestcompany.sst.model.Resource;

@Path("/")
public interface HelloService {

	@Path("/sayHello")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String sayHello(@QueryParam("name") String name);

	@Path("/sayBye")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String sayBye(@QueryParam("name") String name);

	@PostFilter("hasPermission(filterObject, 'readPermission')")
	@Path("/generateResources")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ListWrapper<Long> generateResources();

	@PostAuthorize("hasPermission(returnObject, 'readPermission')")
	@Path("/getResource/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Resource getResource(@PathParam("id") Long id);

	@PostFilter("hasPermission(filterObject, 'readPermission')")
	@Path("/listResources")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ListWrapper<Long> listResources();

}
