package com.aygunestolga.fileoperations.security.jwt;

import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtProvider  implements IJwtProvider{

	@Value("${authentication.jwt.expiration-in-ms}")
	private Long JWT_EXPIRATION_IN_MS;
	
	private static final  String JWT_TOKEN_PREFIX = "Bearer";
	private static final  String JWT_HEADER_STRING = "Authorization";
	
	private final PrivateKey jwtPrivateKey;
	private final PublicKey jwtPublicKey;
	
	public JwtProvider(@Value("${authentication.jwt.private-key}") String jwtPrivateKeyStr, 
			@Value("${authentication.jwt.public-key}") String jwtPublicKeyStr ) 
	{
		try {
			
			KeyFactory keyFactory = getKeyFactory();
			Base64.Decoder decoder = Base64.getDecoder();
			PKCS8EncodedKeySpec privateKey = new PKCS8EncodedKeySpec(decoder.decode(jwtPrivateKeyStr.getBytes()));
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decoder.decode(jwtPublicKeyStr.getBytes()));
			
			jwtPrivateKey = keyFactory.generatePrivate(privateKey);
			jwtPublicKey = keyFactory.generatePublic(publicKeySpec);
			
		}catch(Exception e) {
			throw new RuntimeException("Invalid key specification", e);
		}
		
	}
	
	
	
	private KeyFactory getKeyFactory() {
		try {
			return KeyFactory.getInstance("RSA");
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("Unknown key generation algorithm", e);
		}
	}
	
	
}
