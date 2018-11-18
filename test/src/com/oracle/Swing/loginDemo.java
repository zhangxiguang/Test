package com.oracle.Swing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class loginDemo extends JFrame {
	private JLabel usernameLabel, passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton login,register;
	private JCheckBox rememberpassword;
	private JRadioButton autologin,notautologin;
	private JToggleButton statues;

	public loginDemo() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("��Ѹ2018");
		this.setLayout(null);
//		this.setLayout();
		initComponent();
		this.paintComponents(this.getGraphics());// ����������֮��ִ�д�����Ⱦ
	}

	public void initComponent() {
		usernameLabel = new JLabel("�û���:");
		usernameLabel.setBounds(100, 50, 70, 25);
		this.add(usernameLabel);

		username = new JTextField();
		username.setBounds(160, 50, 100, 25);
		this.add(username);

		passwordLabel = new JLabel("��    ��:");
		passwordLabel.setBounds(100, 90, 70, 25);
		this.add(passwordLabel);
		
		password = new JPasswordField();
		password.setBounds(160, 90, 100, 25);
		this.add(password);
		
		login=new JButton("��½");
		login.setBounds(120, 130, 60, 30);
		this.add(login);
		
		register=new JButton("ע��");
		register.setBounds(190, 130, 60, 30);
		this.add(register);
		
		rememberpassword=new JCheckBox("��ס����");
		rememberpassword.setBounds(120, 170, 90, 25);
		this.add(rememberpassword);
		
		autologin=new JRadioButton("auto");
		autologin.setBounds(120, 195, 60, 25);
		this.add(autologin);
		
		notautologin=new JRadioButton("auto");
		notautologin.setBounds(190, 195, 60, 25);
		this.add(notautologin);

		statues=new JToggleButton("statues");
		statues.setBounds(120, 220, 90, 25);
		this.add(statues);
		
	}

	public static void main(String[] args) {
		loginDemo login = new loginDemo();
	}
}
