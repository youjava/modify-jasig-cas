package org.stackbox.darkportal.mechanism.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	public static String md5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	/**
	 * 通过用户名和密码加密
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回加密后的16进制的字符串
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String username,String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(username.getBytes());
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		//System.out.println(md5("fun@123"));
		
		/*int[] array = new int[10];
		
		for(int i=0; i<10; i++){
			//array[i] = (int)(Math.random()*5);
			array[i] = new Random().nextInt(20)+1;
		}
		
		for(int i=0; i<10; i++){
			System.out.print(array[i]+",");
		}
		System.out.println();*/
		
		System.out.println(md5("sjncelhsc"));
	}
}
