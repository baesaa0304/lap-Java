package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblResult = new JLabel("입력하세요..");
		lblResult.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblResult.setBounds(12, 10, 618, 75);
		frame.getContentPane().add(lblResult);
		
		textInput = new JTextField();
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textInput.setBounds(12, 108, 606, 99);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(); // 내부 클래스에서 외부 클래스의 메서드를 호출할 수 있음.
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnInput.setBounds(12, 217, 606, 86);
		frame.getContentPane().add(btnInput);
	}

	private void handleButtonClick() {
		// JTectField 입력 내용을 읽음.
		String msg = textInput.getText();
		// 읽은 내용을  JLable에 씀.
		lblResult.setText(msg);
		// JTextField의 내용을 지움.
		textInput.setText("");
		
		
	}
}
