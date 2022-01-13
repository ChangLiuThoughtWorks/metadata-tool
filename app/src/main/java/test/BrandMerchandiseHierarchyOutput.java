package test;

public class BrandMerchandiseHierarchyOutput {

    private String brandCode;

    private String market;

    public BrandMerchandiseHierarchyOutput() {
    }

    public BrandMerchandiseHierarchyOutput(String brandCode, String market) {
        this.brandCode = brandCode;
        this.market = market;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
