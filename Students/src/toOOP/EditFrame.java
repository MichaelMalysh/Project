package toOOP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EditFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFrame frame = new EditFrame();
					if (translucencySupported())//*
	                    frame.setOpacity(0.95f);//*
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public static boolean translucencySupported() {//*
	        GraphicsEnvironment ge = GraphicsEnvironment//*
	                .getLocalGraphicsEnvironment();//*
	        GraphicsDevice gd = ge.getDefaultScreenDevice();//*

	        return gd.isWindowTranslucencySupported(//*
	                GraphicsDevice.WindowTranslucency.TRANSLUCENT);//*
	    }//*

	Connection conn = null;
	private JButton btnLoad;
	private JScrollBar scrollBar;
	private JLabel labelPIB;
	private JTextField textFieldPIB;
	private JTextField textFieldFaculty;
	private JTextField textFieldSpeciality;
	private JTextField textFieldFormOfStudy;
	private JTextField textFieldCourse;
	private JTextField textFieldStartEducation;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_7;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JSeparator separator_12;
	private JSeparator separator_13;
	private JSeparator separator_14;
	private JSeparator separator_15;
	private JButton btnClear;
	private JSeparator separator_16;
	private JTextField textFieldNumContract;
	private final JLabel lblNewLabel = new JLabel("");
	
	public void refreshTable(){
		try {
			PreparedStatement prst = conn.prepareStatement("SELECT * FROM student.info");
			ResultSet rs = prst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			prst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public EditFrame(){
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java\\JavaProjects\\Students\\pic\\photo_2018-11-19_21-50-09.jpg"));
		setTitle("\u0411\u0430\u0437\u0430 \u0414\u0430\u043D\u0438\u0445 Student.info");
		ConnectionToSQL connect = new ConnectionToSQL();
		conn = connect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1310, 755);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(525, 122, 759, 574);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow();
					String PIB=(table.getModel().getValueAt(row, 1)).toString();
					
					PreparedStatement prst = conn.prepareStatement("SELECT * FROM student.info where PIB='"+PIB+"' ");
					ResultSet rsOne = prst.executeQuery();
					
					while(rsOne.next()){
						textFieldPIB.setText(rsOne.getString("PIB"));
						textFieldNumContract.setText(rsOne.getString("Contract"));
						textFieldFaculty.setText(rsOne.getString("Faculty"));
						textFieldSpeciality.setText(rsOne.getString("Speciality"));
						textFieldFormOfStudy.setText(rsOne.getString("Form_Of_Study"));
						textFieldCourse.setText(rsOne.getString("Cours"));
						textFieldStartEducation.setText(rsOne.getString("Start_education"));
					}
	
					prst.close();
					rsOne.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);

		scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollPane.setColumnHeaderView(scrollBar);

		btnLoad = new JButton("\u041E\u043D\u043E\u0432\u0438\u0442\u0438 \u0411\u0414");
		btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement prst = conn.prepareStatement("SELECT * FROM student.info");
					ResultSet rs = prst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

					prst.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnLoad.setBounds(20, 33, 173, 40);
		contentPane.add(btnLoad);

		labelPIB = new JLabel("\u041F\u0406\u0411");
		labelPIB.setForeground(new Color(255, 255, 204));
		labelPIB.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelPIB.setBounds(20, 99, 283, 23);
		contentPane.add(labelPIB);

		textFieldPIB = new JTextField();
		textFieldPIB.setBounds(20, 133, 283, 40);
		contentPane.add(textFieldPIB);
		textFieldPIB.setColumns(10);

		JLabel lblFaculty = new JLabel("\u0424\u0430\u043A\u0443\u043B\u044C\u0442\u0435\u0442");
		lblFaculty.setForeground(new Color(255, 255, 204));
		lblFaculty.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblFaculty.setBounds(20, 269, 287, 23);
		contentPane.add(lblFaculty);

		textFieldFaculty = new JTextField();
		textFieldFaculty.setBounds(20, 300, 287, 40);
		contentPane.add(textFieldFaculty);
		textFieldFaculty.setColumns(10);

		JLabel lblSpeciality = new JLabel(
				"\u0421\u043F\u0435\u0446\u0456\u0430\u043B\u044C\u043D\u0456\u0441\u0442\u044C");
		lblSpeciality.setForeground(new Color(255, 255, 204));
		lblSpeciality.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSpeciality.setBounds(20, 354, 287, 23);
		contentPane.add(lblSpeciality);

		textFieldSpeciality = new JTextField();
		textFieldSpeciality.setBounds(20, 388, 287, 40);
		contentPane.add(textFieldSpeciality);
		textFieldSpeciality.setColumns(10);

		JLabel lblFormOfStudy = new JLabel(
				"\u0424\u043E\u0440\u043C\u0430 \u043D\u0430\u0432\u0447\u0430\u043D\u043D\u044F");
		lblFormOfStudy.setForeground(new Color(255, 255, 204));
		lblFormOfStudy.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblFormOfStudy.setBounds(20, 439, 287, 23);
		contentPane.add(lblFormOfStudy);

		textFieldFormOfStudy = new JTextField();
		textFieldFormOfStudy.setBounds(20, 473, 287, 40);
		contentPane.add(textFieldFormOfStudy);
		textFieldFormOfStudy.setColumns(10);

		JLabel lblCourse = new JLabel("\u041A\u0443\u0440\u0441");
		lblCourse.setForeground(new Color(255, 255, 204));
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCourse.setBounds(20, 524, 287, 23);
		contentPane.add(lblCourse);

		textFieldCourse = new JTextField();
		textFieldCourse.setBounds(20, 558, 287, 40);
		contentPane.add(textFieldCourse);
		textFieldCourse.setColumns(10);

		JLabel lblStartEducation = new JLabel(
				"\u041F\u043E\u0447\u0430\u0442\u043E\u043A \u043D\u0430\u0432\u0447\u0430\u043D\u043D\u044F");
		lblStartEducation.setForeground(new Color(255, 255, 204));
		lblStartEducation.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblStartEducation.setBounds(20, 612, 287, 23);
		contentPane.add(lblStartEducation);

		textFieldStartEducation = new JTextField();
		textFieldStartEducation.setBounds(20, 643, 287, 40);
		contentPane.add(textFieldStartEducation);
		textFieldStartEducation.setColumns(10);

		JButton btnInsert = new JButton("\u0412\u0432\u0435\u0441\u0442\u0438 \u0434\u0430\u043D\u0456");
		btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement prst = conn.prepareStatement(
							"INSERT into student.info (PIB,Contract,Faculty,Speciality,Form_of_Study,Cours,Start_education) values (?,?,?,?,?,?,?)");
					
					prst.setString(1, textFieldPIB.getText());
					prst.setString(2, textFieldNumContract.getText());
					prst.setString(3, textFieldFaculty.getText());
					prst.setString(4, textFieldSpeciality.getText());
					prst.setString(5, textFieldFormOfStudy.getText());
					prst.setString(6, textFieldCourse.getText());
					prst.setString(7, textFieldStartEducation.getText());
					prst.execute();
					JOptionPane.showMessageDialog(null, "Введено нові дані");
					
					prst.close();


				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Сталася помилка при введенні даних");
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnInsert.setBounds(354, 133, 161, 40);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("\u041E\u043D\u043E\u0432\u0438\u0442\u0438 \u0434\u0430\u043D\u0456");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					PreparedStatement prst = conn.prepareStatement("UPDATE student.info set PIB='"
							+ textFieldPIB.getText() + "' ,Contract='"+textFieldNumContract.getText()+ "' ,Faculty='" + textFieldFaculty.getText() + "' ,Speciality='"
							+ textFieldSpeciality.getText() + "' ,Form_of_Study='" + textFieldFormOfStudy.getText()
							+ "' ,Cours='" + textFieldCourse.getText() + "' ,Start_education='"
							+ textFieldStartEducation.getText() + "' where PIB='" + textFieldPIB.getText() + "'");

					prst.execute();
					JOptionPane.showMessageDialog(null, "Дані оновлено");

					prst.close();


				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Сталася помилка при оновлнні даних");
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnUpdate.setBounds(354, 215, 161, 40);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("\u0412\u0438\u0434\u0430\u043B\u0438\u0442\u0438 \u0434\u0430\u043D\u0456");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Видалення даних проводиться тільки по ПІБ",
						"ГЏГ®ГўВіГ¤Г®Г¬Г«ГҐГ­Г­Гї", JOptionPane.OK_CANCEL_OPTION);
				if (action == 0) {
					try {
						String delOne = "DELETE FROM student.info where PIB='" + textFieldPIB.getText() + "' ";
						PreparedStatement prst = conn.prepareStatement(delOne);

						prst.execute();
						JOptionPane.showMessageDialog(null, "Дані видалено");

						prst.close();


					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Сталася помилка при видаленні даних");
						e1.printStackTrace();
					}
					refreshTable();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnDelete.setBounds(354, 300, 161, 40);
		contentPane.add(btnDelete);

		separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		separator.setForeground(Color.GREEN);
		separator.setBounds(8, 184, 305, 2);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GREEN);
		separator_1.setBackground(Color.GREEN);
		separator_1.setBounds(8, 269, 305, 2);
		contentPane.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.GREEN);
		separator_2.setBackground(Color.GREEN);
		separator_2.setBounds(8, 351, 305, 2);
		contentPane.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.GREEN);
		separator_3.setBackground(Color.GREEN);
		separator_3.setBounds(8, 439, 305, 2);
		contentPane.add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setForeground(Color.GREEN);
		separator_4.setBackground(Color.GREEN);
		separator_4.setBounds(8, 524, 305, 2);
		contentPane.add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.GREEN);
		separator_5.setBackground(Color.GREEN);
		separator_5.setBounds(8, 608, 305, 2);
		contentPane.add(separator_5);

		separator_8 = new JSeparator();
		separator_8.setBackground(Color.GREEN);
		separator_8.setForeground(Color.GREEN);
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(311, 99, 2, 597);
		contentPane.add(separator_8);

		separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setForeground(Color.GREEN);
		separator_9.setBackground(Color.GREEN);
		separator_9.setBounds(8, 99, 2, 597);
		contentPane.add(separator_9);

		separator_7 = new JSeparator();
		separator_7.setForeground(Color.GREEN);
		separator_7.setBackground(Color.GREEN);
		separator_7.setBounds(8, 99, 305, 2);
		contentPane.add(separator_7);

		separator_10 = new JSeparator();
		separator_10.setBackground(Color.ORANGE);
		separator_10.setForeground(Color.ORANGE);
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setBounds(342, 122, 2, 319);
		contentPane.add(separator_10);

		separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setForeground(Color.ORANGE);
		separator_11.setBackground(Color.ORANGE);
		separator_11.setBounds(523, 122, 2, 319);
		contentPane.add(separator_11);

		separator_12 = new JSeparator();
		separator_12.setForeground(Color.ORANGE);
		separator_12.setBackground(Color.ORANGE);
		separator_12.setBounds(342, 122, 186, 2);
		contentPane.add(separator_12);

		separator_13 = new JSeparator();
		separator_13.setForeground(Color.ORANGE);
		separator_13.setBackground(Color.ORANGE);
		separator_13.setBounds(342, 184, 183, 2);
		contentPane.add(separator_13);

		separator_14 = new JSeparator();
		separator_14.setForeground(Color.ORANGE);
		separator_14.setBackground(Color.ORANGE);
		separator_14.setBounds(342, 269, 183, 2);
		contentPane.add(separator_14);

		separator_15 = new JSeparator();
		separator_15.setForeground(Color.ORANGE);
		separator_15.setBackground(Color.ORANGE);
		separator_15.setBounds(342, 351, 183, 2);
		contentPane.add(separator_15);

		btnClear = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u0438 \u043F\u043E\u043B\u044F");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPIB.setText(null);
				textFieldFaculty.setText(null);
				textFieldSpeciality.setText(null);
				textFieldFormOfStudy.setText(null);
				textFieldCourse.setText(null);
				textFieldStartEducation.setText(null);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnClear.setBounds(354, 385, 161, 40);
		contentPane.add(btnClear);

		separator_16 = new JSeparator();
		separator_16.setForeground(Color.ORANGE);
		separator_16.setBackground(Color.ORANGE);
		separator_16.setBounds(342, 439, 183, 2);
		contentPane.add(separator_16);

		JButton btnExit = new JButton("\u0412\u0438\u0445\u0456\u0434");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnExit.setBounds(354, 643, 161, 40);
		contentPane.add(btnExit);

		JSeparator separator_17 = new JSeparator();
		separator_17.setForeground(Color.ORANGE);
		separator_17.setBackground(Color.ORANGE);
		separator_17.setBounds(342, 609, 183, 2);
		contentPane.add(separator_17);

		JSeparator separator_18 = new JSeparator();
		separator_18.setForeground(Color.ORANGE);
		separator_18.setBackground(Color.ORANGE);
		separator_18.setBounds(342, 694, 183, 2);
		contentPane.add(separator_18);

		JSeparator separator_19 = new JSeparator();
		separator_19.setOrientation(SwingConstants.VERTICAL);
		separator_19.setForeground(Color.ORANGE);
		separator_19.setBackground(Color.ORANGE);
		separator_19.setBounds(342, 609, 2, 85);
		contentPane.add(separator_19);

		JSeparator separator_20 = new JSeparator();
		separator_20.setOrientation(SwingConstants.VERTICAL);
		separator_20.setForeground(Color.ORANGE);
		separator_20.setBackground(Color.ORANGE);
		separator_20.setBounds(523, 609, 2, 85);
		contentPane.add(separator_20);

		JLabel lblNazva = new JLabel(
				"\u0411\u0430\u0437\u0430 \u0434\u0430\u043D\u0438\u0445 \u0441\u0442\u0443\u0434\u0435\u043D\u0442\u0456\u0432, \u0437\u0430\u0432\u0430\u043D\u0442\u0430\u0436\u0435\u043D\u0430 \u0437 \u0411\u0414 : Student.info");
		lblNazva.setForeground(new Color(255, 255, 204));
		lblNazva.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNazva.setBounds(342, 11, 826, 85);
		contentPane.add(lblNazva);
		
		JLabel lblNumCountacr = new JLabel("\u041D\u043E\u043C\u0435\u0440 \u043A\u043E\u043D\u0442\u0440\u0430\u043A\u0442\u0443");
		lblNumCountacr.setForeground(new Color(255, 255, 204));
		lblNumCountacr.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNumCountacr.setBounds(20, 184, 287, 23);
		contentPane.add(lblNumCountacr);
		
		textFieldNumContract = new JTextField();
		textFieldNumContract.setColumns(10);
		textFieldNumContract.setBounds(20, 218, 287, 40);
		contentPane.add(textFieldNumContract);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.GREEN);
		separator_6.setBackground(Color.GREEN);
		separator_6.setBounds(8, 694, 305, 2);
		contentPane.add(separator_6);
		lblNewLabel.setIcon(new ImageIcon("C:\\Java\\JavaProjects\\Students\\pic\\photo_2018-11-19_21-50-38.jpg"));
		lblNewLabel.setBounds(0, 0, 1284, 716);
		contentPane.add(lblNewLabel);
		
		refreshTable();
	}
}
