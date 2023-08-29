package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtYCoord;
	private JTextField txtXCoord;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel PnlCenter;
	public boolean isOk;
	private Color outline = Color.black;
	private Color fill = Color.black;
	private boolean outlineBool;
	private boolean fillBool;
	private JButton btnOutline;
	private JButton btnArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	




	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 299, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			PnlCenter = new JPanel();
			{
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
			}
			{
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
				txtWidth.setColumns(10);
			}
			
			JLabel lblXCoordinate = new JLabel("X coordinate");
			
			JLabel lblYCoordinate = new JLabel("Y coordinate");
			
			JLabel lblHeight = new JLabel("Height");
			
			JLabel lblWidth = new JLabel("Width");
			btnOutline = new JButton("Outline color");
			btnOutline.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outline = JColorChooser.showDialog(null,"choose a color", Color.black);
					outlineBool = true;
				}
			});
			btnArea = new JButton("Area color");
			btnArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fill = JColorChooser.showDialog(null,"choose a color", Color.white);
					fillBool = true;
				}
			});
			GroupLayout gl_PnlCenter = new GroupLayout(PnlCenter);
			gl_PnlCenter.setHorizontalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnOutline)
							.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYCoordinate)
								.addComponent(lblHeight)
								.addComponent(lblWidth)
								.addComponent(lblXCoordinate)))
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addGap(66)
								.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
									.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(13, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_PnlCenter.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnArea)
								.addGap(27))))
			);
			gl_PnlCenter.setVerticalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(23)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoordinate))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYCoordinate))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHeight))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWidth))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOutline)
							.addComponent(btnArea))
						.addContainerGap(25, Short.MAX_VALUE))
			);
			PnlCenter.setLayout(gl_PnlCenter);
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(PnlCenter);
		{
			JPanel PnlButton = new JPanel();
			getContentPane().add(PnlButton, BorderLayout.SOUTH);
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
							for(Shape shape : PnlDrawing.shapesArrList) {
								if(shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoord.getText()), 
									Integer.parseInt(txtYCoord.getText()));
									
									((Rectangle)shape).setWidth(Integer.parseInt(txtWidth.getText()));
									((Rectangle)shape).setHeight(Integer.parseInt(txtHeight.getText()));
									
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
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_PnlButton = new GroupLayout(PnlButton);
			gl_PnlButton.setHorizontalGroup(
				gl_PnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlButton.createSequentialGroup()
						.addGap(158)
						.addComponent(okButton)
						.addGap(5)
						.addComponent(cancelButton))
			);
			gl_PnlButton.setVerticalGroup(
				gl_PnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlButton.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_PnlButton.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton)))
			);
			PnlButton.setLayout(gl_PnlButton);
		}
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
}
