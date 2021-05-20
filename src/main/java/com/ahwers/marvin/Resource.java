package com.ahwers.marvin;

import java.util.HashMap;
import java.util.Map;

public class Resource {
	
	private String applicationName;
	private int currentStateId;
	private int previousStateId;
	private Map<ResourceRepresentationType, String> resourceRepresentations = new HashMap<>();
	
	public Resource(String applicationName, int currentStateId, int previousStateId) {
		this.applicationName = applicationName;
		this.currentStateId = currentStateId;
		this.previousStateId = previousStateId;
	}
	
	public Resource(String applicationName, int currentStateId, ResourceRepresentationType type, String content) {
		this.applicationName = applicationName;
		this.currentStateId = currentStateId;
		this.previousStateId = previousStateId;
		resourceRepresentations.put(type, content);
	}
	
	public Resource(ResourceRepresentationType type, String content) {
		this.applicationName = "Marvin";
		resourceRepresentations.put(type, content);
	}
	
	public void addRepresentation(ResourceRepresentationType type, String content) {
		resourceRepresentations.put(type, content);
	}
	
	public String getRepresentation(ResourceRepresentationType type) {
		return resourceRepresentations.get(type);
	}
	
	public Map<ResourceRepresentationType, String> getResourceRepresentations() {
		return this.resourceRepresentations;
	}
	
	public String getApplicationName() {
		return this.applicationName;
	}
	
	public int getCurrentStateId() {
		return this.currentStateId;
	}
	
	public int getPreviousStateId() {
		return this.previousStateId;
	}
	
}
