package com.ahwers.marvin.framework.application.action;

import java.util.Map;

import javassist.expr.Instanceof;

// TODO: Should this and ActionDefintion be renamed to be pre-fixed with Application?
public class ActionInvocation extends ApplicationAction {
    
    private Map<String, String> arguments;

    public ActionInvocation(String applicationName, String actionName, Map<String, String> arguments) {
        super(applicationName, actionName);

        if (arguments == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        
        this.arguments = Map.copyOf(arguments);
    }

    public Map<String, String> getArguments() {
        return Map.copyOf(arguments);
    }

    @Override
    public boolean isSameAs(ApplicationAction appAction) {
        if ((appAction instanceof ActionInvocation) == false) {
            // TODO: Am i sure that these error checks should be throwing IllegalArgumentException?? The exception InvalidParameterException exists so maybe that or something else is better style?
            throw new IllegalArgumentException("Argument must be of type ActionInvocation");
        }

        ActionInvocation invocation = (ActionInvocation) appAction;

        boolean isSameAs = super.isSameAs(invocation);
        if (isSameAs == true) {
            isSameAs = arguments.equals(invocation.getArguments());
        }

        return isSameAs;
    }

}