package test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserHierarchyImport {

    @ExcelProperty(index = 0)
    private String status;

    @ExcelProperty(index = 1)
    private String brand;

    @ExcelProperty(index = 2)
    private String approvalDepartment;

    @ExcelProperty(index = 3)
    private String firstName;

    @ExcelProperty(index = 4)
    private String lastName;

    @ExcelProperty(index = 6)
    private String BUEmail;

    @ExcelProperty(index = 7)
    private String CSName;

    @ExcelProperty(index = 8)
    private String CSEmail;

    @ExcelProperty(index = 9)
    private String CCName;

    @ExcelProperty(index = 10)
    private String CCEmail;

    @ExcelProperty(index = 11)
    private String AMName;

    @ExcelProperty(index = 12)
    private String AMEmail;

    @ExcelProperty(index = 13)
    private String MName;

    @ExcelProperty(index = 14)
    private String MEmail;

    @ExcelProperty(index = 15)
    private String SMName;

    @ExcelProperty(index = 16)
    private String SMEmail;

    @ExcelProperty(index = 17)
    private String ADName;

    @ExcelProperty(index = 18)
    private String ADEmail;

    @ExcelProperty(index = 19)
    private String DName;

    @ExcelProperty(index = 20)
    private String DEmail;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getApprovalDepartment() {
        return approvalDepartment;
    }

    public void setApprovalDepartment(String approvalDepartment) {
        this.approvalDepartment = approvalDepartment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBUEmail() {
        return BUEmail;
    }

    public void setBUEmail(String BUEmail) {
        this.BUEmail = BUEmail;
    }

    public String getCSName() {
        return CSName;
    }

    public void setCSName(String CSName) {
        this.CSName = CSName;
    }

    public String getCSEmail() {
        return CSEmail;
    }

    public void setCSEmail(String CSEmail) {
        this.CSEmail = CSEmail;
    }

    public String getCCName() {
        return CCName;
    }

    public void setCCName(String CCName) {
        this.CCName = CCName;
    }

    public String getCCEmail() {
        return CCEmail;
    }

    public void setCCEmail(String CCEmail) {
        this.CCEmail = CCEmail;
    }

    public String getAMName() {
        return AMName;
    }

    public void setAMName(String AMName) {
        this.AMName = AMName;
    }

    public String getAMEmail() {
        return AMEmail;
    }

    public void setAMEmail(String AMEmail) {
        this.AMEmail = AMEmail;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getMEmail() {
        return MEmail;
    }

    public void setMEmail(String MEmail) {
        this.MEmail = MEmail;
    }

    public String getSMName() {
        return SMName;
    }

    public void setSMName(String SMName) {
        this.SMName = SMName;
    }

    public String getSMEmail() {
        return SMEmail;
    }

    public void setSMEmail(String SMEmail) {
        this.SMEmail = SMEmail;
    }

    public String getADName() {
        return ADName;
    }

    public void setADName(String ADName) {
        this.ADName = ADName;
    }

    public String getADEmail() {
        return ADEmail;
    }

    public void setADEmail(String ADEmail) {
        this.ADEmail = ADEmail;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getDEmail() {
        return DEmail;
    }

    public void setDEmail(String DEmail) {
        this.DEmail = DEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserHierarchyImport that = (UserHierarchyImport) o;
        return Objects.equal(status, that.status) && Objects.equal(brand, that.brand) && Objects.equal(approvalDepartment, that.approvalDepartment) && Objects.equal(firstName, that.firstName) && Objects.equal(lastName, that.lastName) && Objects.equal(BUEmail, that.BUEmail) && Objects.equal(CSName, that.CSName) && Objects.equal(CSEmail, that.CSEmail) && Objects.equal(CCName, that.CCName) && Objects.equal(CCEmail, that.CCEmail) && Objects.equal(AMName, that.AMName) && Objects.equal(AMEmail, that.AMEmail) && Objects.equal(MName, that.MName) && Objects.equal(MEmail, that.MEmail) && Objects.equal(SMName, that.SMName) && Objects.equal(SMEmail, that.SMEmail) && Objects.equal(ADName, that.ADName) && Objects.equal(ADEmail, that.ADEmail) && Objects.equal(DName, that.DName) && Objects.equal(DEmail, that.DEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status, brand, approvalDepartment, firstName, lastName, BUEmail, CSName, CSEmail, CCName, CCEmail, AMName, AMEmail, MName, MEmail, SMName, SMEmail, ADName, ADEmail, DName, DEmail);
    }
}
