package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {

	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblphone;
	private JLabel lblEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private ContactMain06 app; // notifiyContactCreated 메서드를 가지고 있는 객체.

	/**
	 * Launch the application.
	 */
	public static void showContactCreatFrame (Component parent , ContactMain06 app) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactCreateFrame(Component parent , ContactMain06 app) {
		this.parent = parent; 
		this.app = app;
		initialize(); // GUI 컴포넌트들을 생성하고 초기화
	}
	
	public void initialize() {
		setTitle("새 연락처 저장");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기(x) 버튼의 기본 동작을 현재 창만 닫기(dispose)로 설정.
		
		// JFarem이 화면에 보이는 좌표.
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX(); 
			y = parent.getY();
		}
		setBounds(x, y, 450, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblName.setBounds(12, 10, 100, 53);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.BOLD, 20));
		textName.setBounds(124, 10, 288, 53);
		panel.add(textName);
		textName.setColumns(10);
		
		lblphone = new JLabel("전화번호");
		lblphone.setHorizontalAlignment(SwingConstants.CENTER);
		lblphone.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblphone.setBounds(12, 89, 100, 53);
		panel.add(lblphone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.BOLD, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(124, 89, 288, 53);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblEmail.setBounds(12, 166, 100, 53);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(124, 166, 288, 53);
		panel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("저장");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creatNewContact();
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.BOLD, 23));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 23));
		buttonPanel.add(btnCancel);
	}

	private void creatNewContact() {
		// JTextField에서 이름/ 전화번호/이메일 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// Contact 타입 객체 생성.
		Contact contact = new Contact(0 , name, phone, email);
		
		// 리스트에 추가. 파일 업데이트. - > DAO
		dao.create(contact);
		
		// ContactMain에게 새 연락처가 저장됐다고 알려줌.
		app.notifyContactCreated();
		
		
		// 현재 창 닫기
		dispose();
		
	}
}
