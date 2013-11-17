package dxat.project.draft.mongodb;


public class Command {
	// Attributes
	private String event = ""; // Available commands
	private String object = ""; // Serialized object 
	private String source = ""; // Serialized object class
	

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
	
}
