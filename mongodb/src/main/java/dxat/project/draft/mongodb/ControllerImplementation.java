package dxat.project.draft.mongodb;

import java.net.UnknownHostException;
import java.security.cert.CollectionCertStoreParameters;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class ControllerImplementation implements ControllerInterface {
	private static MongoClient  conn;
	private static DB db;

	@Override
	public void pushStatistics(PortStatisticsCollection stats) {
		// TODO Auto-generated method stub
		
		try {
			MongoClient conn = new MongoClient("localhost", 27017);
			db = conn.getDB("statsDB");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.println(timestamp);
		//DBCollection collection = db.getCollection("portStatistics");
		Gson gson = new Gson();
		
		for (PortStatistics portstat : stats.getPortStatistics()){
			
			String identifier = portstat.getSwitchId()+"_"+ portstat.getPortNumber();
			
				DBCollection col = db.getCollection(identifier);
				DBObject doc = new BasicDBObject();
				doc.put("infoId", portstat.getSwitchId() +":"+ portstat.getPortNumber());
				doc.put("timeStamp", timestamp);
				DBObject dbObject = (DBObject) JSON.parse(gson.toJson(portstat));
				//dbObject.put("timeStamp", timestamp);
			
				doc.put("data", dbObject);
				col.insert(doc);
			
		
		}
		
		//Separate each port an puting in a DBobject
	    
		//Create a List of DBobjects
		
		//Make a loop over the DbObjects in order to pass to invert Values
			
		
	}
	
	public void insertMinuteDocs(DBCollection minCol){
		
	}
	
	public void insertHourDoCs(DBCollection hourCol){
		
	}
	
	public void upDateDocument(){
		
	}

}
