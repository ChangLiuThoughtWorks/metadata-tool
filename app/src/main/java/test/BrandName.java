package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BrandName {

    @ExcelProperty(index = 0)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandName brandName = (BrandName) o;
        return Objects.equal(name, brandName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
