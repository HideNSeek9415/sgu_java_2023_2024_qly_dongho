
package dto;

import java.util.Objects;


public class ThongKeDoanhThuDTO {
    int thoigian; // nam, thang, ngay
    Long doanhthu;


    public ThongKeDoanhThuDTO() {
    }
    
    public ThongKeDoanhThuDTO(int thoigian, Long doanhthu) {
        this.thoigian = thoigian;
        this.doanhthu = doanhthu;
    }
    
    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }


    public Long getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Long doanhthu) {
        this.doanhthu = doanhthu;
    }

}
