package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Vendor {

    private String vendorCode;

    private String vendorName;

    public Vendor(String vendorCode, String vendorName) {
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equal(vendorCode, vendor.vendorCode) && Objects.equal(vendorName, vendor.vendorName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendorCode, vendorName);
    }
}
