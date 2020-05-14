/**
 * 
 */
package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author ASUS
 *
 */
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
		
	    JSONObject sampleObject = new JSONObject();
	    /*
	  	JSONArray hobbies = new JSONArray();
	  	
	  	
	    for(int i = 0; i < p.getHob().size(); i++){
	    	hobbies.add(p.getHob().get(i));
	    	}
	    */
	    sampleObject.put("Password", u.getPassword());
	    sampleObject.put("Username", u.getUsername());
	    sampleObject.put("Picture", u.getPic());
	    sampleObject.put("Favs",u.getFavs());
	    Files.write(Paths.get(fileName), sampleObject.toJSONString().getBytes());
	}
	
	
	@SuppressWarnings("unchecked")
	public void printJSON() {
		JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(fileName)) {
        	
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            
            String name = (String) jsonObject.get("name");
            int age = (int) jsonObject.get("age");
            JSONArray msg = (JSONArray) jsonObject.get("Hobbies");
            
            Iterator<String> iterator = msg.iterator();
            
            System.out.println(jsonObject);
            System.out.println(name);
            System.out.println(age);
            
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
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
