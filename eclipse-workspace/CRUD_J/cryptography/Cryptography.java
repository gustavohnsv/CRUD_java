package cryptography;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cryptography {
	public static final String SHA256 = "SHA-256";
	public static final String MD5 = "MD5";
	
	protected String info;
	protected String pattern;
	
	public Cryptography(String info, String pattern) {
		super();
		this.info = info;
		this.pattern = pattern;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String toCryptography() {
		String info = getInfo();
		MessageDigest messageDigest;
		StringBuilder hexString = null;
		
		try {
			messageDigest = MessageDigest.getInstance(getPattern());
			byte[] hash = messageDigest.digest(info.getBytes(StandardCharsets.UTF_8));
			hexString = new StringBuilder(2*hash.length);
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
					if (hex.length() == 1) {
						hexString.append(1);
					}
				hexString.append(hex);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		

		
		return hexString.toString().toUpperCase();
	}
	
	
} // TRECHO DE CÓDIGO RETIRADO DE VIDEOAULA: https://www.youtube.com/watch?v=kXHSWc3QXJs&ab_channel=WellinsonGabriel
