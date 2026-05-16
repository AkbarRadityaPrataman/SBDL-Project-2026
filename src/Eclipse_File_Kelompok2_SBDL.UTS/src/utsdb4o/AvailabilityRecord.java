package utsdb4o;

public class AvailabilityRecord {
    public String recordId;
    public double availabilityPercent;  // e.g., 98.5
    public int downtimeMinutes;          // e.g., 9300
    public double costPerYear;           // in USD

    public AvailabilityRecord() {}

    public AvailabilityRecord(String recordId, double availabilityPercent,
                               int downtimeMinutes, double costPerYear) {
        this.recordId = recordId;
        this.availabilityPercent = availabilityPercent;
        this.downtimeMinutes = downtimeMinutes;
        this.costPerYear = costPerYear;
    }

    public double getCostPerYear() { return costPerYear; }

    public double getHourlyCost() {
        // costPerYear / 8760 hours
        return costPerYear / 8760.0;
    }

    public boolean compareToStandard(double standardPercent) {
        return availabilityPercent >= standardPercent;
    }

    public double getDowntimeHours() {
        return downtimeMinutes / 60.0;
    }

    // Getters and Setters
    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public double getAvailabilityPercent() { return availabilityPercent; }
    public void setAvailabilityPercent(double availabilityPercent) { this.availabilityPercent = availabilityPercent; }

    public int getDowntimeMinutes() { return downtimeMinutes; }
    public void setDowntimeMinutes(int downtimeMinutes) { this.downtimeMinutes = downtimeMinutes; }

    public void setCostPerYear(double costPerYear) { this.costPerYear = costPerYear; }

    @Override
    public String toString() {
        return "AvailabilityRecord{recordId='" + recordId + "', availabilityPercent=" + availabilityPercent
                + "%, downtimeMinutes=" + downtimeMinutes + ", costPerYear=$" + costPerYear + "}";
    }
}