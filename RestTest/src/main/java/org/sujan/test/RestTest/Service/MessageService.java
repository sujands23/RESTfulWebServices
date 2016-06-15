package org.sujan.test.RestTest.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.sujan.test.RestTest.DataBase.DataBaseClass;
import org.sujan.test.RestTest.model.Message;

public class MessageService {

	private Map<Long, Message> messages=DataBaseClass.getMessages();
	
	/*public List<Message> getAllMessages(){
		Message m1=new Message(1,"Hi how are you","Sujan");
		Message m2=new Message(4654564,"I am good","Shreyas");
		List<Message> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}*/
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hi how are you","Sujan"));
		messages.put(2L, new Message(2,"I am good","Shreyas"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear=new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPagination(int startRow, int numberOfRecords){
		List<Message> list=new ArrayList<Message>(messages.values());
		if(startRow+numberOfRecords>list.size())//validation
			return new ArrayList<Message>();
		return list.subList(startRow, startRow+numberOfRecords);
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}