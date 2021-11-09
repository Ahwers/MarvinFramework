package com.ahwers.marvin.framework.application;

public abstract class ApplicationAction {
	
	private String applicationName;
	private String actionName;

	public ApplicationAction(String appName, String actionName) {
		if (appName == null || actionName == null) {
			throw new IllegalArgumentException("Arguments cannot be null.");
		}

		this.applicationName = appName;
		this.actionName = actionName;
	}

	public String getApplicationName() {
		return this.applicationName;
	}
	
	public String getActionName() {
		return this.actionName;
	}

	public boolean isLike(ApplicationAction action) {
		boolean isLike = true;

		if (!this.applicationName.equals(action.getApplicationName())) {
			isLike = false;
		}
		else if (!this.actionName.equals(action.getActionName())) {
			isLike = false;
		}

		return isLike;
	}

}
