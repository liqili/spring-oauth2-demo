package com.solaris.resourcecenter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getTokenDetails(@RequestHeader HttpHeaders headers) {
		System.out.println(headers);
		// get Token
//		OAuth2Authentication a = (OAuth2Authentication) SecurityContextHolder
//				.getContext().getAuthentication();
//		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) a
//				.getDetails();
//		String tokenValue = headers.get(HttpHeaders.AUTHORIZATION).get(0);
//
//		// get Claims from Token
//		String claims = retrieveClaimsFromJWT(tokenValue);
//		LocalDateTime expiredDate = calculateExpirationFromClaims(claims);
//		LocalDateTime timeNow = LocalDateTime.now();
//
//		String body = "tokenValue: " + tokenValue + "<p/>" + "claims " + claims
//				+ "<p/>" + "expiryDate " + expiredDate + "<p/>" + "now is "
//				+ timeNow + "<p/>" + "expired "
//				+ isTokenExpired(expiredDate, timeNow);
//		return body;
		return headers.toString();
	}

	private boolean isTokenExpired(LocalDateTime expiredDate,
			LocalDateTime timeNow) {
		return expiredDate.isBefore(timeNow);
	}

	private String retrieveClaimsFromJWT(String token) {
		Jwt jwt = JwtHelper.decode(token);
		String claims = jwt.getClaims();
		return claims;
	}

	private LocalDateTime calculateExpirationFromClaims(String claims) {
		JSONObject responseJSON = new JSONObject(claims);
		long exp = responseJSON.getInt("exp");
		Instant instant = Instant.ofEpochSecond(exp);
		LocalDateTime inBerlin = LocalDateTime.ofInstant(instant,
				ZoneId.of("Europe/Berlin"));

		return inBerlin;
	}
}
