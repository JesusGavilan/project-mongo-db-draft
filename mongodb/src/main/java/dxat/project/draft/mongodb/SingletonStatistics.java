package dxat.project.draft.mongodb;

import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;



public class SingletonStatistics {
	
	public static SingletonStatistics instance;
	
	private SingletonStatistics(){
		
	}
	
	public static SingletonStatistics getInstance(){
		if(instance == null)
			instance = new SingletonStatistics();
		return instance;
	}
	
public void execCommand(Command comando){
		
		//Getting a object stat from command	
		PortStatisticsCollection stats = objectFromJson(comando);
		
		ControllerImplementation action = new ControllerImplementation();
		
		//Applying implementation
		action.pushStatistics(stats);
		
	}
	
	/***
	 * 
	 * For testing the next methods have a extra argument
	 * to neglect the deserealization.
	 */
	public PortStatisticsCollection objectFromJson( Command cmd){
		//Here parse json to Command
		//for testing: passing a command
		String statistics = cmd.getObject();
		Gson gson = new Gson();
		PortStatisticsCollection coleccion = gson.fromJson(statistics, PortStatisticsCollection.class);
		return coleccion;
		
	}

	
	
}


