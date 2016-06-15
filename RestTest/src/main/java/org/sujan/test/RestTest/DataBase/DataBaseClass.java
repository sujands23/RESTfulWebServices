package org.sujan.test.RestTest.DataBase;

import java.util.HashMap;
import java.util.Map;
import org.sujan.test.RestTest.model.*;

public class DataBaseClass {

	private static Map<Long, Message> messages=new HashMap<>();//Static because every message instance access the same Map
	private static Map<String, Profile> profiles=new HashMap<>();//Static because every profile instance access the same Map
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}