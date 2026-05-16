package utsdb4o;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
    public String vendorId;
    public String vendorName;
    public String contactInfo;
    public double proposeMonthlyCost;

    // Association: Vendor provides many SoftwareUpgrades
    private List<SoftwareUpgrade> softwareUpgrades;

    public Vendor() {
        this.softwareUpgrades = new ArrayList<>();
    }

    public Vendor(String vendorId, String vendorName, String contactInfo, double proposeMonthlyCost) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contactInfo = contactInfo;
        this.proposeMonthlyCost = proposeMonthlyCost;
        this.softwareUpgrades = new ArrayList<>();
    }

    public void propose() {
        System.out.println("[Vendor " + vendorName + "] Proposing monthly cost: $" + proposeMonthlyCost);
    }

    public double estimateImprovement() {
        // Estimate % improvement as a function of cost
        return proposeMonthlyCost / 1000.0;
    }

    public double getMonthlyCost() { return proposeMonthlyCost; }

    public double getAnnualCost() { return proposeMonthlyCost * 12; }

    // Getters and Setters
    public String getVendorId() { return vendorId; }
    public void setVendorId(String vendorId) { this.vendorId = vendorId; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public double getProposeMonthlyCost() { return proposeMonthlyCost; }
    public void setProposeMonthlyCost(double proposeMonthlyCost) { this.proposeMonthlyCost = proposeMonthlyCost; }

    public List<SoftwareUpgrade> getSoftwareUpgrades() { return softwareUpgrades; }
    public void addSoftwareUpgrade(SoftwareUpgrade upgrade) { this.softwareUpgrades.add(upgrade); }

    @Override
    public String toString() {
        return "Vendor{vendorId='" + vendorId + "', vendorName='" + vendorName
                + "', contactInfo='" + contactInfo + "', proposeMonthlyCost=" + proposeMonthlyCost + "}";
    }
}
