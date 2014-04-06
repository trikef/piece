package com.iinur.core.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PermissionUtilsTest {
	
	@Test
	public void check_OwnerTest(){
		int permission = 300;
		String group = PermissionUtils.OWNER;
		int action = PermissionUtils.WRITE;
		assertTrue(PermissionUtils.check(permission, group, action));
	}
	@Test
	public void check_GroupTest(){
		int permission = 070;
		String group = PermissionUtils.GROUP;
		int action = PermissionUtils.EXECUTE;
		assertTrue(PermissionUtils.check(permission, group, action));
	}
	@Test
	public void check_OtherTest(){
		int permission = 002;
		String group = PermissionUtils.OTHER;
		int action = PermissionUtils.READ;
		assertTrue(!PermissionUtils.check(permission, group, action));
	}
}