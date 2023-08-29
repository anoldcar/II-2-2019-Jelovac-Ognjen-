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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	private JPanel panel;
	public boolean isOk;
	private Color outline = Color.black;
	private Color fill = Color.black;
	private boolean outlineBool;
	private boolean fillBool;



	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setBounds(100, 100, 293, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
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
			txtRadius = new JTextField();
			txtRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}
				}
			});
			txtRadius.setColumns(10);
			JLabel lblXCoordinate = new JLabel("X coordinate");
			JLabel lblYCoordinate = new JLabel("Y coordinate");
			JLabel lblRadius = new JLabel("Radius");
			
			JButton btnOutline = new JButton("Outline color");
			btnOutline.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outline = JColorChooser.showDialog(null,"choose a color", Color.black);
					outlineBool = true;
				}
			});
			
			JButton btnArea = new JButton("Area color");
			btnArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fill = JColorChooser.showDialog(null,"choose a color", Color.white);
					fillBool = true;
				}
			});
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(35)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblXCoordinate)
									.addComponent(lblYCoordinate)
									.addComponent(lblRadius))
								.addGap(63)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnOutline)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnArea)))
						.addContainerGap(23, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoordinate))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYCoordinate))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRadius))
						.addGap(28)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOutline)
							.addComponent(btnArea))
						.addContainerGap(60, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtRadius.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all blanks","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
							for(Shape shape : PnlDrawing.shapesArrList) {
								if(shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoord.getText()),
										Integer.parseInt(txtYCoord.getText()));
									
									((Circle)shape).setRadius(Integer.parseInt(txtRadius.getText()));
									
									if(outlineBool == true) {
										shape.setOutline(outline);
										outlineBool=false;
									}
									if(fillBool == true) {
										shape.setFill(fill);
										fillBool=false;
									}
								}
							}
							isOk = true;
							dispose();
							
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
