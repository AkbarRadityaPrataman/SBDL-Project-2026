package utsdb4o;

import java.util.ArrayList;
import java.util.List;

public class EBusiness {
    public String businessId;
    public String businessType;
    public double annualRevenue;
    public double industryNorm;

    // Association: EBusiness has many DataCenters
    private List<DataCenter> dataCenters;
    // Association: EBusiness works with many Vendors
    private List<Vendor> vendors;

    public EBusiness() {
        this.dataCenters = new ArrayList<>();
        this.vendors = new ArrayList<>();
    }

    public EBusiness(String businessId, String businessType, double annualRevenue, double industryNorm) {
        this.businessId = businessId;
        this.businessType = businessType;
        this.annualRevenue = annualRevenue;
        this.industryNorm = industryNorm;
        this.dataCenters = new ArrayList<>();
        this.vendors = new ArrayList<>();
    }

    public void generateReport() {
        System.out.println("=== Business Report for " + businessId + " ===");
        System.out.println("Type: " + businessType);
        System.out.println("Annual Revenue: $" + annualRevenue);
        System.out.println("Industry Norm: " + industryNorm + "%");
    }

    public void receiveComplaint(Complaint complaint) {
        System.out.println("[EBusiness] Received complaint: " + complaint.getComplaintId());
    }

    public double getAnnualCost() {
        double total = 0;
        for (DataCenter dc : dataCenters) {
            total += dc.calculateAnnualCost();
        }
        return total;
    }

    // Getters and Setters
    public String getBusinessId() { return businessId; }
    public void setBusinessId(String businessId) { this.businessId = businessId; }

    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }

    public double getAnnualRevenue() { return annualRevenue; }
    public void setAnnualRevenue(double annualRevenue) { this.annualRevenue = annualRevenue; }

    public double getIndustryNorm() { return industryNorm; }
    public void setIndustryNorm(double industryNorm) { this.industryNorm = industryNorm; }

    public List<DataCenter> getDataCenters() { return dataCenters; }
    public void addDataCenter(DataCenter dc) { this.dataCenters.add(dc); }

    public List<Vendor> getVendors() { return vendors; }
    public void addVendor(Vendor vendor) { this.vendors.add(vendor); }

    @Override
    public String toString() {
        return "EBusiness{businessId='" + businessId + "', businessType='" + businessType
                + "', annualRevenue=" + annualRevenue + ", industryNorm=" + industryNorm + "}";
    }
}
