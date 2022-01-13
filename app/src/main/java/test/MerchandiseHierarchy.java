package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MerchandiseHierarchy {

    @ExcelProperty(index = 30)
    private String MaterialGroupCode;

    @ExcelProperty(index = 31)
    private String market;

    @ExcelProperty(index = 32)
    private String range;

    @ExcelProperty(index = 33)
    private String category;

    @ExcelProperty(index = 34)
    private String target;

    @ExcelProperty(index = 35)
    private String nature;

    public String getMaterialGroupCode() {
        return MaterialGroupCode;
    }

    public void setMaterialGroupCode(String materialGroupCode) {
        MaterialGroupCode = materialGroupCode;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchandiseHierarchy that = (MerchandiseHierarchy) o;
        return Objects.equal(MaterialGroupCode, that.MaterialGroupCode) && Objects.equal(market, that.market) && Objects.equal(range, that.range) && Objects.equal(category, that.category) && Objects.equal(target, that.target) && Objects.equal(nature, that.nature);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(MaterialGroupCode, market, range, category, target, nature);
    }
}
