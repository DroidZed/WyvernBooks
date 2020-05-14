/**
 * @author DroidZed
 */
package application;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON_IO_Ops {
	
	private static String fileName;
	
	public JSON_IO_Ops() {
		fileName = "";
	}
	
	public JSON_IO_Ops(String f) {
		fileName = f;
	}
	
	@SuppressWarnings("unchecked")
	public void saveUserInfo(User u) throws Exception {
		//belhy arj3lha hedhi 8odwa w salla7 waldiha....
	    JSONObject userObj = new JSONObject();
	    
	    JSONObject finalObject  = new JSONObject();
	  	
	    userObj.put("Password", u.getPassword());
	    userObj.put("Username", u.getUsername());
	    userObj.put("Picture", u.getPic());
	    userObj.put("Favs",u.getFavs());
	    
	    int i = 0;

	    File f = new File(fileName);
	    
	    	if (f.length() < 53) {
	    		finalObject.put("User"+i,userObj);
	    		 Files.write(Paths.get(fileName), finalObject.toJSONString().getBytes());
	    	} 
	   
	    	else {
	    		JSONObject old = readJSON();

	    		finalObject.put("User"+i, old.get("User"+i));
	    		i++;
	    		finalObject.put("User"+i, userObj);

	    		Files.write(Paths.get(fileName), finalObject.toJSONString().getBytes());
	    	}
	}

	public JSONObject readJSON() throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
        try (Reader reader = new FileReader(fileName)) {
             jsonObject = (JSONObject) parser.parse(reader);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return jsonObject;
	}
	public Boolean validateUser(Boolean sUp,String ...vals) throws Exception{
			
			if(new File(fileName) != null) {
				JSONObject j = readJSON();
				String usr = (String) j.get("Username");
				
				if(sUp == true) {	
				
					if(usr == vals[0])
						return false;
				}
				else {
					String pwd = (String) j.get("Password");
					if(pwd != vals[0] && pwd == "")
						return false;
					}
	}
          return true;
   }

}
