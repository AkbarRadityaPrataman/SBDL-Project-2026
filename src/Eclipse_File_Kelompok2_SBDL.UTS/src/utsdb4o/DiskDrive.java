package utsdb4o;

public class DiskDrive {
    public String driveId;
    public String type;       // e.g., "SSD", "HDD"
    public int capacity;      // in GB
    public String status;     // e.g., "Healthy", "Degraded", "Failed"

    public DiskDrive() {}

    public DiskDrive(String driveId, String type, int capacity, String status) {
        this.driveId = driveId;
        this.type = type;
        this.capacity = capacity;
        this.status = status;
    }

    public void mirror() {
        System.out.println("[DiskDrive " + driveId + "] Mirroring data...");
    }

    public int checkCapacity() {
        System.out.println("[DiskDrive " + driveId + "] Capacity: " + capacity + " GB | Status: " + status);
        return capacity;
    }

    public void expand(int additionalGB) {
        this.capacity += additionalGB;
        System.out.println("[DiskDrive " + driveId + "] Expanded by " + additionalGB + " GB. New capacity: " + capacity + " GB");
    }

    // Getters and Setters
    public String getDriveId() { return driveId; }
    public void setDriveId(String driveId) { this.driveId = driveId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "DiskDrive{driveId='" + driveId + "', type='" + type
                + "', capacity=" + capacity + " GB, status='" + status + "'}";
    }
}