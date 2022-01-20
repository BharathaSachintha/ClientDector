package code.rmi.Util;

import javax.swing.ButtonGroup;

import com.mysql.cj.util.StringUtils;

public class Validator{
	
	public static boolean requiredFeildValidator(String value) {
		return StringUtils.isNullOrEmpty(value);
	}
	public static boolean isSelection(ButtonGroup buttonGroup) {
	    return (buttonGroup.getSelection() == null);
	}
}