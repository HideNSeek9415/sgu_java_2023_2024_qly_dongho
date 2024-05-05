package gui.dashboard;

import bll.WarrantyBLL;
import dto.ExportInvoice;
import dto.Warranty;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaoPhieuBaoHanhGUI extends JFrame {
    public static ExportInvoice selectedExport;
    protected JLabel supNameErrorMsg;
    private JTextArea textArea;
    private JButton btnXacNhan;

    public TaoPhieuBaoHanhGUI() {
        // Thiết lập các thuộc tính của frame
        setTitle("Tạo Phiếu Bảo Hành");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tạo TextArea để nhập "lí do"
        textArea = new JTextArea();
        textArea.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Thiết lập font chữ và kích thước
        textArea.setLineWrap(true); // Tự động xuống dòng khi đạt đến độ rộng của TextArea
        textArea.setWrapStyleWord(true); // Tự động xuống dòng dựa trên từng từ
        JScrollPane scrollPane = new JScrollPane(textArea); // Thêm scroll cho TextArea
        panel.add(scrollPane, BorderLayout.CENTER);
        
        
        // Tạo nút "Xác nhận"
        btnXacNhan = new JButton("Xác nhận");
        panel.add(btnXacNhan, BorderLayout.SOUTH);

        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String liDo = textArea.getText();
                Warranty warranty = new Warranty(selectedExport.getExportInvoiceId(), liDo, "0");	        			
	        if(WarrantyBLL.getInstance().addWarranty(warranty) == false)
                    JOptionPane.showMessageDialog(rootPane, "Lỗi khi thêm vào database");
	        else {
		        			
		   JOptionPane.showMessageDialog(getRootPane(), "Thêm phiếu bảo hành thành công");
	        } 


            }
        });

        // Thêm panel vào frame
        add(panel);
    }

   
}