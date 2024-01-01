package mmk.encrypt;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import jakarta.xml.bind.DatatypeConverter;

public class Encryptor {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int value = 25;
		
		String sKey = Base64.getEncoder().encodeToString(Encryptor.generateKey().getEncoded());
		System.out.println(sKey);
		
		String securityString = null;
		SecretKey securityKey = null;
		IvParameterSpec iv = null;
		securityString = "ouX0ouu0ka0E+QyDaICP8Q==";
		securityKey = Encryptor.generateKey();
		iv = Encryptor.generateIvParam();
		//iv = new IvParameterSpec("0000000000000000".getBytes());
		
		String encrypt = "";
		String decrypt = "";
		int indexIf = 3;
		
		switch (indexIf) {
		case 1:
			encrypt = Encryptor.encrypt(String.valueOf(value), securityKey, iv); 
			decrypt = Encryptor.decrypt(encrypt, securityKey, iv);
			break;
		case 2:
			encrypt = Encryptor.encrypt(String.valueOf(value), securityString, iv); 
			decrypt = Encryptor.decrypt(encrypt, securityString, iv);
			break;
		case 3:
			encrypt = Encryptor.encrypt(String.valueOf(value), securityString); 
			decrypt = Encryptor.decrypt(encrypt, securityString);
			break;
		case 4:
			encrypt = Base64.getEncoder().encodeToString(String.valueOf(value).getBytes());
			decrypt = new String(Base64.getMimeDecoder().decode(encrypt));
			break;
		case 5:
			encrypt = DatatypeConverter.printHexBinary(String.valueOf(value).getBytes());
			decrypt = new String(DatatypeConverter.parseHexBinary(encrypt));
			break;
		case 6:
			encrypt = Encryptor.encryptDatatypeConverter(String.valueOf(value));
			break;
		}
		
		System.out.println(encrypt);
		System.out.println(decrypt);
		
	}
	
	
	public static String encryptDatatypeConverter(String code) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(code.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter.printHexBinary(digest);
		    return myHash;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encrypt(String input, SecretKey key, IvParameterSpec iv) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    byte[] cipherText = cipher.doFinal(input.getBytes());
		    return Base64.getEncoder().encodeToString(cipherText);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	public static String encrypt(String input, String keyString, IvParameterSpec iv) {
		SecretKey secretKey = new SecretKeySpec(keyString.getBytes(), "AES");
		return encrypt(input, secretKey, iv);
	}
	public static String encrypt(String input, String keyString) {
		IvParameterSpec iv = new IvParameterSpec(keyString.substring(0,16).getBytes());
		return encrypt(input, keyString, iv);
	}
	
	
	public static String decrypt(String input, SecretKey key, IvParameterSpec iv) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
		    cipher.init(Cipher.DECRYPT_MODE, key, iv); 
		    byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(input));
		    return new String(plainText);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	public static String decrypt(String input, String keyString, IvParameterSpec iv) {
		SecretKey secretKey = new SecretKeySpec(keyString.getBytes(), "AES");
		return decrypt(input, secretKey, iv);
	}
	public static String decrypt(String input, String keyString) {
		IvParameterSpec iv = new IvParameterSpec(keyString.substring(0,16).getBytes());
		return decrypt(input, keyString, iv);
	}
	
	private static SecretKey generateKey() {
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("AES"); 
		    keygenerator.init(256);
		    return keygenerator.generateKey();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private static byte[] generateIv() {
	    byte[] initializationVector = new byte[16];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(initializationVector);
	    return initializationVector;
	}
	
	private static IvParameterSpec generateIvParam() {
	    return new IvParameterSpec(generateIv());
	}
}
