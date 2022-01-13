/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package test;


import com.alibaba.excel.EasyExcelFactory;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
public class App {

    static final String FILE_PATH = "/Users/jarvis/IdeaProjects/test/app/src/main/file";
    static final String DATABASE_FILE_NAME = "CN_DATABASE.xlsx";
    static final String BRAND_FILE_NAME = "brand name list.xlsx";
    static final String BRAND_FILE_NAME_LOWER_CASE = "brand name list(same as in database).xlsx";
    static final String BRAND_DATA_FILE_NAME = "brand data.xlsx";
    static final String USER_HIERARCHY_FILE_NAME = "user-hierarchy.xlsx";
    static final String BRAND_USER = "cn.brand_user";
    static final String CATEGORY_SPECIALIST = "cn.category_specialist";
    static final String CATEGORY_COORDINATOR = "cn.category_coordinator";
    static final String CATEGORY_ASSOCIATE_MANAGER = "cn.category_associate_manager";
    static final String CATEGORY_MANAGER = "cn.category_manager";
    static final String CATEGORY_SENIOR_MANAGER = "cn.category_senior_manager";
    static final String CATEGORY_ASSOCIATE_DIRECTOR = "cn.category_associate_director";
    static final String CATEGORY_DIRECTOR = "cn.category_director";

    public static void main(String[] args) throws Exception {
        printMessage();
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        while (operation != 7) {
            switch (operation) {
                case 1:
                    brand();
                    break;
                case 2:
                    vendor();
                    break;
                case 3:
                    brandVendorMapping();
                    break;
                case 4:
                    merchandisingHierarchy();
                    break;
                case 5:
                    brandMerchandisingHierarchyMapping();
                    break;
                case 6:
                    userHierarchy();
                    break;
                default:
                    break;
            }
            Thread.sleep(2000);
            printMessage();
            operation = scanner.nextInt();
        }

    }


    public static void brand() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Brand> subBrandList = getSpecificBrandData().stream()
                .filter(brandData -> brandData.getSubBrandCode() != null)
                .map(brandData -> new Brand(brandData.getBrandCode(), brandData.getBrandName(), brandData.getSubBrandCode(), brandData.getSubBrandName()))
                .distinct()
                .collect(Collectors.toList());
        DataListener dataListenerBrandName = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + BRAND_FILE_NAME_LOWER_CASE, BrandName.class, dataListenerBrandName).sheet().doRead();
        List<String> brandNameList = dataListenerBrandName.getData().stream()
                .map(BrandName.class::cast)
                .distinct()
                .map(BrandName::getName)
                .collect(Collectors.toList());
        DataListener dataListenerDatabase = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + DATABASE_FILE_NAME, Brand.class, dataListenerDatabase).sheet().doRead();
        List<Brand> brandList = dataListenerDatabase.getData().stream()
                .map(Brand.class::cast)
                .distinct()
                .filter(brand -> brandNameList.contains(brand.getBrandName()))
                .collect(Collectors.toList());
        brandList.addAll(subBrandList);
        File file = new File(FILE_PATH + File.separator + "brand.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<Brand> beanToCsv = new StatefulBeanToCsvBuilder<Brand>(writer).build();
        beanToCsv.write(brandList);
        writer.close();
    }

    public static void vendor() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Vendor> vendorList = getSpecificBrandData().stream()
                .map(brandData -> new Vendor(brandData.getVendorCode(), brandData.getVendorName()))
                .distinct()
                .collect(Collectors.toList());
        File file = new File(FILE_PATH + File.separator + "vendor.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<Vendor> beanToCsv = new StatefulBeanToCsvBuilder<Vendor>(writer).build();
        beanToCsv.write(vendorList);
        writer.close();
    }

    public static void brandVendorMapping() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<BrandData> brandDataList = getSpecificBrandData();
        List<BrandVendorMapping> brandVendorMappingList = brandDataList.stream()
                .filter(brandData -> Objects.isNull(brandData.getSubBrandCode()))
                .map(brandData -> new BrandVendorMapping(brandData.getVendorCode(), brandData.getBrandCode()))
                .distinct()
                .collect(Collectors.toList());
        brandDataList.stream()
                .filter(brandData -> Objects.nonNull(brandData.getBrandCode()))
                .forEach(brandData -> {
                    if (isValid(brandData.getBrandName())) {
                        brandVendorMappingList.add(new BrandVendorMapping(brandData.getVendorCode(), brandData.getSubBrandCode()));
                    }
                });
        File file = new File(FILE_PATH + File.separator + "brand-vendor-mapping.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<BrandVendorMapping> beanToCsv = new StatefulBeanToCsvBuilder<BrandVendorMapping>(writer).build();
        beanToCsv.write(brandVendorMappingList);
        writer.close();
    }

    public static void merchandisingHierarchy() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        DataListener dataListener = new DataListener();
        List<String> marketList = Arrays.asList("SELECTIVE", "EXCLUSIVE", "MASS MARKET");
        EasyExcelFactory.read(FILE_PATH + File.separator + DATABASE_FILE_NAME, MerchandiseHierarchy.class, dataListener).sheet().doRead();
        List<MerchandiseHierarchy> merchandiseHierarchyList = dataListener.getData().stream()
                .map(MerchandiseHierarchy.class::cast)
                .distinct()
                .filter(merchandiseHierarchy -> marketList.contains(merchandiseHierarchy.getMarket()))
                .collect(Collectors.toList());
        File file = new File(FILE_PATH + File.separator + "merchandise-hierarchy.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<MerchandiseHierarchy> beanToCsv = new StatefulBeanToCsvBuilder<MerchandiseHierarchy>(writer).build();
        beanToCsv.write(merchandiseHierarchyList);
        writer.close();
    }

    public static void brandMerchandisingHierarchyMapping() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        DataListener dataListenerBrandName = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + BRAND_FILE_NAME_LOWER_CASE, BrandName.class, dataListenerBrandName).sheet().doRead();
        List<String> brandNameList = dataListenerBrandName.getData().stream()
                .map(BrandName.class::cast)
                .distinct()
                .map(BrandName::getName)
                .collect(Collectors.toList());
        DataListener dataListenerDatabase = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + DATABASE_FILE_NAME, BrandMerchandiseHierarchyMapping.class, dataListenerDatabase).sheet().doRead();
        List<BrandMerchandiseHierarchyOutput> brandMerchandiseHierarchyMappingList = dataListenerDatabase.getData().stream()
                .map(BrandMerchandiseHierarchyMapping.class::cast)
                .distinct()
                .filter(brandMerchandiseHierarchyMapping -> brandNameList.contains(brandMerchandiseHierarchyMapping.getBrandName()))
                .map(brandMerchandiseHierarchyMapping -> new BrandMerchandiseHierarchyOutput(brandMerchandiseHierarchyMapping.getBrandCode(), brandMerchandiseHierarchyMapping.getMarket()))
                .collect(Collectors.toList());
        File file = new File(FILE_PATH + File.separator + "brand-merchandise-hierarchy-mapping.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<BrandMerchandiseHierarchyOutput> beanToCsv = new StatefulBeanToCsvBuilder<BrandMerchandiseHierarchyOutput>(writer).build();
        beanToCsv.write(brandMerchandiseHierarchyMappingList);
        writer.close();
    }

    public static void userHierarchy() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        DataListener dataListenerBrandName = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + USER_HIERARCHY_FILE_NAME, UserHierarchyImport.class, dataListenerBrandName).sheet().doRead();
        List<UserHierarchyOutput> userHierarchyList = new ArrayList<>();
        dataListenerBrandName.getData().stream()
                .map(UserHierarchyImport.class::cast)
                .filter(userHierarchyImport -> "Active".equals(userHierarchyImport.getStatus()))
                .distinct()
                .forEach(userHierarchyImport -> {
                    String brandUserName = userHierarchyImport.getFirstName() + " " + userHierarchyImport.getLastName();
                    String brand = userHierarchyImport.getBrand();
                    String approvalDepartment = userHierarchyImport.getApprovalDepartment();
                    UserHierarchyOutput brandUser = new UserHierarchyOutput(brand, approvalDepartment,
                            brandUserName, BRAND_USER, userHierarchyImport.getBUEmail());
                    if (brandUser.isValid()) {
                        userHierarchyList.add(brandUser);
                    }
                    UserHierarchyOutput categorySpecialist = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getCSName(), CATEGORY_SPECIALIST, userHierarchyImport.getCSEmail());
                    if (categorySpecialist.isValid()) {
                        userHierarchyList.add(categorySpecialist);
                    }
                    UserHierarchyOutput categoryCoordinator = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getCCName(), CATEGORY_COORDINATOR, userHierarchyImport.getCCEmail());
                    if (categoryCoordinator.isValid()) {
                        userHierarchyList.add(categoryCoordinator);
                    }
                    UserHierarchyOutput categoryAssociateManager = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getAMName(), CATEGORY_ASSOCIATE_MANAGER, userHierarchyImport.getAMEmail());
                    if (categoryAssociateManager.isValid()) {
                        userHierarchyList.add(categoryAssociateManager);
                    }
                    UserHierarchyOutput categoryManager = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getMName(), CATEGORY_MANAGER, userHierarchyImport.getMEmail());
                    if (categoryManager.isValid()) {
                        userHierarchyList.add(categoryManager);
                    }
                    UserHierarchyOutput categorySeniorManager = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getSMName(), CATEGORY_SENIOR_MANAGER, userHierarchyImport.getSMEmail());
                    if (categorySeniorManager.isValid()) {
                        userHierarchyList.add(categorySeniorManager);
                    }
                    UserHierarchyOutput categoryAssociateDirector = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getADName(), CATEGORY_ASSOCIATE_DIRECTOR, userHierarchyImport.getADEmail());
                    if (categoryAssociateDirector.isValid()) {
                        userHierarchyList.add(categoryAssociateDirector);
                    }
                    UserHierarchyOutput categoryDirector = new UserHierarchyOutput(brand, approvalDepartment,
                            userHierarchyImport.getDName(), CATEGORY_DIRECTOR, userHierarchyImport.getDEmail());
                    if (categoryDirector.isValid()) {
                        userHierarchyList.add(categoryDirector);
                    }
                });
        userHierarchyList.forEach(userHierarchyOutput -> {
            if ("MAKEUP".equals(userHierarchyOutput.getApprovalDepartment())) {
                userHierarchyOutput.setApprovalDepartment("MAKE_UP");
            }
            userHierarchyOutput.setBrand(userHierarchyOutput.getBrand().toUpperCase());
        });
        File file = new File(FILE_PATH + File.separator + "user-hierarchy.csv");
        Writer writer = new FileWriter(file, StandardCharsets.UTF_8);
        StatefulBeanToCsv<UserHierarchyOutput> beanToCsv = new StatefulBeanToCsvBuilder<UserHierarchyOutput>(writer).build();
        beanToCsv.write(userHierarchyList);
        writer.close();
    }

    public static List<BrandData> getSpecificBrandData() {
        DataListener dataListenerBrandData = new DataListener();
        EasyExcelFactory.read(FILE_PATH + File.separator + BRAND_DATA_FILE_NAME, BrandData.class, dataListenerBrandData).sheet().doRead();
        return dataListenerBrandData.getData().stream()
                .map(BrandData.class::cast)
                .distinct()
                .collect(Collectors.toList());
    }

    public static boolean isValid(String brandName) {
        return "GWP".equals(brandName) || "CHINA PLV".equals(brandName);
    }

    public static void printMessage() {
        System.out.println("请选择需要转化的文件：");
        System.out.println("1:\tbrand");
        System.out.println("2:\tvendor");
        System.out.println("3:\tbrand-vendor-mapping");
        System.out.println("4:\tmerchandising-hierarchy");
        System.out.println("5:\tbrand-merchandising-hierarchy-mapping");
        System.out.println("6:\tuser-hierarchy");
        System.out.println("7:\texit");
        System.out.println();
    }
}