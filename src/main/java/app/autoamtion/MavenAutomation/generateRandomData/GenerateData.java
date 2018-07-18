package app.autoamtion.MavenAutomation.generateRandomData;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {
	
	
	public String generateRandomString(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}
	
	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	
	public String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
}
