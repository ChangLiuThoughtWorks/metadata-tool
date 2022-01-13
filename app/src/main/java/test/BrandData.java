package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BrandData {

    @ExcelProperty(index = 0)
    private String vendorCode;

    @ExcelProperty(index = 1)
    private String vendorName;

    @ExcelProperty(index = 2)
    private String brandCode;

    @ExcelProperty(index = 3)
    private String brandName;

    @ExcelProperty(index = 4)
    private String subBrandCode;

    @ExcelProperty(index = 5)
    private String subBrandName;

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

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSubBrandCode() {
        return subBrandCode;
    }

    public void setSubBrandCode(String subBrandCode) {
        this.subBrandCode = subBrandCode;
    }

    public String getSubBrandName() {
        return subBrandName;
    }

    public void setSubBrandName(String subBrandName) {
        this.subBrandName = subBrandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandData brandData = (BrandData) o;
        return Objects.equal(vendorCode, brandData.vendorCode) && Objects.equal(vendorName, brandData.vendorName) && Objects.equal(brandCode, brandData.brandCode) && Objects.equal(brandName, brandData.brandName) && Objects.equal(subBrandCode, brandData.subBrandCode) && Objects.equal(subBrandName, brandData.subBrandName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendorCode, vendorName, brandCode, brandName, subBrandCode, subBrandName);
    }
}
