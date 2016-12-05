package CDT;


import java.util.zip.CRC32;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CdtSynthesis {

	static String Table_id = "80";//两个十六进制
	String Section_syntax_indicator = "1";//二进制
	String Reserved0 = "111";
	String Section_length = "000000000000";//十二位二进制，检测本表中以下数据包括crc的长度。高两位为“00”
	static String Reserved1 = "ffff";//四个十六进制
	String Reserved2 = "11";//两位二进制
	String Version_number = "00001";//五位二进制
	String Current_next_indicator = "1";//一位二进制
	static String Version = "C5";
	static String Section_number = "00";//两个十六进制
	static String Last_section_number = "00";//两个十六进制
	String Crc32 = "ffffffff";//八个十六进制
	private static Log logger = LogFactory.getLog("CdtSynthesis");
	
	@SuppressWarnings("unused")
	//合成Cdt_descriptor()
	private static String CdtDescriptor(String Descriptor_len,
			String manufacturer_id,String m_Hardware_Id,String Loader_version_major,String Loader_version_minor,
			String SoftVersionMajor,String SoftVersionMinor,String Redundant_download_frequency,
			String GroupID_Start,String GroupID_end,String download_frequency,String Download_Symb,
			String download_modulation,String download_pid,String Target_main_software,
			String Target_minor_software,String search_tag,String Download_type)
	{
		//Reserved = "ffffffffffff";
		//reserved = "ffff";
		String reserved1= "11111111111111111111111";//23位二进制
		String research = reserved1+search_tag;
		String Hexallpid = Integer.toHexString(Integer.valueOf(research, 2));// 十六位2进制转四位16进制
		String CdtDescrip = "81"+Descriptor_len+manufacturer_id+m_Hardware_Id+Loader_version_major+Loader_version_minor+
				SoftVersionMajor+SoftVersionMinor+Redundant_download_frequency+"000000000000"+GroupID_Start+GroupID_end+
				download_frequency+Download_Symb+download_modulation+download_pid+"ffff"+Target_main_software+
				Target_minor_software+Hexallpid+Download_type;
		
		return CdtDescrip;
		
	}
	
	
	@SuppressWarnings("unused")
	public static String CRC(String Descriptor_len,
			String manufacturer_id,String m_Hardware_Id,String Loader_version_major,String Loader_version_minor,
			String SoftVersionMajor,String SoftVersionMinor,String Redundant_download_frequency,
			String GroupID_Start,String GroupID_end,String download_frequency,String Download_Symb,
			String download_modulation,String download_pid,String Target_main_software,
			String Target_minor_software,String search_tag,String Download_type,String CdtVer)
	{
		String CdtDescriptor=CdtDescriptor(Descriptor_len, manufacturer_id, m_Hardware_Id, 
				Loader_version_major, Loader_version_minor, SoftVersionMajor, SoftVersionMinor, Redundant_download_frequency, 
				GroupID_Start, GroupID_end, download_frequency, Download_Symb, download_modulation, download_pid, Target_main_software, 
				Target_minor_software, search_tag, Download_type);
		String CRC = null;
		String CdtVersion = "";
		int CdtVerInt = 1;
		try {
		    CdtVerInt = Integer.parseInt(CdtVer);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		String CdtVerbin=Integer.toBinaryString(CdtVerInt);
		if (CdtVerbin.length()<5) {
			int B = CdtVerbin.length();
			for (int i = 1; i <= 5 - B; i++) {
				CdtVerbin = "0" + CdtVerbin;
			}
		}
		CdtVerbin = "11"+CdtVerbin+"1";
		CdtVersion = Long.toHexString(Long.parseLong(CdtVerbin, 2));
		CRC = Table_id+"B02E"+Reserved1+CdtVersion+Section_number+Last_section_number+CdtDescriptor;
		System.out.println("CRC=  "+CRC);
		logger.info("CRC==="+CRC);
		return CRC;
		
	}
	
	
	@SuppressWarnings("unused")
	//合成Cdt数据
	public static byte[] CdtTs(String CRC,String CRC32)
	{
		String Cdt = "475f401000"+CRC+CRC32;//合成除CRC32以外的Cdt数据
		System.out.println("CdtCrc32=   "+Cdt);
		logger.debug("CdtCrc32=   "+Cdt);
		//转换Byte数组
		byte[] itemBuf=new byte[188];
		byte[] bytes =new byte[Cdt.length()/2];
		int c=0;
		
		CDT:
		for (int j = 0; j < Cdt.length(); j++) {
			if (c<=Cdt.length()-1) {
				bytes[j]=(byte) Integer.parseInt(Cdt.substring(c, c+2),16);
				c=c+2;	
			}
			else {
				break CDT;
			}
					
		}  
		System.out.println("bytes.length=  "+bytes.length);
		logger.error("bytes.length=  "+bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			itemBuf[i]=bytes[i];
		}
		for (int i = bytes.length; i < itemBuf.length; i++) {
			itemBuf[i]=(byte) Integer.parseInt("ff",16);
		}
        System.out.println();
		return itemBuf;	
		
	}
	
	
	//计算CRC32
	public static byte[] hexStringToBytes(String hexString) {  //CRC32
	    if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }  
	    hexString = hexString.toUpperCase();  
	    int length = hexString.length() / 2;  
	    char[] hexChars = hexString.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	} 
	 private static byte charToByte(char c) {  
		    return (byte) "0123456789ABCDEF".indexOf(c);  
		} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Reserved = "ffffffffffff";
		byte[] itemBuf=new byte[188];
		byte[] bytes =new byte[Reserved.length()];
		for (int i = 0; i < Reserved.length(); i++) {
			bytes[i]=(byte) Integer.parseInt(String.valueOf(Reserved.charAt(i)),16);
		}  
		for (int i = 0; i < bytes.length; i++) {
			itemBuf[i]=bytes[i];
			System.out.println(itemBuf[i]);
			logger.debug(itemBuf[i]);
		}
        System.out.println(itemBuf);

	}

}
