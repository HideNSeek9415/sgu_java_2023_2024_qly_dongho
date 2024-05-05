package gui.dashboard;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bll.ImportInvoiceBLL;
import bll.SupplierBLL;
import dto.ImportInvoice;
import dto.ImportInvoiceDetail;
import dto.Product;
import dto.Supplier;
import system.ConfigPRJ;

import javax.swing.JSpinner;
import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class ThemPhieuNhap extends javax.swing.JFrame {
	
	public ArrayList<Supplier> suppliers = SupplierBLL.getSupplierList();
	public Supplier selectedSpplier = null;
	DefaultTableModel modelSP;
	DefaultTableModel modelSPN;
	ArrayList<Product> products;
	ArrayList<ImportInvoiceDetail> details = new ArrayList<>();
	Product sProduct;
	int curID = ImportInvoiceBLL.getNextId();
    
    public ThemPhieuNhap() {
    	getContentPane().setBackground(new Color(240, 247, 250));
        initComponents();
        setInfo();
        
        addEvent();
    }

    private void setInfo() {
    	
    	suppliers.forEach(supplier -> {
    		cbbNCC.addItem(supplier.getSupplierId());	
    	});
	}
    
    private void reloadModelSP() {
    	modelSP.setRowCount(0);
    	products = SupplierBLL.getProvidedList(selectedSpplier.getSupplierId());
    	products.forEach(p -> {
    		Object[] data = {
    			p.getId(),
    			p.getProductName()
    		};
    		modelSP.addRow(data);
    	});
    }

	private void addEvent() {
		modelSP = (DefaultTableModel) tbSP.getModel();
		modelSPN = (DefaultTableModel) tbSPN.getModel();

    	cbbNCC.addItemListener(e -> {
    		int id = (Integer) cbbNCC.getSelectedItem();
    		suppliers.forEach(supplier -> {
    			if (supplier.getSupplierId() == id) {
    				selectedSpplier = supplier;
    			}
    		});
    		if (selectedSpplier != null) {
    			tenNCC.setText(selectedSpplier.getSupplierName());
    			reloadModelSP();
    		}
    	});
    	tbSP.getSelectionModel().addListSelectionListener(e -> {
    		int id = (Integer) tbSP.getValueAt(tbSP.getSelectedRow(), 0);
     		products.forEach(p -> {
    			if (p.getId() == id) {
    				sProduct = p;
    			}
    		});
     		pid.setText(String.valueOf(sProduct.getId()));
     		pname.setText(sProduct.getProductName());
     		pbrand.setText(sProduct.getBrand());
     		ptype.setText(sProduct.getCategory());
    	});
    	btnThemSP.addActionListener(e -> {
    		if (sProduct == null) return;
    		cbbNCC.setEnabled(false);
    		ImportInvoiceDetail sdt = null;
    		int r = -1;
    		for (ImportInvoiceDetail d : details) {
    			if (sProduct.getId() == d.getProductId()) {
    				sdt = d;
    				r = details.indexOf(d);
    			}
    		}
    		if (sdt == null) {    			
	    		ImportInvoiceDetail dt = new ImportInvoiceDetail(0, curID, sProduct.getId(), (Integer) SL.getValue(), (Integer) giaNhap.getValue());
	    		details.add(dt);
	    		Object[] data = {
	    			sProduct.getId(),
	    			sProduct.getProductName(),
	    			sProduct.getCategory(),
	    			sProduct.getBrand(),
	    			giaNhap.getValue(),
	    			SL.getValue(),
	    		};
	    		modelSPN.addRow(data);
    		} else {
    			int sl = (Integer) SL.getValue();
    			int dg = (Integer) giaNhap.getValue();
    			sdt.setQuantity(sl);
    			sdt.setImportPrice(dg);
    			tbSPN.setValueAt(dg, r, 4);
    			tbSPN.setValueAt(sl, r, 5);
    		}
    		calTotal();
    	});
    	btnXoaSP.addActionListener(e -> {
    		int cr = tbSPN.getSelectedRow();
    		modelSPN.removeRow(cr);
    		details.remove(cr);
    		calTotal();
    		if (tbSPN.getRowCount() == 0) cbbNCC.setEnabled(true);
    	});
    	btnNhap.addActionListener(e -> {
    		ImportInvoice newII = new ImportInvoice(curID, ConfigPRJ.currentUser.getId(), selectedSpplier.getSupplierId(), new Date());
    		newII.setDetails(details);
    		ImportInvoiceBLL.addImportInvoice(newII);
    		((PhieuNhapGUI) ConfigPRJ.menu.get("RECEIPTS")).reloadTable();
    		((TmpHomePanel) ConfigPRJ.menu.get("HOME")).reloadPanel();
    		((ProductManagerGUI) ConfigPRJ.menu.get("PRODUCTS")).displayProducts();
    		dispose();
    	});
	}
	

	private void calTotal() {
		int total = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		for (ImportInvoiceDetail d : details) {
			total += d.getQuantity() * d.getImportPrice();
		}
		String priceVND = decimalFormat.format(total);
		lbltt.setText(priceVND);
	}

	private void initComponents() {

        phieuNhap = new javax.swing.JPanel();
        phieuNhap.setBackground(new Color(240, 247, 250));
        spPhieuNhap = new javax.swing.JScrollPane();
        spPhieuNhap.setBounds(6, 358, 802, 230);
        tbSPN = new javax.swing.JTable();
        tenNCC = new JLabel();
        tenNCC.setFont(new Font("SansSerif", Font.BOLD, 25));
        tenNCC.setHorizontalAlignment(SwingConstants.CENTER);
        tenNCC.setText("Nhà cung cấp");
        tenNCC.setBackground(new Color(255, 255, 255));
        tenNCC.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        tenNCC.setBounds(6, 6, 438, 40);
        spDaCo = new javax.swing.JScrollPane();
        spDaCo.setBounds(6, 52, 438, 236);
        tbSP = new javax.swing.JTable();
        giaNhap = new JSpinner();
        giaNhap.setModel(new SpinnerNumberModel(500000, 500000, 5000000, 100000));
        giaNhap.setBounds(456, 93, 340, 40);
        pid = new JLabel();
        pid.setForeground(new Color(128, 128, 128));
        pid.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        pid.setOpaque(true);
        pid.setBackground(new Color(255, 255, 255));
        pid.setBounds(456, 27, 76, 40);
        sideBarPN = new javax.swing.JPanel();
        sideBarPN.setBounds(814, 6, 283, 590);
        sideBarPN.setOpaque(false);
        maPhieuNhap = new javax.swing.JTextField();
        maPhieuNhap.setBounds(15, 34, 262, 40);
        maPhieuNhap.setText(String.valueOf(curID));
        tenNhanVien = new javax.swing.JTextField(ConfigPRJ.currentUser.getFullName());
        tenNhanVien.setBounds(15, 111, 262, 40);
        tongTien = new javax.swing.JLabel();
        tongTien.setBounds(15, 508, 104, 20);
        tongTien.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnNhap = new javax.swing.JButton();
        btnNhap.setBounds(15, 537, 262, 40);
        btnNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtMaPN = new javax.swing.JLabel();
        txtMaPN.setBounds(15, 12, 93, 16);
        txtMaPN.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtNV = new javax.swing.JLabel();
        txtNV.setBounds(15, 89, 102, 16);
        txtNV.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtNCC = new javax.swing.JLabel();
        txtNCC.setBounds(15, 169, 99, 16);
        txtNCC.setFont(new Font("SansSerif", Font.BOLD, 12));
        cbbNCC = new javax.swing.JComboBox<>();
        cbbNCC.setBounds(15, 191, 262, 40);
        pname = new JLabel();
        pname.setForeground(new Color(128, 128, 128));
        pname.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        pname.setOpaque(true);
        pname.setBackground(new Color(255, 255, 255));
        pname.setBounds(550, 27, 246, 40);
        nhapMaSp = new javax.swing.JLabel();
        nhapMaSp.setBounds(456, 6, 76, 16);
        nhapMaSp.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtTenSP = new javax.swing.JLabel();
        txtTenSP.setBounds(550, 6, 88, 16);
        txtTenSP.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtGiaNhap = new javax.swing.JLabel();
        txtGiaNhap.setBounds(456, 73, 64, 16);
        txtGiaNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtPTNhap = new javax.swing.JLabel();
        txtPTNhap.setBounds(456, 139, 134, 16);
        txtPTNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtGhiChu = new javax.swing.JLabel();
        txtGhiChu.setBounds(456, 207, 76, 16);
        txtGhiChu.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnThemSP = new javax.swing.JButton();
        btnThemSP.setBounds(6, 300, 191, 40);
        btnThemSP.setForeground(new Color(255, 255, 255));
        btnThemSP.setBackground(new Color(0, 128, 0));
        btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnXoaSP = new javax.swing.JButton();
        btnXoaSP.setBounds(203, 300, 191, 40);
        btnXoaSP.setForeground(new Color(255, 255, 255));
        btnXoaSP.setBackground(new Color(172, 21, 21));
        btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtSL = new javax.swing.JLabel();
        txtSL.setBounds(725, 139, 66, 16);
        txtSL.setFont(new Font("SansSerif", Font.BOLD, 12));
        SL = new JSpinner();
        SL.setModel(new SpinnerNumberModel(1, 1, 15, 1));
        SL.setBounds(725, 161, 71, 40);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 600));

        phieuNhap.setPreferredSize(new java.awt.Dimension(1100, 600));

        tbSPN.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"M\u00E3 SP", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i \u0111\u1ED3ng h\u1ED3", "Th\u01B0\u01A1ng hi\u1EC7u", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng"
        	}
        ));
        spPhieuNhap.setViewportView(tbSPN);

        tbSP.setModel(new DefaultTableModel(
        	new Object[][] {},
        	new String[] {
        		"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m"
        	}
        ) {
    
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
        		false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        tbSP.getColumnModel().getColumn(0).setResizable(false);
        tbSP.getColumnModel().getColumn(0).setPreferredWidth(35);
        tbSP.getColumnModel().getColumn(1).setResizable(false);
        tbSP.getColumnModel().getColumn(1).setPreferredWidth(175);
        spDaCo.setViewportView(tbSP);

        pid.setEnabled(false);

        sideBarPN.setBackground(new java.awt.Color(255, 255, 255));

        maPhieuNhap.setEnabled(false);

        tenNhanVien.setEnabled(false);

        tongTien.setText("TỔNG TIỀN:");

        btnNhap.setText("Nhập Hàng");

        txtMaPN.setText("Mã Phiếu Nhập");

        txtNV.setText("Nhân Viên Nhập");

        txtNCC.setText("Nhà Cung Cấp");
        
        lbltt = new JLabel("0 VNĐ");
        lbltt.setBounds(125, 503, 152, 28);
        lbltt.setHorizontalAlignment(SwingConstants.RIGHT);
        lbltt.setHorizontalTextPosition(SwingConstants.CENTER);
        lbltt.setForeground(new Color(255, 0, 0));
        lbltt.setFont(new Font("SansSerif", Font.BOLD, 17));

        pname.setEnabled(false);

        nhapMaSp.setText("Mã SP");

        txtTenSP.setText("Tên Sản Phẩm");

        txtGiaNhap.setText("Giá Nhập");

        txtPTNhap.setText("Loại đồng hồ");

        txtGhiChu.setText("Thương hiệu");

        btnThemSP.setText("Thêm Sản Phẩm");

        btnXoaSP.setText("Xóa Sản Phẩm");

        txtSL.setText("Số Lượng");
        
        pbrand = new JLabel();
        pbrand.setForeground(new Color(128, 128, 128));
        pbrand.setBounds(456, 229, 251, 40);
        pbrand.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        pbrand.setBackground(new Color(255, 255, 255));
        pbrand.setOpaque(true);
        
        ptype = new JLabel();
        ptype.setForeground(new Color(128, 128, 128));
        ptype.setBounds(456, 161, 251, 40);
        ptype.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        ptype.setOpaque(true);
        ptype.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        phieuNhap.setLayout(null);
        phieuNhap.add(spDaCo);
        phieuNhap.add(tenNCC);
        phieuNhap.add(pbrand);
        phieuNhap.add(nhapMaSp);
        phieuNhap.add(pid);
        phieuNhap.add(pname);
        phieuNhap.add(txtTenSP);
        phieuNhap.add(txtGhiChu);
        phieuNhap.add(txtPTNhap);
        phieuNhap.add(ptype);
        phieuNhap.add(SL);
        phieuNhap.add(txtSL);
        phieuNhap.add(txtGiaNhap);
        phieuNhap.add(giaNhap);
        phieuNhap.add(btnThemSP);
        phieuNhap.add(btnXoaSP);
        phieuNhap.add(spPhieuNhap);
        phieuNhap.add(sideBarPN);
        sideBarPN.setLayout(null);
        sideBarPN.add(tongTien);
        sideBarPN.add(lbltt);
        sideBarPN.add(btnNhap);
        sideBarPN.add(maPhieuNhap);
        sideBarPN.add(tenNhanVien);
        sideBarPN.add(txtMaPN);
        sideBarPN.add(txtNV);
        sideBarPN.add(txtNCC);
        sideBarPN.add(cbbNCC);
        
        lblNgyToPhiu = new JLabel();
        lblNgyToPhiu.setText("NGÀY TẠO:");
        lblNgyToPhiu.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNgyToPhiu.setBounds(15, 473, 93, 20);
        sideBarPN.add(lblNgyToPhiu);
        
        lblcreate = new JLabel((new SimpleDateFormat("dd/MM/yyyy")).format(new Date()));
        lblcreate.setHorizontalTextPosition(SwingConstants.CENTER);
        lblcreate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblcreate.setForeground(new Color(0, 0, 0));
        lblcreate.setFont(new Font("SansSerif", Font.BOLD, 17));
        lblcreate.setBounds(111, 468, 166, 28);
        sideBarPN.add(lblcreate);

        pack();
        setLocationRelativeTo(null);
    }

    private JSpinner SL;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<Integer> cbbNCC;
    private javax.swing.JTextField maPhieuNhap;
    private JSpinner giaNhap;
    private javax.swing.JButton btnNhap;
    private JLabel pid;
    private javax.swing.JLabel nhapMaSp;
    private javax.swing.JPanel phieuNhap;
    private javax.swing.JPanel sideBarPN;
    private javax.swing.JScrollPane spDaCo;
    private javax.swing.JScrollPane spPhieuNhap;
    private javax.swing.JTable tbSP;
    private javax.swing.JTable tbSPN;
    private javax.swing.JTextField tenNhanVien;
    private JLabel pname;
    private JLabel tenNCC;
    private javax.swing.JLabel tongTien;
    private javax.swing.JLabel txtGhiChu;
    private javax.swing.JLabel txtGiaNhap;
    private javax.swing.JLabel txtMaPN;
    private javax.swing.JLabel txtNCC;
    private javax.swing.JLabel txtNV;
    private javax.swing.JLabel txtPTNhap;
    private javax.swing.JLabel txtSL;
    private javax.swing.JLabel txtTenSP;
    private JLabel lbltt;
    private JLabel pbrand;
    private JLabel ptype;
    private JLabel lblNgyToPhiu;
    private JLabel lblcreate;
}
