package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Brand {

    @ExcelProperty(index = 3)
    private String brandCode;

    @ExcelProperty(index = 4)
    private String brandName;

    @ExcelProperty(index = 5)
    private String subBrandCode;

    @ExcelProperty(index = 6)
    private String subBrandName;

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

    public Brand(String brandCode, String brandName, String subBrandCode, String subBrandName) {
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.subBrandCode = subBrandCode;
        this.subBrandName = subBrandName;
    }

    public Brand() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equal(brandCode, brand.brandCode) && Objects.equal(brandName, brand.brandName) && Objects.equal(subBrandCode, brand.subBrandCode) && Objects.equal(subBrandName, brand.subBrandName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(brandCode, brandName, subBrandCode, subBrandName);
    }
}
