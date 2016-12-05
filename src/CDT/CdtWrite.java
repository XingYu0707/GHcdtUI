package CDT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CdtWrite {

	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	private byte[] m_datapadding = { 0x00 }; //Ìî³ä¿Õ°×£¬ÒÔ²¹×ã×Ö½ÚÎ»Êý.
	public CdtWrite(String s_FilePath) {
		// TODO Auto-generated constructor stub
		init(s_FilePath);
	}

	private void init(String s_FilePath) {
		try {
			if (!new File(s_FilePath).exists()) {
				new File(s_FilePath).createNewFile();
			}
			dis = new DataInputStream(new FileInputStream(new File(s_FilePath)));
			dos = new DataOutputStream(new FileOutputStream(new File(s_FilePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  boolean CdtWriteBinaryStream(byte[] bytes) {
		
		final int MAX = 150000000;

		try {
			if (dos != null) {
				
					dos.write(bytes); 	                 
					dos.write(m_datapadding);  

					dos.close();
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
		
		
	}

	public void readBinaryStream() {
		try {
			if (dis != null) {
				while (dis.available() > 0) {					
					System.out.println(dis.readInt());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
