package test;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jarvis
 */
public class UserHierarchyOutput {

    private String brand;

    private String approvalDepartment;

    private String name;

    private String roleName;

    private String email;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserHierarchyOutput(String brand, String approvalDepartment, String name, String roleName, String email) {
        this.brand = brand;
        this.approvalDepartment = approvalDepartment;
        this.name = name;
        this.roleName = roleName;
        this.email = email;
    }

    public boolean isValid() {
        return this.name != null || this.email != null;
    }
}
