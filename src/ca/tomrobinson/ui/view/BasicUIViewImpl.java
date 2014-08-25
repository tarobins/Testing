package ca.tomrobinson.ui.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ca.tomrobinson.ui.presenter.BasicUIViewListener;

public class BasicUIViewImpl extends JFrame implements BasicUIView {

	private BasicUIViewListener _listener;
	private JTextField _nameField;
	private JTextField _phoneField;
	private JButton _addButton;
	private JButton _dialButton;
	private JTable _contactTable;

	
	public BasicUIViewImpl() {
		layoutDialog();
		addCancelListener();
	}
	
	private void addCancelListener() {
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				_listener.cancelDialog();
			}
		});
	}
	
	
	private void layoutDialog() {
		this.getContentPane().setLayout(new FlowLayout());
		
		this.getContentPane().add(createLeftPanel());
		this.getContentPane().add(createRightPanel());
		this.pack();
	}
	
	private JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		
		addNameField(leftPanel);
		addPhoneField(leftPanel);
		addContactTable(leftPanel);
		
		return leftPanel;
		
	}
	
	private void addNameField(JPanel panel) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		
		_nameField = new JTextField(10);
		
		panel.add(_nameField, constraints);
		_nameField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				_listener.nameEntryChanged(_nameField.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				_listener.nameEntryChanged(_nameField.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				_listener.nameEntryChanged(_nameField.getText());
			}
		});
	}
	
	private void addPhoneField(JPanel panel) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		
		_phoneField = new JTextField(10);
		
		panel.add(_phoneField, constraints);
		
		_phoneField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				_listener.phoneEntryChanged(_phoneField.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				_listener.phoneEntryChanged(_phoneField.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				_listener.phoneEntryChanged(_phoneField.getText());
			}
		});
	}
	
	private void addContactTable(JPanel panel) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		
		_contactTable = new JTable(4,2);
		
		panel.add(_contactTable, constraints);
		
		_contactTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				_listener.newContactSelected(_contactTable.getSelectedRow());
			}
		});
	}
	
	
	
	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS) );

		addAddButton(rightPanel);
		addDialButton(rightPanel);
		
		return rightPanel;
	}
	
	private void addAddButton(JPanel panel) {
		_addButton = new JButton("Add");
		
		panel.add(_addButton);
		
		_addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_listener.addContact();
			}
		});
	}
	
	private void addDialButton(JPanel panel) {
		_dialButton = new JButton("Dial");
		
		panel.add(_dialButton);
		
		_dialButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_listener.dialContact();
			}
		});
	
	}
	
	
	@Override
	public void setListener(BasicUIViewListener listener) {
		_listener = listener;
	}
	

	@Override
	public void setContactData(String[][] data) {
		DefaultTableModel newTableModel = new DefaultTableModel(data, new String[]{"Name", "Phone"});
		_contactTable.setModel(newTableModel);
	}


}
