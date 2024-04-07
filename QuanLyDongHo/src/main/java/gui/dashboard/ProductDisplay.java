package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalButtonUI;

import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class ProductDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblImg;
	private JPanel panel;
	private JPanel pn1;
	private JPanel pn2;
	private JButton btnSell;
	private JLabel lblName;
	private JPanel pnPrice;
	private JLabel lblPrice;
	private JLabel lblStatus;
	private JPanel panel_1;
	private JLabel lblCross;
	private JLabel lblSale;

	/**
	 * Create the panel.
	 */
	public ProductDisplay() {
		setSize(new Dimension(270, 360));
		setPreferredSize(new Dimension(240, 350));
		setMaximumSize(getPreferredSize());
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("<html>IMAGE WILL TAKE<br>PLACE HERE</html>");
		lblImg.setBorder(null);
		lblImg.setOpaque(true);
		lblImg.setBackground(new Color(192, 192, 192));
		lblImg.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImg.setPreferredSize(new Dimension(240, 240));
		add(lblImg, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		pn1 = new JPanel();
		pn1.setOpaque(false);
		pn1.setPreferredSize(new Dimension(35, 10));
		FlowLayout fl_pn1 = (FlowLayout) pn1.getLayout();
		fl_pn1.setVgap(0);
		fl_pn1.setHgap(0);
		panel.add(pn1, BorderLayout.EAST);
		
		btnSell = new JButton("");
		btnSell.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSell.setForeground(new Color(255, 255, 255));
		btnSell.setBackground(new Color(46, 139, 87));
		btnSell.setBorder(null);
		btnSell.setPreferredSize(new Dimension(35, 35));
		pn1.add(btnSell);
		
		pn2 = new JPanel();
		pn2.setBorder(new EmptyBorder(0, 10, 0, 0));
		pn2.setOpaque(false);
		panel.add(pn2, BorderLayout.CENTER);
		pn2.setLayout(new BorderLayout(0, 0));
		
		lblName = new JLabel();
		lblName.setText("Tên sản phẩm ở đây Tên sản phẩm ở đây");
		lblName.setPreferredSize(new Dimension(112, 50));
		lblName.setMaximumSize(lblName.getPreferredSize());
		lblName.setMinimumSize(new Dimension(10, 10));
		lblName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblName.setPreferredSize(new Dimension(112, 50));
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pn2.add(lblName, BorderLayout.NORTH);
		
		pnPrice = new JPanel();
		pnPrice.setOpaque(false);
		pn2.add(pnPrice, BorderLayout.CENTER);
		pnPrice.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblPrice = new JLabel("23,490,000₫");
		lblPrice.setForeground(new Color(227, 116, 42));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pnPrice.add(lblPrice);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		pnPrice.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblCross = new JLabel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void setText(String text) {
				super.setText("<html><strike>" + text + "</strike></html>");
			}
		};
		lblCross.setText("20,930,000₫");
		lblCross.setForeground(Color.GRAY);
		lblCross.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblCross);
		
		lblSale = new JLabel("-25%");
		lblSale.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSale.setForeground(new Color(240, 92, 92));
		lblSale.setOpaque(true);
		lblSale.setBackground(new Color(249, 233, 226));
		lblSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSale);
		
		lblStatus = new JLabel("CÒN HÀNG");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setFont(new Font("Roboto Mono", Font.PLAIN, 15));
		pn2.add(lblStatus, BorderLayout.SOUTH);
		
		addStuff();

	}

	private void addStuff() {
		btnSell.setIcon(FontIcon.of(MaterialDesignC.CART, 20, btnSell.getForeground()));
		btnSell.setFocusPainted(false);
		makeHoverEff(btnSell);
		lblName.addMouseListener(new MouseAdapter() {
			private String txt = lblName.getText();
			@Override
		    public void mouseEntered(MouseEvent e) {
				lblName.setText("<html><u>" + txt + "</u></html>");
			}	
			@Override
		    public void mouseExited(MouseEvent e) {
				lblName.setText("<html>" + txt + "</html>");

			}
			@Override
		    public void mouseClicked(MouseEvent e) {
				JFrame fr = new ProductDetailsGUI();
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
			}
		});
        MouseEvent mouseEvent = new MouseEvent(lblName, MouseEvent.MOUSE_EXITED, System.currentTimeMillis(), 0, 0, 0, 0, false);
        lblName.dispatchEvent(mouseEvent);
	}
	
	private void makeHoverEff(AbstractButton btn) {
        Color iconColor = ((FontIcon) btn.getIcon()).getIconColor();
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        if (!btn.isEnabled()) {
                ((FontIcon) btn.getIcon()).setIconColor(Color.decode("#f03b13"));
                return;
        }
        btn.removeActionListener(null);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(Color.decode("#f03b13"));
                    btn.setForeground(Color.white);
                    ((FontIcon) btn.getIcon()).setIconColor(Color.white);
                } 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.isEnabled()) {
                        btn.setBackground(bg);
                        btn.setForeground(fore);
                        ((FontIcon) btn.getIcon()).setIconColor(iconColor);
                }
            }
        });
    }

}