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
		//userJPanel.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		userJPanel.setOpaque(false);//设置背景透明
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);


		pictureJLabel = new JLabel();
		pictureJLabel.setBounds(45, 0, 380, 118);
		pictureJLabel.setIcon(new ImageIcon("pic.gif"));
		contentPane.add(pictureJLabel);
		
		CheckData = new JTextField(withoutCRC32);
		CheckData.setBounds(120, 30, 270, 35);
		userJPanel.add(CheckData);

		CheckData1 = new JLabel("需校验的数据：");
		CheckData1.setBounds(20, 30, 120, 35);
		userJPanel.add(CheckData1);

		CRC32Data = new JTextField();
		CRC32Data.setBounds(220, 80, 100, 35);
		userJPanel.add(CRC32Data);

		CRC32Data1 = new JLabel("生成的CRC32（八位十六进制）：");
		CRC32Data1.setBounds(20, 80,200, 35);
		userJPanel.add(CRC32Data1);
        
        
		okJButton = new JButton("生成TS");
		okJButton.setBounds(240, 260, 150, 45);
		okJButton.setContentAreaFilled(false);;  //此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		contentPane.add(okJButton);
		okJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				okJButtonActionPerformed(event);
			}
		});
		
		
		//背景图片
		 pictureJLabel=new JLabel();
         pictureJLabel.setBounds(-10,-10,650,433);
         pictureJLabel.setIcon(new ImageIcon(Config.class.getClassLoader().getResource(
                 "BackGroundCRC32.jpg")));
         contentPane.add(pictureJLabel); 

		setTitle("请填写CRC32");
		//setSize(380, 350);
		setBounds(600, 200, 650, 433);
		//this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // 将最大化按钮设置为不可用
		URL url = this.getClass().getResource("/o.png");
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(img);//设置窗口左上角图标
		Tray(url);//设置系统托盘图标
		
		return withoutCRC32;
	}

	private void Tray(URL Url) {
		if(SystemTray.isSupported()){//判断系统是否托盘  
		    //创建一个托盘图标对象  
		    TrayIcon icon1 = new TrayIcon(Toolkit.getDefaultToolkit().getImage(Url));  
		    //创建弹出菜单  
		    PopupMenu menu = new PopupMenu();  
		    //添加一个用于退出的按钮  
		    MenuItem item = new MenuItem("退出");  
		    item.addActionListener(new ActionListener() {  
		        public void actionPerformed(ActionEvent e) {  
		            System.exit(0);  
		        }  
		    });  
		    menu.add(item);  
		    //添加弹出菜单到托盘图标  
		    icon1.setPopupMenu(menu);  
		    SystemTray tray = SystemTray.getSystemTray();//获取系统托盘  
		    try {
				tray.add(icon1);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//将托盘图表添加到系统托盘  
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