package com.ahwers.marvin.testapplications;

import com.ahwers.marvin.framework.application.state.ApplicationState;

public class TestPersistentApplicationState extends ApplicationState {

    private String test = null;

    public TestPersistentApplicationState() {}

    public TestPersistentApplicationState(String appName, Integer stateVersion) {
        super(appName, stateVersion);
    }

    public TestPersistentApplicationState(String encodedState) {
        if (encodedState.equals("test_encoded_state")) {
            this.test = "test";
        }
        else if (encodedState.equals("new_test_encoded_state")) {
            this.test = "new_test";
        }
    }

    public String getTest() {
        return this.test;
    }

    @Override
    public boolean isSameAs(ApplicationState appState) {
        return false;
    }

}
