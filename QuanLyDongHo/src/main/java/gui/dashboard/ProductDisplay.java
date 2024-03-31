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
	private JLabel lblPrice;
	private JLabel lblStatus;

	/**
	 * Create the panel.
	 */
	public ProductDisplay() {
		setSize(new Dimension(270, 360));
		setMaximumSize(new Dimension(270, 360));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(240, 320));
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
		pn2.setLayout(new GridLayout(3, 0, 0, 0));
		
		lblName = new JLabel("Tên sản phẩm ở đây");
		lblName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pn2.add(lblName);
		
		lblPrice = new JLabel("23,490,000₫");
		lblPrice.setForeground(new Color(227, 116, 42));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pn2.add(lblPrice);
		
		lblStatus = new JLabel("CÒN HÀNG");
		lblStatus.setVerticalAlignment(SwingConstants.TOP);
		lblStatus.setFont(new Font("Roboto Mono", Font.PLAIN, 15));
		pn2.add(lblStatus);
		
		addStuff();

	}

	private void addStuff() {
		// TODO Auto-generated method stub
		btnSell.setIcon(FontIcon.of(MaterialDesignC.CART, 20, btnSell.getForeground()));
		btnSell.setFocusPainted(false);
		makeHoverEff(btnSell);
		lblName.addMouseListener(new MouseAdapter() {
			private String prdname = lblName.getText();
			@Override
		    public void mouseEntered(MouseEvent e) {
				lblName.setText("<html><u>" + prdname + "</u></html>");
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				lblName.setText(prdname);
			}
			
			@Override
		    public void mouseClicked(MouseEvent e) {
				JFrame fr = new ProductDetailsGUI();
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
			}
		});
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
