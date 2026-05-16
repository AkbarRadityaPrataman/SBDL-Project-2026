package utsdb4o;

public class CostAnalysis {
    public String analysisId;
    // PERBAIKAN: Ubah tipe data dari float menjadi double agar konsisten dengan constructor
    public double currentAnnualCost; 
    public double projectedAnnualCost;
    public double upgradeCostPerYear;
    public double netSavings;
    public boolean justified;

    public CostAnalysis() {}

    public CostAnalysis(String analysisId, double currentAnnualCost, double projectedAnnualCost,
                         double upgradeCostPerYear, double netSavings, boolean justified) {
        this.analysisId = analysisId;
        this.currentAnnualCost = currentAnnualCost;
        this.projectedAnnualCost = projectedAnnualCost;
        this.upgradeCostPerYear = upgradeCostPerYear;
        this.netSavings = netSavings;
        this.justified = justified;
    }

    public boolean justifyExpenditure() {
        this.justified = (netSavings > 0);
        return justified;
    }

    public double getNetSavings() { return netSavings; }

    public void compareScenarios(CostAnalysis other) {
        System.out.println("Comparing " + analysisId + " vs " + other.analysisId);
        System.out.println("  Net savings: $" + netSavings + " vs $" + other.netSavings);
    }

    public double calculateROI() {
        if (upgradeCostPerYear == 0) return 0;
        return (netSavings / upgradeCostPerYear) * 100;
    }

    // Getters and Setters
    public String getAnalysisId() { return analysisId; }
    public void setAnalysisId(String analysisId) { this.analysisId = analysisId; }

    public double getCurrentAnnualCost() { return currentAnnualCost; }
    public void setCurrentAnnualCost(double currentAnnualCost) { this.currentAnnualCost = currentAnnualCost; }

    public double getProjectedAnnualCost() { return projectedAnnualCost; }
    public void setProjectedAnnualCost(double projectedAnnualCost) { this.projectedAnnualCost = projectedAnnualCost; }

    public double getUpgradeCostPerYear() { return upgradeCostPerYear; }
    public void setUpgradeCostPerYear(double upgradeCostPerYear) { this.upgradeCostPerYear = upgradeCostPerYear; }

    public void setNetSavings(double netSavings) { this.netSavings = netSavings; }

    public boolean isJustified() { return justified; }
    public void setJustified(boolean justified) { this.justified = justified; }

    @Override
    public String toString() {
        return "CostAnalysis{analysisId='" + analysisId
                + "', currentAnnualCost=$" + currentAnnualCost
                + ", projectedAnnualCost=$" + projectedAnnualCost
                + ", upgradeCostPerYear=$" + upgradeCostPerYear
                + ", netSavings=$" + netSavings
                + ", justified=" + justified + "}";
    }
}