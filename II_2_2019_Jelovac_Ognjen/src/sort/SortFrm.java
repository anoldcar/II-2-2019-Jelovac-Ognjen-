package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;
import stack.StackDlg;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class SortFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Rectangle> arrayRect = new ArrayList<>();
	Stack<Rectangle> stack = new Stack<Rectangle>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
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
	public SortFrm() {
		setTitle("II 2/2019 Jelovac Ognjen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
		);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlDown = new JPanel();
		
		JButton BtnAdd = new JButton("Add");
		BtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 {
					 StackDlg stackdlg = new StackDlg();
						stackdlg.setVisible(true);
						if(stackdlg.isOk == true) {
							Rectangle rec = new Rectangle(new Point
							(Integer.parseInt(stackdlg.getTxtXCoord().getText()),
							(Integer.parseInt(stackdlg.getTxtYCoord().getText()))),
							(Integer.parseInt(stackdlg.getTxtWidth().getText())),
							(Integer.parseInt(stackdlg.getTxtHeight().getText())));
							arrayRect.add(rec);
							Collections.sort(arrayRect);
							dlm.add(arrayRect.indexOf(rec),"X: " + rec.getUpperLeft().getX() + " , Y: " + rec.getUpperLeft().getY() + " , Width: "
							+ rec.getWidth() + " , Height: " + rec.getHeight());
							System.out.println(stack);
						}
				 }
			}
		});
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to remove", "Error",
					JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();
				}
				StackDlg stackdlgdelete = new StackDlg();
				String[] split = dlm.firstElement().toString().split(" ");
				stackdlgdelete.getTxtXCoord().setText(split[1]);
				stackdlgdelete.getTxtYCoord().setText(split[4]);
				stackdlgdelete.getTxtWidth().setText(split[7]);
				stackdlgdelete.getTxtHeight().setText(split[10]);
				stackdlgdelete.getTxtXCoord().setEditable(false);
				stackdlgdelete.getTxtYCoord().setEditable(false);
				stackdlgdelete.getTxtWidth().setEditable(false);
				stackdlgdelete.getTxtHeight().setEditable(false);
				stackdlgdelete.setVisible(true);
				
				if(stackdlgdelete.isDelete()==true) {
					arrayRect.remove(0);
					dlm.removeElementAt(0);
				}
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(65)
					.addComponent(BtnAdd)
					.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(70))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlDown.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(BtnAdd)
						.addComponent(btnNewButton_1)))
		);
		pnlDown.setLayout(gl_pnlDown);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pnlDown, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDown, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
