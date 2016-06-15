package org.RESTfulMessengerApp.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.RESTfulMessengerApp.DataBase.DataBaseClass;
import org.RESTfulMessengerApp.Model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles=DataBaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Sujan", new Profile(1,"sujands23","Sujan","Davangere Sunil"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}

