package ru.fedichkindenis.main;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

import ru.fedichkindenis.file.ProcessFile;
import ru.fedichkindenis.stream.FStream;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class MainWin extends JFrame implements UpdateInfo{

	private JPanel contentPane;
	private JTextField pathDir;
	private JFileChooser fileChooser;
	private JButton button;
	private JScrollPane scrollPane;
	private JList listFile;
	private ArrayList<String> pathFiles = new ArrayList<String>();
	private FStream fs = null;
	private JProgressBar progressBar;
	private JPanel panel;
	private JScrollPane scrollPane_1;

	/**
	 * Create the frame.
	 */
	public MainWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		pathDir = new JTextField();
		pathDir.setMinimumSize(new Dimension(6, 23));
		pathDir.setPreferredSize(new Dimension(6, 23));
		GridBagConstraints gbc_pathDir = new GridBagConstraints();
		gbc_pathDir.anchor = GridBagConstraints.NORTH;
		gbc_pathDir.insets = new Insets(0, 0, 5, 5);
		gbc_pathDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_pathDir.gridx = 0;
		gbc_pathDir.gridy = 0;
		contentPane.add(pathDir, gbc_pathDir);
		pathDir.setColumns(10);
		
		JButton btnBrowse = new JButton("\u041E\u0431\u0437\u043E\u0440");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = fileChooser.showDialog(contentPane, "������� �����");
				
				if(res == JFileChooser.APPROVE_OPTION){
					
					pathDir.setText(fileChooser.getSelectedFile().getPath());
				}
			}
		});
		btnBrowse.setMinimumSize(new Dimension(100, 23));
		btnBrowse.setMaximumSize(new Dimension(100, 23));
		btnBrowse.setPreferredSize(new Dimension(100, 23));
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.anchor = GridBagConstraints.NORTH;
		gbc_btnBrowse.gridx = 1;
		gbc_btnBrowse.gridy = 0;
		contentPane.add(btnBrowse, gbc_btnBrowse);
		
		final MainWin mw = this;
		
		button = new JButton("\u0421\u043A\u0430\u043D\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				File f = new File(pathDir.getText());

				if(f.isDirectory()){
					
					fs = new FStream();
					pathFiles.clear();
					try {
						fs.addMethod(UpdateInfo.class.getMethod("startUIProcess"), mw);
						fs.addMethod(ProcessFile.class.getMethod("findNEF", File.class, UpdateInfo.class), new ProcessFile(), f, mw);
						fs.addMethod(UpdateInfo.class.getMethod("stopUIProcess"), mw);
						fs.start();
						
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		contentPane.add(progressBar, gbc_progressBar);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		listFile = new JList();
		listFile.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				FileInputStream fin = null;
				byte [] b = new byte[19];
				try { 
					fin = new FileInputStream(new File(listFile.getSelectedValue().toString()));

					fin.skip(900);
					fin.read(b);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally{
					if(fin != null)
						try {
							fin.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		scrollPane.setViewportView(listFile);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("�������� ���������� ��� ������");
	}

	@Override
	public void sendNewData(String str) {
		
		System.out.println(str);
		pathFiles.add(str);
		listFile.setListData(pathFiles.toArray());
	}

	@Override
	public void startUIProcess() {
		
		progressBar.setIndeterminate(true);
	}

	@Override
	public void stopUIProcess() {
		
		progressBar.setIndeterminate(false);
	}

}
