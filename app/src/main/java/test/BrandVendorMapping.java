package test;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BrandVendorMapping {

    private String vendorCode;

    private String brandCode;

    public BrandVendorMapping(String vendorCode, String brandCode) {
        this.vendorCode = vendorCode;
        this.brandCode = brandCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandVendorMapping that = (BrandVendorMapping) o;
        return Objects.equal(vendorCode, that.vendorCode) && Objects.equal(brandCode, that.brandCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendorCode, brandCode);
    }
}
