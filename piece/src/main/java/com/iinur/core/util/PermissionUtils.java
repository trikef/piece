package com.iinur.core.util;

public class PermissionUtils {

	/**
     * Execute action.
     */
    public final static int EXECUTE = 0x1;
    /**
     * Write action.
     */
    public final static int WRITE   = 0x2;
    /**
     * Read action.
     */
    public final static int READ    = 0x4;
    /**
     * All action
     */
    public final static int ALL    = EXECUTE|WRITE|READ;
    /**
     * No actions.
     */
    public final static int NONE    = 0x0;

	public static final String OWNER = "u";
	public static final String GROUP = "g";
	public static final String OTHER = "o";

	public static boolean check(int permission, String group, int action){
		int ownerP = permission / 100;
		int groupP = (permission - (ownerP * 100)) / 10;
		int otherP = permission - (ownerP * 100) - (groupP * 10);

		int result = 0;
		if(group.equals(OWNER)){
			result = (ownerP & action);
		} else if(group.equals(GROUP)){
			result = (groupP & action);
		} else if(group.equals(OTHER)){
			result = (otherP & action);
		}
		return (result == action);
	}
	
	public static boolean checkAction(int action){
		boolean result = false;
		switch (action) {
		case NONE:
			result = true;
			break;

		case EXECUTE:
			result = true;
			break;
			
		case WRITE:
			result = true;
			break;
			
		case READ:
			result = true;
			break;
			
		case ALL:
			result = true;
			break;
			
		case EXECUTE|READ:
			result = true;
			break;
			
		case READ|WRITE:
			result = true;
			break;
		default:
			break;
		}
		return result;
	}
}
