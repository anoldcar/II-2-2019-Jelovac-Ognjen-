package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackDlg extends JDialog {

	private final JPanel CenterPnl = new JPanel();
	private JPanel ButtonPnl;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton okButton;
	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	private JButton cancelButton;
	private JTextField txtYCoord;
	private JTextField txtXCoord;
	private JTextPane txtpnXCoordiantes;
	private JTextPane txtpnYCoordinates;
	private JTextPane txtpnWidth;
	private JTextPane txtpnHeight;
	public boolean isOk;
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StackDlg dialog = new StackDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StackDlg() {
		setModal(true);
		setBounds(100, 100, 338, 300);
		CenterPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			ButtonPnl = new JPanel();
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty() || 
								txtHeight.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all blanks","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
							isOk = true;
							setDelete(true);
							dispose();
							
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						setDelete(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(CenterPnl, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(ButtonPnl, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(CenterPnl, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(ButtonPnl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_ButtonPnl = new GroupLayout(ButtonPnl);
		gl_ButtonPnl.setHorizontalGroup(
			gl_ButtonPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPnl.createSequentialGroup()
					.addGap(164)
					.addComponent(okButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cancelButton)
					.addGap(148))
		);
		gl_ButtonPnl.setVerticalGroup(
			gl_ButtonPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPnl.createSequentialGroup()
					.addGroup(gl_ButtonPnl.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(cancelButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		ButtonPnl.setLayout(gl_ButtonPnl);
		{
			txtWidth = new JTextField();
			txtWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}
				}
			});
			txtWidth.setHorizontalAlignment(SwingConstants.TRAILING);
			txtWidth.setColumns(10);
		}
		{
			txtHeight = new JTextField();
			txtHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}
				}
			});
			txtHeight.setColumns(10);
		}
		
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
			}
			}
		});
		txtYCoord.setColumns(10);
		
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCoord.setColumns(10);
		txtpnXCoordiantes = new JTextPane();
		txtpnXCoordiantes.setText("X coordiantes");
		txtpnYCoordinates = new JTextPane();
		txtpnYCoordinates.setText("Y coordinates");
		txtpnWidth = new JTextPane();
		txtpnWidth.setText("Width");
		txtpnHeight = new JTextPane();
		txtpnHeight.setText("Height");
		GroupLayout gl_CenterPnl = new GroupLayout(CenterPnl);
		gl_CenterPnl.setHorizontalGroup(
			gl_CenterPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CenterPnl.createSequentialGroup()
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnXCoordiantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnYCoordinates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		gl_CenterPnl.setVerticalGroup(
			gl_CenterPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CenterPnl.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CenterPnl.createSequentialGroup()
							.addComponent(txtpnXCoordiantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtpnYCoordinates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtpnWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtpnHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_CenterPnl.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		CenterPnl.setLayout(gl_CenterPnl);
		getContentPane().setLayout(groupLayout);
	}
}
