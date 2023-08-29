package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXStart;
	private JTextField txtYStart;
	private JTextField txtXEnd;
	private JTextField txtYEnd;
	public boolean isOk;
	private Color outline = Color.black;
	private boolean outlineBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTextField getTxtXStart() {
		return txtXStart;
	}

	public void setTxtXStart(JTextField txtXStart) {
		this.txtXStart = txtXStart;
	}

	public JTextField getTxtYStart() {
		return txtYStart;
	}

	public void setTxtYStart(JTextField txtYStart) {
		this.txtYStart = txtYStart;
	}

	public JTextField getTxtXEnd() {
		return txtXEnd;
	}

	public void setTxtXEnd(JTextField txtXEnd) {
		this.txtXEnd = txtXEnd;
	}

	public JTextField getTxtYEnd() {
		return txtYEnd;
	}

	public void setTxtYEnd(JTextField txtYEnd) {
		this.txtYEnd = txtYEnd;
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setBounds(100, 100, 284, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PnlCenter = new JPanel();
			getContentPane().add(PnlCenter, BorderLayout.CENTER);
			{
				txtXStart = new JTextField();
				txtXStart.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
						}
					}
				});
				txtXStart.setColumns(10);
			}
			txtYStart = new JTextField();
			txtYStart.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			txtYStart.setColumns(10);
			txtXEnd = new JTextField();
			txtXEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			txtXEnd.setColumns(10);
			txtYEnd = new JTextField();
			txtYEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			txtYEnd.setColumns(10);
			JLabel lblXStart = new JLabel("X start");
			JLabel lblYStart = new JLabel("Y start");
			JLabel lblXEnd = new JLabel("X end");
			JLabel lblYEnd = new JLabel("Y end");
			
			JButton btnOutline = new JButton("Outline color");
			btnOutline.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outline = JColorChooser.showDialog(null,"choose a color", Color.black);
					outlineBool = true;
				}
			});
			GroupLayout gl_PnlCenter = new GroupLayout(PnlCenter);
			gl_PnlCenter.setHorizontalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(33)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblXStart)
								.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
								.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblXEnd)
								.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
								.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblYStart)
								.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
								.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblYEnd)
								.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
								.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
									.addComponent(btnOutline)
									.addComponent(txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(33))
			);
			gl_PnlCenter.setVerticalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(32)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXStart))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYStart))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXEnd))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYEnd))
						.addGap(18)
						.addComponent(btnOutline)
						.addContainerGap(62, Short.MAX_VALUE))
			);
			PnlCenter.setLayout(gl_PnlCenter);
		}
		{
			JPanel PnlButton = new JPanel();
			PnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(PnlButton, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXStart.getText().trim().isEmpty() || txtYStart.getText().trim().isEmpty() || txtXEnd.getText().trim().isEmpty() || txtYEnd.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all blanks","Error",JOptionPane.ERROR_MESSAGE);
							dispose();
						}
						else {
							for(Shape shape : PnlDrawing.shapesArrList) {
								if(shape.isSelected()) {
									((Line)shape).setStart(new Point(
											Integer.parseInt(txtXStart.getText()),
											Integer.parseInt(txtYStart.getText())));
									
									((Line)shape).setStart(new Point(
											Integer.parseInt(txtXEnd.getText()),
											Integer.parseInt(txtYEnd.getText())));
									if(outlineBool == true) {
										shape.setOutline(outline);
										outlineBool=false;
									}
								}
							}
							
						}
						dispose();
						return;
					}
				});
				okButton.setActionCommand("OK");
				PnlButton.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				PnlButton.add(cancelButton);
			}
		}
	}

}
