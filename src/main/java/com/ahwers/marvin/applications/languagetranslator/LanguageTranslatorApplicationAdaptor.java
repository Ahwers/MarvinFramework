package com.ahwers.marvin.applications.languagetranslator;

import java.util.Map;

import com.ahwers.marvin.framework.application.Application;
import com.ahwers.marvin.framework.application.ApplicationAdaptor;
import com.ahwers.marvin.framework.application.CommandMatch;
import com.ahwers.marvin.framework.application.IntegratesApplication;
import com.ahwers.marvin.framework.response.MarvinResponse;

@IntegratesApplication("Language Translator")
public class LanguageTranslatorApplicationAdaptor extends ApplicationAdaptor {

	@Override
	protected Application instantiateApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO: Could probably implement these matching methods like "translateWord(String word)". Rather than passing the arguments map to methods, the framwork could parse the variables it captures, then theres no need for my bad implementation of recognising argument names in regexes.
	@CommandMatch("(?:whats|what is) (?<word>\\w+) in (?<language>\\w+)")
	public MarvinResponse translateWord(Map<String, String> arguments) {
		return null;
	}
	
	@CommandMatch("(?:whats|what is) (?<sentence>(?:\\w+\\s+\\w+\\s*)+) in (?<language>\\w+)")
	public MarvinResponse translateSentence(Map<String, String> arguments) {
		return null;
	}
	
}
