package GHCdt;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import org.junit.Test;



public class Config extends JFrame {

	private JPanel userJPanel,userJPanel1;
	private JButton okJButton;
	private JLabel path1,Descriptor_len1,manufacturer_id1,m_Hardware_Id1,Loader_version_major1,Loader_version_minor1,SoftVersionMajor1,SoftVersionMinor1,Redundant_download_frequency1,GroupID_Start1,GroupID_end1,download_frequency1,Download_Symb1,download_modulation1,download_pid1,Target_main_software1,Target_minor_software1,search_tag1,Download_type1,CDTVer1;
	private JLabel path2,Descriptor_len2,manufacturer_id2,m_Hardware_Id2,Loader_version_major2,Loader_version_minor2,SoftVersionMajor2,SoftVersionMinor2,Redundant_download_frequency2,GroupID_Start2,GroupID_end2,download_frequency2,Download_Symb2,download_modulation2,download_pid2,Target_main_software2,Target_minor_software2,search_tag2,Download_type2,CDTVer2;
	private JTextField path,Descriptor_len,manufacturer_id,m_Hardware_Id,Loader_version_major,Loader_version_minor,SoftVersionMajor,SoftVersionMinor,Redundant_download_frequency,GroupID_Start,GroupID_end,download_frequency,Download_Symb,download_modulation,download_pid,Target_main_software,Target_minor_software,search_tag,Download_type,CDTVer;
	private JLabel pictureJLabel,LogoJLabel;
	ImageIcon image;
	
	public Config() {
		createUserInterface(); // 调用创建用户界面方法

	}

	/**
	 * 
	 */
	/**
	 * 
	 */
	private void createUserInterface() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		 pictureJLabel=new JLabel();
         pictureJLabel.setBounds(570,0,380,118);
         pictureJLabel.setIcon(new ImageIcon(Config.class.getClassLoader().getResource(
                 "pic.gif")));
         contentPane.add(pictureJLabel); 

         
         LogoJLabel=new JLabel();
         LogoJLabel.setBounds(70,-10,400,118);
         LogoJLabel.setText("CDT合成工具 - V1.2");
         LogoJLabel.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,44));
         LogoJLabel.setForeground(Color.BLUE);
         contentPane.add(LogoJLabel); 
         
		userJPanel = new JPanel();
		userJPanel.setBounds(45, 100, 600, 350);
		//userJPanel.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		//userJPanel.setBackground(Color.yellow);
		userJPanel.setOpaque(false);//设置背景透明
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);
		
		userJPanel1 = new JPanel();
		userJPanel1.setBounds(645, 100, 600, 350);
		//userJPanel1.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		//userJPanel.setBackground(Color.yellow);
		userJPanel1.setOpaque(false);//设置背景透明
		userJPanel1.setLayout(null);
		contentPane.add(userJPanel1);
		
		path = new JTextField();
		path.setBounds(150, 30, 170, 30);
		userJPanel.add(path);

		path1 = new JLabel("生成的ts文件路径：");
		path1.setBounds(20, 30, 300, 25);
		path2 = new JLabel(" ( 如：E://1.ts )");
		path2.setBounds(330, 30, 250, 25);
		userJPanel.add(path1);
		userJPanel.add(path2);

		CDTVer = new JTextField("25");
		CDTVer.setBounds(150, 60, 170, 30);
		userJPanel.add(CDTVer);
		
		CDTVer1 = new JLabel("CDT版本号：");
		CDTVer1.setBounds(20, 60, 300, 25);
		CDTVer2 = new JLabel(" 请输入1-31的十进制版本号，如：25");
		CDTVer2.setBounds(330, 60, 250, 25);
		userJPanel.add(CDTVer1);
		userJPanel.add(CDTVer2);
		
		Descriptor_len = new JTextField("23");
		Descriptor_len.setBounds(150, 90, 170, 30);
		userJPanel.add(Descriptor_len);

		Descriptor_len1 = new JLabel("描述符内容长度：");
		Descriptor_len1.setBounds(20, 90, 300, 35);
		Descriptor_len2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Descriptor_len2.setBounds(330, 90, 250, 25);
		userJPanel.add(Descriptor_len1);
		userJPanel.add(Descriptor_len2);

		manufacturer_id = new JTextField("0b");
		manufacturer_id.setBounds(150, 120, 170, 30);
		//manufacturer_id.setFont(new Font("宋体", Font.BOLD, 60));
		userJPanel.add(manufacturer_id);
		
		manufacturer_id1 = new JLabel("厂商号：");
		manufacturer_id1.setBounds(20, 120, 800, 35);
		manufacturer_id2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		manufacturer_id2.setBounds(330, 120, 250, 25);
		userJPanel.add(manufacturer_id1);
		userJPanel.add(manufacturer_id2);
		
		m_Hardware_Id = new JTextField("01");
		m_Hardware_Id.setBounds(150, 150, 170, 30);
		userJPanel.add(m_Hardware_Id);
		
		m_Hardware_Id1 = new JLabel("硬件版本号：");
		m_Hardware_Id1.setBounds(20, 150, 800, 35);
		m_Hardware_Id2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		m_Hardware_Id2.setBounds(330, 150, 250, 25);
		userJPanel.add(m_Hardware_Id1);
		userJPanel.add(m_Hardware_Id2);
		
		Loader_version_major = new JTextField();
		Loader_version_major.setBounds(150, 180, 170, 30);
		userJPanel.add(Loader_version_major);
		
		Loader_version_major1 = new JLabel("Loader主版本号：");
		Loader_version_major1.setBounds(20, 180, 800, 35);
		Loader_version_major2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Loader_version_major2.setBounds(330, 180, 250, 25);
		userJPanel.add(Loader_version_major1);
		userJPanel.add(Loader_version_major2);
		
		Loader_version_minor = new JTextField();
		Loader_version_minor.setBounds(150, 210, 170, 30);
		userJPanel.add(Loader_version_minor);
		
		Loader_version_minor1 = new JLabel("Loader次版本号：");
		Loader_version_minor1.setBounds(20, 210, 800, 35);
		Loader_version_minor2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Loader_version_minor2.setBounds(330, 210, 250, 25);
		userJPanel.add(Loader_version_minor1);
		userJPanel.add(Loader_version_minor2);
		

		SoftVersionMajor = new JTextField();
		SoftVersionMajor.setBounds(150, 240, 170, 30);
		userJPanel.add(SoftVersionMajor);
		
		SoftVersionMajor1 = new JLabel("软件主版本号：");
		SoftVersionMajor1.setBounds(20, 240, 800, 35);
		SoftVersionMajor2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		SoftVersionMajor2.setBounds(330, 240, 250, 25);
		userJPanel.add(SoftVersionMajor1);
		userJPanel.add(SoftVersionMajor2);
		

		SoftVersionMinor = new JTextField();
		SoftVersionMinor.setBounds(150, 270, 170, 30);
		userJPanel.add(SoftVersionMinor);
		
		SoftVersionMinor1 = new JLabel("软件次版本号：");
		SoftVersionMinor1.setBounds(20, 270, 800, 35);
		SoftVersionMinor2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		SoftVersionMinor2.setBounds(330, 270, 250, 25);
		userJPanel.add(SoftVersionMinor1);
		userJPanel.add(SoftVersionMinor2);
		

		Redundant_download_frequency = new JTextField();
		Redundant_download_frequency.setBounds(150, 300, 170, 30);
		userJPanel.add(Redundant_download_frequency);
		
		Redundant_download_frequency1 = new JLabel("备用下载频率：");
		Redundant_download_frequency1.setBounds(20, 300, 800, 35);
		Redundant_download_frequency2 = new JLabel(" ( 输入六个十六进制，如：0000aa )");
		Redundant_download_frequency2.setBounds(330, 300, 250, 25);
		userJPanel.add(Redundant_download_frequency1);
		userJPanel.add(Redundant_download_frequency2);
		
		
		GroupID_Start = new JTextField("0000");
		GroupID_Start.setBounds(150, 30, 170, 30);
		userJPanel1.add(GroupID_Start);
		
		GroupID_Start1 = new JLabel("开始NodeGroupID号：");
		GroupID_Start1.setBounds(20, 30, 800, 35);
		GroupID_Start2 = new JLabel(" ( 输入四个十六进制，如：00aa )");
		GroupID_Start2.setBounds(330, 30, 250, 25);
		userJPanel1.add(GroupID_Start1);
		userJPanel1.add(GroupID_Start2);
		
		
		GroupID_end = new JTextField("ffff");
		GroupID_end.setBounds(150, 60, 170, 30);
		userJPanel1.add(GroupID_end);
		
		GroupID_end1 = new JLabel("结束NodeGroupID号：");
		GroupID_end1.setBounds(20, 60, 800, 35);
		GroupID_end2 = new JLabel(" ( 输入四个十六进制，如：00aa )");
		GroupID_end2.setBounds(330, 60, 250, 25);
		userJPanel1.add(GroupID_end1);
		userJPanel1.add(GroupID_end2);
		
		
		download_frequency = new JTextField();
		download_frequency.setBounds(150, 90, 170, 30);
		userJPanel1.add(download_frequency);
		
		download_frequency1 = new JLabel("主用下载频率：");
		download_frequency1.setBounds(20, 90, 800, 35);
		download_frequency2 = new JLabel(" ( 输入六个十六进制，如：0000aa )");
		download_frequency2.setBounds(330, 90, 250, 25);
		userJPanel1.add(download_frequency1);
		userJPanel1.add(download_frequency2);
		
		
		Download_Symb = new JTextField("1adb");
		Download_Symb.setBounds(150, 120, 170, 30);
		userJPanel1.add(Download_Symb);
		
		Download_Symb1 = new JLabel("下载符号率：");
		Download_Symb1.setBounds(20, 120, 800, 35);
		Download_Symb2 = new JLabel(" ( 输入四个十六进制，如：00aa )");
		Download_Symb2.setBounds(330, 120, 250, 25);
		userJPanel1.add(Download_Symb1);
		userJPanel1.add(Download_Symb2);
		
		
		download_modulation = new JTextField("03");
		download_modulation.setBounds(150, 150, 170, 30);
		userJPanel1.add(download_modulation);
		
		download_modulation1 = new JLabel("调制方式：");
		download_modulation1.setBounds(20, 150, 800, 35);
		download_modulation2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		download_modulation2.setBounds(330, 150, 250, 25);
		userJPanel1.add(download_modulation1);
		userJPanel1.add(download_modulation2);
		
		
		download_pid = new JTextField();
		download_pid.setBounds(150, 180, 170, 30);
		userJPanel1.add(download_pid);
		
		download_pid1 = new JLabel("升级流PID：");
		download_pid1.setBounds(20, 180, 800, 35);
		download_pid2 = new JLabel(" ( 输入四个十六进制，如：00aa )");
		download_pid2.setBounds(330, 180, 250, 25);
		userJPanel1.add(download_pid1);
		userJPanel1.add(download_pid2);
		
		
		Target_main_software = new JTextField();
		Target_main_software.setBounds(150, 210, 170, 30);
		userJPanel1.add(Target_main_software);
		
		Target_main_software1 = new JLabel("目标软件主版本号：");
		Target_main_software1.setBounds(20, 210, 800, 35);
		Target_main_software2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Target_main_software2.setBounds(330, 210, 250, 25);
		userJPanel1.add(Target_main_software1);
		userJPanel1.add(Target_main_software2);
		
		
		Target_minor_software = new JTextField();
		Target_minor_software.setBounds(150, 240, 170, 30);
		userJPanel1.add(Target_minor_software);
		
		Target_minor_software1 = new JLabel("目标软件次版本号：");
		Target_minor_software1.setBounds(20, 240, 800, 35);
		Target_minor_software2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Target_minor_software2.setBounds(330, 240, 250, 25);
		userJPanel1.add(Target_minor_software1);
		userJPanel1.add(Target_minor_software2);
		
		
		search_tag = new JTextField();
		search_tag.setBounds(150, 270, 170, 30);
		userJPanel1.add(search_tag);
		
		search_tag1 = new JLabel("扫台标记：");
		search_tag1.setBounds(20, 270, 800, 35);
		search_tag2 = new JLabel(" ( 输入一个二进制，0或1 )");
		search_tag2.setBounds(330, 270, 250, 25);
		userJPanel1.add(search_tag1);
		userJPanel1.add(search_tag2);
		
		
		Download_type = new JTextField();
		Download_type.setBounds(150, 300, 170, 30);
		userJPanel1.add(Download_type);
		
		Download_type1 = new JLabel("下载类型：");
		Download_type1.setBounds(20, 300, 800, 35);
		Download_type2 = new JLabel(" ( 输入两个十六进制，如：aa )");
		Download_type2.setBounds(330, 300, 250, 25);
		userJPanel1.add(Download_type1);
		userJPanel1.add(Download_type2);	

		okJButton = new JButton("CRC32校验");
		okJButton.setBounds(490, 460, 310, 60);
		okJButton.setContentAreaFilled(false);;  //此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		//okJButton.setIcon(new ImageIcon("bin/filechooser/image/rec.gif"));
		contentPane.add(okJButton);
		okJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				okJButtonActionPerformed(event);
			}
		});

		//背景图片
		 pictureJLabel=new JLabel();
         pictureJLabel.setBounds(0,0,1300,600);
         pictureJLabel.setIcon(new ImageIcon(Config.class.getClassLoader().getResource(
                 "BackGroundConfig.jpg")));
         contentPane.add(pictureJLabel); 
         
        ImageIcon icon=new ImageIcon("pic.gif");
        setIconImage(icon.getImage());
		setTitle("请填写配置信息");
		//setSize(380, 350);
		setBounds(300, 150, 1300, 600);
		//this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // 将最大化按钮设置为不可用
		URL url = this.getClass().getResource("/o.png");
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(img);//设置窗口左上角图标
		Tray(url);//设置系统托盘图标
		
		
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
		String WithoutCRC32 = "" ; 
		WithoutCRC32 = CDT.CdtSynthesis.CRC(Descriptor_len.getText(), manufacturer_id.getText(), m_Hardware_Id.getText(), Loader_version_major.getText(), Loader_version_minor.getText(), SoftVersionMajor.getText(), SoftVersionMinor.getText(), Redundant_download_frequency.getText(), GroupID_Start.getText(), GroupID_end.getText(), download_frequency.getText(), Download_Symb.getText(), download_modulation.getText(), download_pid.getText(), Target_main_software.getText(), Target_minor_software.getText(), search_tag.getText(), Download_type.getText(),CDTVer.getText());
		CRC32 CRC32 = new CRC32(path.getText(),WithoutCRC32);
		CRC32.setVisible(true);
		//CRC32.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// okJButton响应事件
		
	}


	public static void main(String[] args) {
		//JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		Config mylogin = new Config();
		mylogin.setVisible(true);
		mylogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}