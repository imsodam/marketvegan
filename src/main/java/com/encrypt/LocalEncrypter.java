package com.encrypt;

//암호화->java.security패키지 필요
//key(암호화를 시킬정보),InvalidKeyException(키에러발생)
import java.security.InvalidKeyException;
import java.security.Key;

//BadPaddingException(패팅에러유발)
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

//추가(패딩클래스)
import java.util.Base64;
import java.util.Base64.Decoder; //복호화
import java.util.Base64.Encoder;//암호화
//////////////////////////////////

public class LocalEncrypter {

	//1.암호화할때 사용되는 알고리즘->암호화시켜주는 함수(수식계산)=>자리수가 많을수록,수식복잡
	private static String algorithm="DESede";//알고리즘의 한 종류
	
	//2.키가 필요(암호화시킬때 내부적으로 필요로하는 비밀정보)
	private static Key key=null;
	
	//3.암호화시켜주는 객체->초기화시켜줘야되는데 Cipher객체
	private static Cipher cipher=null;
	
	//4.암호화시키기 위해서 필요로하는 메서드를 작성
	//4-1)키생성=>생성자
	private static void setUp()throws Exception {
		//암호화시키기위해서 key,chiper객체<-알고리즘(계산)
		key=KeyGenerator.getInstance(algorithm).generateKey();//은행(보안키)
		cipher=Cipher.getInstance(algorithm);
		System.out.println("cipher=>"+cipher+",key=>+key");
	}
	//4-2)암호화시켜주는 메서드(평문(String)->암호화(byte[])=>복잡한 계산=>String(암호화)
	public static byte[] encrypt(String input)
			throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException{
		//1.cipher객체(암호화옵션,키이름)->초기화
		cipher.init(Cipher.ENCRYPT_MODE,key);
		//2.input->byte[](암호화시키기위해서 담아준다.)
		byte[] inputBytes=input.getBytes();//암호화X
		//3.cipher객체의 doFinal(암호화시킬 byte[])=>암호화된 byte[]로 변환
		byte[] str=cipher.doFinal(inputBytes);//암호화 O
		return str;
	}
	//4-3)복호화시켜주는 메서드(암호화->평문으로 변환)
	public static String decrypt(byte[] encryptionBytes)
			throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException{
		//1.cipher객체(암호화옵션,키이름)->초기화
		cipher.init(Cipher.DECRYPT_MODE,key);
		//2.암호화된 byte[]=>정상적인 byte[]=>String으로 변환
		byte[] recoveredBytes=cipher.doFinal(encryptionBytes);//암호화X
		//3.byte[] 평문=>String(안녕하세요)
		String recovered=new String(recoveredBytes);
		return recovered;
	}
	//4-4)패딩(수선)입력받은 문자열=>BASE64Encoder=>String(웹상에 출력) 암호화
	
	public static String returnEncryptCode(String str)throws Exception{
		byte[] encryptionBytes=null;//암호화시켜서 담을 배열
		setUp();//key,chiper객체생성
		encryptionBytes=encrypt(str);//암호화된 숫자배열->자릿수가 부족
		//패딩->암호화된 몇글자를  추가로 문자열끝에 첨부
		//BASE64Encoder encoder=new BASE64Encoder();//(X)
		Encoder encoder=Base64.getEncoder();
		//암호화된 byte[]값을 String변환
		//String encodeString=encoder.encode(encryptionBytes);//(X)
		String encodeString=encoder.encodeToString(encryptionBytes);//byte[]->String
		//String encodeString=new String(encryptionBytes);
		return encodeString;//암호화된 문자열에 웹에 출력
	}
	//4-5)패딩(수선)입력받은 문자열=>BASE64Decoder=>String(웹상에 출력) 복호화(복원)
	public static String returnDecryptCode(String str)throws Exception{
		//BASE64Decoder decoder=new BASE64Decoder();//(X)
		Decoder decoder=Base64.getDecoder();//복호화시키기 위한 객체
		//원래 상태 평문(복호화)문자열을 그대로 출력
		//decoder.decodeBuffer(str)=>byte[]로 변환=>최종적으로 복원된 String출력
		byte[] convert=str.getBytes();
		//String decode=decrypt(decoder.decodeBuffer(str));
		String decode=decrypt(decoder.decode(convert));
		//String decode=decrypt(convert);
		return decode;//평문으로 최종변환
	}
}