package org.RESTfulMessengerApp.Resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.RESTfulMessengerApp.Service.MessageService;
import org.RESTfulMessengerApp.Model.Message;

@Path("/Messages")
public class MyMessages {

	MessageService ms=new MessageService();
	
	//Get multiple message
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		//return "Hello World";
		return ms.getAllMessages();
	}*/
	
	//Get multiple messages for a particular year
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("startRow") int startRow,
									 @QueryParam("numberOfRecords") int numberOfRecords){
		if(year>0)
			return ms.getAllMessagesForYear(year);
		if(startRow>=0 && numberOfRecords>=0){
			return ms.getAllMessagesPagination(startRow, numberOfRecords);
		}
			return ms.getAllMessages();
	}
	
	//Get Single message
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long msgId){//@PathParam is used to get the value from the part of the URL and inject into the method parameter
		//return "PathParam is : "+messageId;
		return ms.getMessage(msgId);
	}
	
	//Add new message
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		//return "POST Works";
		return ms.addMessage(message);
	}
	
	//Update existing message
	@PUT
	@Path("/{messageId}")//Update the message
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam ("messageId") long msgId,Message message){
		message.setId(msgId);//To take the message Id from the URL
		return ms.updateMessage(message);
	}
	
	//Delete message
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam ("messageId") long msgId){
		ms.removeMessage(msgId);
	}
}