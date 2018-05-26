package com.alisure.tool.core.common;

import com.alisure.tool.core.CoreFile;
import com.alisure.tool.core.CoreSystemProperty;
import com.alisure.tool.core.CoreTime;

import java.io.IOException;

/**
 * 
 * ���ڼ�¼��־
 * 
 * @author ALISURE
 * @version 1507
 *
 */
public class CommonLog {
	
	private final static String head = "ALISURE-LOG\n";
	private final static String division = "****************************************\n";
	private final static String division2 = "---------------------------\n";
	private final static String line = "\n";
	private final static String division3 = "------------------------------------------------------\n";
	private final static String pathAndFileName1 = CoreSystemProperty.userDir()+"/log/alisure.log";
	private final static String time = "Time:";
	
	/**
	 * ��ȡĬ��·��
	 * @return
	 */
	public static String getDefaultFilePath(){
		return pathAndFileName1;
	}
	
	private static void creatAlisureLog(String pathAndFileName) throws IOException,Exception {
		if (!CoreFile.isExists(pathAndFileName)) {
			CoreFile.newFullPathAndFileName(pathAndFileName);
			CoreFile.appendFile(pathAndFileName,
					head + division + CoreTime.getDataTime()+line+division+
					CoreSystemProperty.getSystemProperty(CoreSystemProperty.Line_Separator));
		}
	}
	
	/**
	 * ����Ϣд��Ĭ����־�ļ����������ڸ��ļ����½�
	 * @param filePathAndName
	 * @param content
	 */
	public static void writeAlisureLog(String content) throws Exception {
		writeAlisureLog(pathAndFileName1, content,null,null);
	}
	
	/**
	 * ����Ϣд��ָ����־�ļ����������ڸ��ļ����½�
	 * @param filePathAndName
	 * @param content
	 */
	public static void writeAlisureLog(String pathAndFileName,String content) throws Exception {
		writeAlisureLog(pathAndFileName, content, null, null);
	}
	
	public static void writeAlisureLog(String pathAndFileName,String content,String[] place) throws Exception {
		writeAlisureLog(pathAndFileName, content, place, null);
	}
	
	public static void writeAlisureLog(String pathAndFileName,String content,String[] place,String other) throws Exception {
		String write = division3 + time + CoreTime.getDataTime()+line;
		write += division2;
		write += content+line;
		if (other != null) {
			write += division2 + other + line;
		}
		if (place != null) {
			write += division2;
			write += "className:  "+place[0]+line;
			write += "methodName: "+place[1]+line;
			write += "lineNumber: "+place[2]+line;
		}
		write += division3;
		creatAlisureLog(pathAndFileName);
		CoreFile.appendFile(pathAndFileName, write);
	}
	
	/**
	 * ɾ��Ĭ����־�ļ�
	 * @param filePathAndName
	 */
	public static void deleteAlisureLog() throws Exception {
		CoreFile.delFile(pathAndFileName1);
	}
	
	/**
	 * ɾ����־�ļ�
	 * @param pathAndFileName
	 */
	public static void deleteAlisureLog(String pathAndFileName) throws Exception {
		if (pathAndFileName.endsWith(".log")) CoreFile.delFile(pathAndFileName);
	}

}
