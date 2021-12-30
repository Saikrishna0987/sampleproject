package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

@Slf4j
public class UserUtility {
	public static String base64Encoder(String key) {
		String result = "";
		try {
			byte[] bytesEncoded = Base64.encodeBase64(key.getBytes());
			String encoded = new String(bytesEncoded);
			result = "Basic " + encoded;
		} catch (Exception e) {
			log.error("Error in base64Encoder() method !! ", e);
		}
		return result;
	}

}
