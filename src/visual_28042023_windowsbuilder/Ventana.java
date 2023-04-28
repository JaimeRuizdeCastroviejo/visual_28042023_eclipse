package visual_28042023_windowsbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 41, 133, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 15, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("....");
		lblNewLabel.setBounds(21, 46, 89, 14);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("Haz click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(textField.getText());
			}
		});
		btnNewButton.setBounds(21, 126, 89, 23);
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBounds(232, 41, 155, 185);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 23, 135, 14);
		panel_1.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Conectar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registar el conetor
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost/test";
					Connection conn = DriverManager.getConnection(url,"root","");
					//lblNewLabel_1.setText(conn.toString());
					
					//Consulta. CRUD
					PreparedStatement ps = conn.prepareStatement("select * from clientes");
					ResultSet rs = ps.executeQuery();
					//lblNewLabel_1.setText(rs.toString());
					StringBuilder  sb= new StringBuilder();
					while(rs.next()) {
						sb.append(rs.getString(2));
					}
					lblNewLabel_1.setText(sb.toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}//cierra el metodo
		});
		btnNewButton_1.setBounds(30, 123, 89, 23);
		panel_1.add(btnNewButton_1);
				
		
		 
		
	
	
	}
}
