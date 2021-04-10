package com.ahwers.marvin;

import java.util.ArrayList;
import java.util.List;

import com.ahwers.marvin.applications.ApplicationAction;
import com.ahwers.marvin.applications.ApplicationsManager;

public class MarvinResponseFactory {
	
	public static MarvinResponseFactory getResponseFactoryForApplicationManager(ApplicationsManager appManager) {
		return new MarvinResponseFactory(appManager);
	}
	
	private ApplicationsManager appManager;
	
	private String command;
	private List<ApplicationAction> directCommandActionMatches = new ArrayList<>();
	private List<ApplicationAction> phoneticCommandActionMatches = new ArrayList<>();
	
	private MarvinResponseFactory(ApplicationsManager appManager) {
		this.appManager = appManager;
	}
	
	public MarvinResponse getResponseForAppAction(ApplicationAction action) {
		return appManager.executeApplicationAction(action);
	}
	
	public MarvinResponse getResponseForCommand(String command) {
		this.command = command;
		this.directCommandActionMatches = appManager.getApplicationActionsThatDirectlyMatchCommand(command);
		this.phoneticCommandActionMatches = appManager.getApplicationActionsThatPhoneticallyMatchCommand(command);
		
		MarvinResponse response = null;
		if (oneActionMatchedDirectly()) {
			response = appManager.executeApplicationAction(directCommandActionMatches.get(0));
		}
		else if (multipleActionsMatchedDirectly()) {
			response = buildActionSelectionResponse(directCommandActionMatches);
		}
		else if (oneOrMoreActionsMatchedPhonetically()) {
			response = buildActionSelectionResponse(phoneticCommandActionMatches);
		}
		else {
			response = buildInvalidCommandResponse();
		}

		return response;
	}
	
	private boolean oneActionMatchedDirectly() {
		return (directCommandActionMatches.size() == 1 ? true : false);
	}
	
	private boolean multipleActionsMatchedDirectly() {
		return (directCommandActionMatches.size() > 1 ? true : false);
	}
	
	private boolean oneOrMoreActionsMatchedPhonetically() {
		return (phoneticCommandActionMatches.size() >= 1 ? true : false);
	}
	
	private MarvinResponse buildActionSelectionResponse(List<ApplicationAction> actionOptions) {
		MarvinResponse response = new MarvinResponse(CommandStatus.UNMATCHED, "Please be more specific.");
		
		String selectionContent = "";
		for (ApplicationAction action : actionOptions) {
			selectionContent += (stringifyApplicationAction(action) + "\n");
		}
		response.addResource(new Resource(ResourceType.COMMAND_OPTION_LIST, selectionContent));
		
		return response;
	}
	
	private String stringifyApplicationAction(ApplicationAction action) {
		String stringifiedAction = "";
		
		stringifiedAction += (action.getApplicationName() + ":" + action.getActionName());
		for (String argumentKey : action.getArguments().keySet()) {
			stringifiedAction += ("&" + argumentKey + "==" + action.getArguments().get(argumentKey));
		}
		
		return stringifiedAction;
	}
	
	private MarvinResponse buildInvalidCommandResponse() {
		return new MarvinResponse(CommandStatus.INVALID, "Sorry, I have not been programmed to process that command.");
	}
	
}
