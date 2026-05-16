package utsdb4o;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    public String centerId;
    public String location;
    public double currentAvailability;
    public double targetAvailability;
    public double hourlyCost;

    // Association: DataCenter has many Servers (aggregation)
    private List<Server> servers;
    // Association: DataCenter has many AvailabilityRecords
    private List<AvailabilityRecord> availabilityRecords;

    public DataCenter() {
        this.servers = new ArrayList<>();
        this.availabilityRecords = new ArrayList<>();
    }

    public DataCenter(String centerId, String location, double currentAvailability,
                      double targetAvailability, double hourlyCost) {
        this.centerId = centerId;
        this.location = location;
        this.currentAvailability = currentAvailability;
        this.targetAvailability = targetAvailability;
        this.hourlyCost = hourlyCost;
        this.servers = new ArrayList<>();
        this.availabilityRecords = new ArrayList<>();
    }

    public double calculateDowntime() {
        // Downtime hours per year based on availability
        double uptimeFraction = currentAvailability / 100.0;
        double downtimeHours = (1 - uptimeFraction) * 8760; // 8760 hours/year
        return downtimeHours;
    }

    public double calculateAnnualCost() {
        return hourlyCost * 8760;
    }

    public void updateAvailability(double newAvailability) {
        this.currentAvailability = newAvailability;
    }

    public double getHourlyCost() { return hourlyCost; }

    // Getters and Setters
    public String getCenterId() { return centerId; }
    public void setCenterId(String centerId) { this.centerId = centerId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getCurrentAvailability() { return currentAvailability; }
    public void setCurrentAvailability(double currentAvailability) { this.currentAvailability = currentAvailability; }

    public double getTargetAvailability() { return targetAvailability; }
    public void setTargetAvailability(double targetAvailability) { this.targetAvailability = targetAvailability; }

    public void setHourlyCost(double hourlyCost) { this.hourlyCost = hourlyCost; }

    public List<Server> getServers() { return servers; }
    public void addServer(Server server) { this.servers.add(server); }

    public List<AvailabilityRecord> getAvailabilityRecords() { return availabilityRecords; }
    public void addAvailabilityRecord(AvailabilityRecord record) { this.availabilityRecords.add(record); }

    @Override
    public String toString() {
        return "DataCenter{centerId='" + centerId + "', location='" + location
                + "', currentAvailability=" + currentAvailability
                + "%, targetAvailability=" + targetAvailability
                + "%, hourlyCost=" + hourlyCost + "}";
    }
}