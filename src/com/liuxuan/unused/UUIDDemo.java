package com.liuxuan.unused;

import java.util.UUID;

public class UUIDDemo {
	public static String Id() {
		String str = UUID.randomUUID().toString();
		return str;
	}
	public static void main(String[] args) {
		String uuid = Id();
		uuid = uuid.replaceAll("-", "");
		System.out.println(uuid);
		uuid = uuid.substring(0, 5);
		System.out.println(uuid);
	}
}
