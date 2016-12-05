package GHCdt;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import CDT.CdtWrite;



public class CRC32 extends JFrame {
	//private JComboBox nameJComboBox;
	private JPanel userJPanel;
	private JLabel pictureJLabel;
	private JButton okJButton, cancelJButton;
	private JLabel CheckData1,CRC32Data1;
	private JTextField CheckData,CRC32Data;

	private static String name1;
	private String password1;
	private String user;
	
	private String use="aaa";
	
	private ImageIcon myImageIcon;
	

	public CRC32(String path, String withoutCRC32) {
		createUserInterface(withoutCRC32,path);
		// TODO Auto-generated constructor stub
	}


	String CRC;
	String s_FilePath;
	private String createUserInterface(String withoutCRC32,String path) {
		CRC=withoutCRC32;
		s_FilePath= path;
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		userJPanel = new JPanel();
		userJPanel.setBounds(105, 110, 400, 150);
		//userJPanel.setBackground(Color.yellow);
		//userJPanel.setBorder(BorderFactory.createEtchedBorder()); // ��ʾһȦ�߶�
		userJPanel.setOpaque(false);//���ñ���͸��
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);


		pictureJLabel = new JLabel();
		pictureJLabel.setBounds(45, 0, 380, 118);
		pictureJLabel.setIcon(new ImageIcon("pic.gif"));
		contentPane.add(pictureJLabel);
		
		CheckData = new JTextField(withoutCRC32);
		CheckData.setBounds(120, 30, 270, 35);
		userJPanel.add(CheckData);

		CheckData1 = new JLabel("��У������ݣ�");
		CheckData1.setBounds(20, 30, 120, 35);
		userJPanel.add(CheckData1);

		CRC32Data = new JTextField();
		CRC32Data.setBounds(220, 80, 100, 35);
		userJPanel.add(CRC32Data);

		CRC32Data1 = new JLabel("���ɵ�CRC32����λʮ�����ƣ���");
		CRC32Data1.setBounds(20, 80,200, 35);
		userJPanel.add(CRC32Data1);
        
        
		okJButton = new JButton("����TS");
		okJButton.setBounds(240, 260, 150, 45);
		okJButton.setContentAreaFilled(false);;  //����ɫֵ������ã�ֻ��ռλ���ã����Ǳ�����ϴ˾䣬���򲻻����͸������Ч����
		contentPane.add(okJButton);
		okJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				okJButtonActionPerformed(event);
			}
		});
		
		
		//����ͼƬ
		 pictureJLabel=new JLabel();
         pictureJLabel.setBounds(-10,-10,650,433);
         pictureJLabel.setIcon(new ImageIcon(Config.class.getClassLoader().getResource(
                 "BackGroundCRC32.jpg")));
         contentPane.add(pictureJLabel); 

		setTitle("����дCRC32");
		//setSize(380, 350);
		setBounds(600, 200, 650, 433);
		//this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // ����󻯰�ť����Ϊ������
		URL url = this.getClass().getResource("/o.png");
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(img);//���ô������Ͻ�ͼ��
		Tray(url);//����ϵͳ����ͼ��
		
		return withoutCRC32;
	}

	private void Tray(URL Url) {
		if(SystemTray.isSupported()){//�ж�ϵͳ�Ƿ�����  
		    //����һ������ͼ�����  
		    TrayIcon icon1 = new TrayIcon(Toolkit.getDefaultToolkit().getImage(Url));  
		    //���������˵�  
		    PopupMenu menu = new PopupMenu();  
		    //���һ�������˳��İ�ť  
		    MenuItem item = new MenuItem("�˳�");  
		    item.addActionListener(new ActionListener() {  
		        public void actionPerformed(ActionEvent e) {  
		            System.exit(0);  
		        }  
		    });  
		    menu.add(item);  
		    //��ӵ����˵�������ͼ��  
		    icon1.setPopupMenu(menu);  
		    SystemTray tray = SystemTray.getSystemTray();//��ȡϵͳ����  
		    try {
				tray.add(icon1);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//������ͼ����ӵ�ϵͳ����  
		}
		
	}
	
	
	private void okJButtonActionPerformed(ActionEvent event) {
		byte[] bytes = CDT.CdtSynthesis.CdtTs(CRC, CRC32Data.getText());
		CdtWrite Wri = new CdtWrite(s_FilePath);
		Wri.CdtWriteBinaryStream(bytes);
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

}