package utsdb4o;

public class SoftwareUpgrade {
    public String upgradeId;
    public String description;
    public double estimateMonthlyCost;   // in USD
    public double expectedAvailability;  // e.g., 99.5 (percent)
    public String diskCapacityExpansion; // e.g., "512 GB"

    public SoftwareUpgrade() {}

    public SoftwareUpgrade(String upgradeId, String description, double estimateMonthlyCost,
                            double expectedAvailability, String diskCapacityExpansion) {
        this.upgradeId = upgradeId;
        this.description = description;
        this.estimateMonthlyCost = estimateMonthlyCost;
        this.expectedAvailability = expectedAvailability;
        this.diskCapacityExpansion = diskCapacityExpansion;
    }

    public void apply() {
        System.out.println("[SoftwareUpgrade " + upgradeId + "] Applying: " + description);
    }

    public double getExpectedAvailGain(double currentAvailability) {
        return expectedAvailability - currentAvailability;
    }

    public double getAnnualCost() {
        return estimateMonthlyCost * 12;
    }

    public void rollback() {
        System.out.println("[SoftwareUpgrade " + upgradeId + "] Rolling back: " + description);
    }

    // Getters and Setters
    public String getUpgradeId() { return upgradeId; }
    public void setUpgradeId(String upgradeId) { this.upgradeId = upgradeId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getEstimateMonthlyCost() { return estimateMonthlyCost; }
    public void setEstimateMonthlyCost(double estimateMonthlyCost) { this.estimateMonthlyCost = estimateMonthlyCost; }

    public double getExpectedAvailability() { return expectedAvailability; }
    public void setExpectedAvailability(double expectedAvailability) { this.expectedAvailability = expectedAvailability; }

    public String getDiskCapacityExpansion() { return diskCapacityExpansion; }
    public void setDiskCapacityExpansion(String diskCapacityExpansion) { this.diskCapacityExpansion = diskCapacityExpansion; }

    @Override
    public String toString() {
        return "SoftwareUpgrade{upgradeId='" + upgradeId + "', description='" + description
                + "', estimateMonthlyCost=" + estimateMonthlyCost
                + ", expectedAvailability=" + expectedAvailability
                + "%, diskCapacityExpansion='" + diskCapacityExpansion + "'}";
    }
}