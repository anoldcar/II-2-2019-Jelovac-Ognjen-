package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrm extends JFrame {
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack<Rectangle> stack = new Stack<Rectangle>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
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
	public StackFrm() {
		setTitle("II 2/2019 Jelovac Ognjen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JPanel PnlDown = new JPanel();
		contentPane.add(PnlDown, BorderLayout.SOUTH);
		
		JButton AddBtn = new JButton("Add");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDlg stackdlg = new StackDlg();
				stackdlg.setVisible(true);
				if(stackdlg.isOk == true) {
					Rectangle rec = new Rectangle(new Point
					(Integer.parseInt(stackdlg.getTxtXCoord().getText()),
					(Integer.parseInt(stackdlg.getTxtYCoord().getText()))),
					(Integer.parseInt(stackdlg.getTxtWidth().getText())),
					(Integer.parseInt(stackdlg.getTxtHeight().getText())));
					stack.push(rec);
					dlm.add(0,"X: " + rec.getUpperLeft().getX() + " , Y: " + rec.getUpperLeft().getY() + " , Width: "
					+ rec.getWidth() + " , Height: " + rec.getHeight());
					System.out.println(stack);
				}
			}
		});
			
		JButton RemoveBtn = new JButton("Remove");
		RemoveBtn.addActionListener(new ActionListener() {
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
					stack.pop();
					dlm.removeElementAt(0);
				}
			}
		});
		GroupLayout gl_PnlDown = new GroupLayout(PnlDown);
		gl_PnlDown.setHorizontalGroup(
			gl_PnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlDown.createSequentialGroup()
					.addGap(35)
					.addComponent(AddBtn)
					.addGap(212)
					.addComponent(RemoveBtn))
		);
		gl_PnlDown.setVerticalGroup(
			gl_PnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlDown.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_PnlDown.createParallelGroup(Alignment.LEADING)
						.addComponent(AddBtn)
						.addComponent(RemoveBtn)))
		);
		PnlDown.setLayout(gl_PnlDown);
	}
}
