package toOOP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.nio.channels.ShutdownChannelGroupException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Form {

	private JFrame frame;
	private JTextField textFieldFaculty;
	private JTextField textFieldSpecialuty;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConnectionToSQL connect = new ConnectionToSQL();
		conn = connect.connect();
		frame = new JFrame();
		frame.setTitle(
				"\u0420\u043E\u0437\u0440\u043E\u0431\u043B\u0435\u043D\u043D\u044F \u041F\u0421 \u0437 \u043E\u0431\u043B\u0456\u043A\u0443 \u0441\u0442\u0443\u0434\u0435\u043D\u0442\u0456\u0432 \u0437\u0430 \u043A\u043E\u043D\u0442\u0440\u0430\u043A\u0442\u043E\u043C");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 717, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel nazva = new JLabel(
				"\u0417\u0430\u043F\u043E\u0432\u043D\u0456\u0442\u044C \u0432\u0456\u0434\u043F\u043E\u0432\u0456\u0434\u043D\u0456 \u043A\u0440\u0438\u0442\u0435\u0440\u0456\u0457 \u0449\u043E\u0434\u043E \u0432\u0430\u0448\u043E\u0433\u043E \u0437\u0430\u043F\u0438\u0442\u0443");
		nazva.setForeground(Color.LIGHT_GRAY);
		nazva.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nazva.setHorizontalAlignment(SwingConstants.CENTER);
		nazva.setBounds(10, 6, 675, 36);
		frame.getContentPane().add(nazva);

		JLabel lblFaculty = new JLabel("\u0424\u0430\u043A\u0443\u043B\u044C\u0442\u0435\u0442");
		lblFaculty.setForeground(SystemColor.menuText);
		lblFaculty.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblFaculty.setBounds(20, 53, 155, 27);
		frame.getContentPane().add(lblFaculty);

		textFieldFaculty = new JTextField();
		textFieldFaculty.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldFaculty.setToolTipText("");
		textFieldFaculty.setBounds(21, 91, 600, 27);
		frame.getContentPane().add(textFieldFaculty);
		textFieldFaculty.setColumns(10);

		JLabel lblSpecialuty = new JLabel(
				"\u0421\u043F\u0435\u0446\u0456\u0430\u043B\u044C\u043D\u0456\u0441\u0442\u044C");
		lblSpecialuty.setForeground(SystemColor.menuText);
		lblSpecialuty.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblSpecialuty.setBounds(20, 129, 155, 27);
		frame.getContentPane().add(lblSpecialuty);

		textFieldSpecialuty = new JTextField();
		textFieldSpecialuty.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldSpecialuty.setBounds(21, 167, 600, 27);
		frame.getContentPane().add(textFieldSpecialuty);
		textFieldSpecialuty.setColumns(10);

		JLabel lblFormOfStudy = new JLabel(
				"\u0424\u043E\u0440\u043C\u0430 \u043D\u0430\u0432\u0447\u0430\u043D\u043D\u044F");
		lblFormOfStudy.setForeground(SystemColor.menuText);
		lblFormOfStudy.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblFormOfStudy.setBounds(20, 216, 170, 27);
		frame.getContentPane().add(lblFormOfStudy);

		JRadioButton rdbtnDenna = new JRadioButton("\u0434\u0435\u043D\u043D\u0430");
		rdbtnDenna.setForeground(SystemColor.menuText);
		rdbtnDenna.setSelected(true);
		buttonGroup.add(rdbtnDenna);
		rdbtnDenna.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		rdbtnDenna.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnDenna.setBounds(20, 250, 79, 43);
		
		JRadioButton rdbtnDistanciyna = new JRadioButton("\u0434\u0438\u0441\u0442\u0430\u043D\u0446\u0456\u0439\u043D\u0430");
		buttonGroup.add(rdbtnDistanciyna);
		rdbtnDistanciyna.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnDistanciyna.setBounds(198, 250, 130, 43);
		frame.getContentPane().add(rdbtnDistanciyna);

		frame.getContentPane().add(rdbtnDenna);
		JComboBox comboBoxCourse = new JComboBox();
		comboBoxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBoxCourse.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] { "\u043F\u0435\u0440\u0448\u0438\u0439",
				"\u0434\u0440\u0443\u0433\u0456\u0439", "\u0442\u0440\u0435\u0442\u0456\u0439",
				"\u0447\u0435\u0442\u0432\u0435\u0440\u0442\u0438\u0439", "\u043F'\u044F\u0442\u0438\u0439",
				"\u0448\u043E\u0441\u0442\u0438\u0439" }));
		comboBoxCourse.setSelectedIndex(0);
		comboBoxCourse.setBounds(494, 258, 115, 27);
		frame.getContentPane().add(comboBoxCourse);

		JRadioButton rdbtnZaochna = new JRadioButton("\u0437\u0430\u043E\u0447\u043D\u0430");
		rdbtnZaochna.setForeground(SystemColor.menuText);
		buttonGroup.add(rdbtnZaochna);
		rdbtnZaochna.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		rdbtnZaochna.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnZaochna.setBounds(101, 250, 85, 43);
		frame.getContentPane().add(rdbtnZaochna);

		JButton Result = new JButton("\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u0432 \u0444\u043E\u0440\u043C\u0443");
		Result.setBackground(SystemColor.activeCaption);
		Result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ConnectionToSQL connect = new ConnectionToSQL();
				// connect.connect();
				// connect.statement();

				try {
					//String tester = "";
					// String faculty = textFieldFaculty.getText();
					// String speciality = textFieldSpecialuty.getText();
					// int course = comboBoxCourse.getSelectedIndex() + 1;
					String formOfStudy = "";
					if (rdbtnDenna.isSelected()) {
						formOfStudy = "денна";
					} else if(rdbtnZaochna.isSelected()){
						formOfStudy = "заочна";
					}else {
						formOfStudy = "дистанційна";
					}
					PreparedStatement prst = conn.prepareStatement(
							"SELECT * FROM student.info where Form_of_study = ? and Cours = ? and (Faculty = ? or Speciality = ?) ");
					prst.setString(3, textFieldFaculty.getText());
					prst.setString(4, textFieldSpecialuty.getText());
					prst.setLong(2, comboBoxCourse.getSelectedIndex() + 1);
					prst.setString(1, formOfStudy);

					ResultSet rs = prst.executeQuery();
					
					System.out.println("One");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					prst.close();
					rs.close();

					// if ((faculty.contentEquals(tester)) &&
					// (speciality.contentEquals(tester))) {
					// connect.preparedStatement(course, formOfStudy);
					// } else if ((speciality.contentEquals(tester))) {
					// connect.preparedStatement(faculty, course, formOfStudy);
					// } else if ((faculty.contentEquals(tester))) {
					// connect.preparedStatement(speciality, course,
					// formOfStudy);
					// } else {
					// connect.preparedStatement(faculty, speciality, course,
					// formOfStudy);
					// }
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Input valid arguments ");
					e.printStackTrace();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "SQL Exception");
					e2.printStackTrace();
				}

			}
		});
		Result.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Result.setBounds(10, 547, 252, 41);
		frame.getContentPane().add(Result);

		JButton Exit = new JButton("\u0412\u0438\u0445\u0456\u0434");
		Exit.setBackground(SystemColor.inactiveCaption);
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Exit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Exit.setBounds(569, 547, 122, 41);
		frame.getContentPane().add(Exit);

		JButton btnReset = new JButton("\u0421\u0442\u0435\u0440\u0442\u0438");
		btnReset.setBackground(SystemColor.activeCaption);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFaculty.setText(null);
				comboBoxCourse.setSelectedIndex(0);
				textFieldSpecialuty.setText(null);
				rdbtnDenna.setSelected(true);
				rdbtnZaochna.setSelected(false);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(272, 547, 122, 41);
		frame.getContentPane().add(btnReset);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		separator.setForeground(Color.GREEN);
		separator.setBounds(10, 313, 675, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GREEN);
		separator_1.setForeground(Color.GREEN);
		separator_1.setBounds(10, 45, 675, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.GREEN);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 45, 1, 270);
		frame.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.GREEN);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(684, 45, 1, 270);
		frame.getContentPane().add(separator_3);

		JLabel labelCourse = new JLabel("\u041A\u0443\u0440\u0441");
		labelCourse.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelCourse.setBounds(494, 214, 79, 29);
		frame.getContentPane().add(labelCourse);

		JButton btnNewButton = new JButton("\u0414\u0456\u0457 \u0437 \u0411\u0414");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditFrame edit = new EditFrame();
				frame.dispose();
				edit.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(404, 546, 155, 43);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPaneResult = new JScrollPane();
		scrollPaneResult.setBounds(10, 326, 681, 212);
		frame.getContentPane().add(scrollPaneResult);

		table = new JTable();
		scrollPaneResult.setViewportView(table);
		
		JButton btnResultCons = new JButton("\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u0432 \u043A\u043E\u043D\u0441\u043E\u043B\u044C");
		btnResultCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionToSQL connect = new ConnectionToSQL();
				connect.connect();
				connect.statement();

				try {
					String tester = "";
					String faculty = textFieldFaculty.getText();
					 String speciality = textFieldSpecialuty.getText();
					 int course = comboBoxCourse.getSelectedIndex() + 1;
					String formOfStudy = "";
					if (rdbtnDenna.isSelected()) {
						formOfStudy = "денна";
					} else if(rdbtnZaochna.isSelected()){
						formOfStudy = "заочна";
					}else {
						formOfStudy = "дистанційна";
					}
				if ((faculty.contentEquals(tester)) &&
				 (speciality.contentEquals(tester))) {
				 connect.preparedStatement(course, formOfStudy);
				 } else if ((speciality.contentEquals(tester))) {
				 connect.preparedStatement(faculty, course, formOfStudy);
				 } else if ((faculty.contentEquals(tester))) {
				 connect.preparedStatement(speciality, course,
				 formOfStudy);
				 } else {
				 connect.preparedStatement(faculty, speciality, course,
				 formOfStudy);
				 }
			}catch(Exception ex1) {
				ex1.printStackTrace();
			}}
		});
		btnResultCons.setBackground(SystemColor.activeCaption);
		btnResultCons.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnResultCons.setBounds(10, 599, 252, 43);
		frame.getContentPane().add(btnResultCons);
		
		JButton btnNewButton_2 = new JButton("\u0414\u043E\u0432\u0456\u0434\u043A\u0430");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Киїський національний університет ім. Вадима Гетьмана\n"
						+ "\tРобота студента:\n\tГрупи ІН-302\n\tСпеціальності 6i03\n"
						+ "\tМалиша Михайла Максимовича","Довідка",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton_2.setBounds(569, 599, 122, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		

	}
}
