package utsdb4o;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public String serverId;
    public String type;
    public String ipAddress;
    public String status;

    // Association: Server has many DiskDrives
    private List<DiskDrive> diskDrives;

    public Server() {
        this.diskDrives = new ArrayList<>();
    }

    public Server(String serverId, String type, String ipAddress, String status) {
        this.serverId = serverId;
        this.type = type;
        this.ipAddress = ipAddress;
        this.status = status;
        this.diskDrives = new ArrayList<>();
    }

    public String getStatus() { return status; }

    public void restart() {
        System.out.println("[Server " + serverId + "] Restarting...");
        this.status = "Restarting";
    }

    public void monitor() {
        System.out.println("[Server " + serverId + "] Status: " + status + " | IP: " + ipAddress);
    }

    // Getters and Setters
    public String getServerId() { return serverId; }
    public void setServerId(String serverId) { this.serverId = serverId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public void setStatus(String status) { this.status = status; }

    public List<DiskDrive> getDiskDrives() { return diskDrives; }
    public void addDiskDrive(DiskDrive disk) { this.diskDrives.add(disk); }

    @Override
    public String toString() {
        return "Server{serverId='" + serverId + "', type='" + type
                + "', ipAddress='" + ipAddress + "', status='" + status + "'}";
    }
}