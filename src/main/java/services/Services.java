package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Student;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.view.Viewable;

import command.CreateStudentCommand;
import command.DeleteStudentCommand;
import command.GetStudentCommand;
import command.ListStudentsCommand;
import command.UpdateStudentCommand;

@Path("student")
public class Services {
	ObjectMapper mapper = new ObjectMapper();

	@GET
	@Path("mvc")
	public Viewable index() {
		return new Viewable("/index.jsp");
	}

	@GET
	@Path("mvc/model")
	public Response mvcModel() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", "Gula");
		List<Student> stuList = new ArrayList<Student>();
		ListStudentsCommand cmd = new ListStudentsCommand();
		stuList = cmd.execute();
		map.put("stus", stuList);
		return Response.ok(new Viewable("/model.jsp", map)).build();
	}

	@GET
	@Path("mvc/jstlmodel")
	public Response mvcJSTLModel() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", "Gula");
		List<Student> stuList = new ArrayList<Student>();
		ListStudentsCommand cmd = new ListStudentsCommand();
		stuList = cmd.execute();
		map.put("stus", stuList);
		return Response.ok(new Viewable("/jstlmodel.jsp", map)).build();
	}

	@POST
	@Path("mvc/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response post(@FormParam("name") String name,
			@FormParam("email") String email, @FormParam("phone") String phone,
			@FormParam("sex") String sex, @FormParam("age") int age,
			@FormParam("address") String address) {
		Student s = new Student(name, email, phone, sex, age, address);
		CreateStudentCommand cmd = new CreateStudentCommand();
		return Response.ok(new Viewable("/create_success.jsp", cmd.execute(s)))
				.build();
	}

	@GET
	@Path("mvc/getstudent")
	public Response mvcGetStudent(@QueryParam("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		GetStudentCommand cmd = new GetStudentCommand();
		Student s = cmd.execute(id);
		map.put("student", s);
		return Response.ok(new Viewable("/view_student2.jsp", map)).build();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getStudent(@PathParam("id") int id) {
		GetStudentCommand command = new GetStudentCommand();
		String songString = null;
		try {
			songString = mapper.writeValueAsString(command.execute(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(songString).build();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createStudent(String payload) {
		CreateStudentCommand create = new CreateStudentCommand();
		Student s = null;
		boolean i = false;
		try {
			s = mapper.readValue(payload, Student.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			Response.status(400).entity("could not read string").build();
		}
		try {
			i = create.execute(s);
		} catch (Exception e) {
			e.printStackTrace();
			Response.status(500).build();
		}
		return Response.status(200).entity(i).build();
	}

	@POST
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateStudent(String payload, @PathParam("id") int id) {
		UpdateStudentCommand update = new UpdateStudentCommand();
		Student s = null;
		try {
			s = mapper.readValue(payload, Student.class);
			s.setId(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			Response.status(400).entity("could not read string").build();
		}
		try {
			update.execute(s);
		} catch (Exception e) {
			e.printStackTrace();
			Response.status(500).build();
		}
		return Response.status(200).build();
	}

	@POST
	@Path("mvc/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateStudent(@FormParam("id") int id,
			@FormParam("name") String name, @FormParam("email") String email,
			@FormParam("phone") String phone, @FormParam("sex") String sex,
			@FormParam("age") int age, @FormParam("address") String address) {
		Student s = new Student(id, name, email, phone, sex, age, address);
		UpdateStudentCommand cmd = new UpdateStudentCommand();
		return Response.ok(new Viewable("/update_success.jsp", cmd.execute(s)))
				.build();
	}

	@DELETE
	@Path("{id}")
	public Response delStudent(@PathParam("id") int id) {

		DeleteStudentCommand cmd = new DeleteStudentCommand();

		return Response
				.ok(new Viewable("/delete_success.jsp", cmd.execute(id)))
				.build();
	}

	@GET
	@Path("mvc/delete/{id}")
	public Response delStudentGet(@PathParam("id") int id) {

		DeleteStudentCommand cmd = new DeleteStudentCommand();

		return Response
				.ok(new Viewable("/delete_success.jsp", cmd.execute(id)))
				.build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response createBook(String bookStr) {

		try {
			CreateStudentCommand create = new CreateStudentCommand();
			Student student = mapper.readValue(bookStr, Student.class);
			boolean success = create.execute(student);
			String bookJSON = mapper.writeValueAsString(student);
			if (success) {
				return Response.status(201).entity(bookJSON).build();
			} else
				return Response.status(500).entity("").build();
		} catch (Exception e) {
			return Response.status(500).entity(e.toString()).build();
		}
	}

}
