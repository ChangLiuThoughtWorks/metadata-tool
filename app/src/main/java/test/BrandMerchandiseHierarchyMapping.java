package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BrandMerchandiseHierarchyMapping {

    @ExcelProperty(index = 3)
    private String brandCode;

    @ExcelProperty(index = 4)
    private String brandName;

    @ExcelProperty(index = 31)
    private String market;

    public BrandMerchandiseHierarchyMapping(String brandCode, String brandName, String market) {
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.market = market;
    }

    public BrandMerchandiseHierarchyMapping() {
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandMerchandiseHierarchyMapping that = (BrandMerchandiseHierarchyMapping) o;
        return Objects.equal(brandCode, that.brandCode) && Objects.equal(brandName, that.brandName) && Objects.equal(market, that.market);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(brandCode, brandName, market);
    }
}
