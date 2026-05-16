package utsdb4o;

public class DowntimeEvent {
    public String eventId;
    public String startTime;      // e.g., "2026-04-10 01:00"
    public String endTime;        // e.g., "2026-04-10 03:00"
    public double durationHours;
    public String cause;
    public String affectedService;

    public DowntimeEvent() {}

    public DowntimeEvent(String eventId, String startTime, String endTime,
                          double durationHours, String cause, String affectedService) {
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationHours = durationHours;
        this.cause = cause;
        this.affectedService = affectedService;
    }

    public double getDurationHours() { return durationHours; }

    public double getCostImpact(double hourlyCost) {
        return durationHours * hourlyCost;
    }

    public void triggerComplaint() {
        System.out.println("[DowntimeEvent " + eventId + "] Triggering complaint for: " + affectedService);
    }

    public void logEvent() {
        System.out.println("[DowntimeEvent " + eventId + "] " + startTime + " → " + endTime
                + " | Cause: " + cause + " | Affected: " + affectedService);
    }

    // Getters and Setters
    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public void setDurationHours(double durationHours) { this.durationHours = durationHours; }

    public String getCause() { return cause; }
    public void setCause(String cause) { this.cause = cause; }

    public String getAffectedService() { return affectedService; }
    public void setAffectedService(String affectedService) { this.affectedService = affectedService; }

    @Override
    public String toString() {
        return "DowntimeEvent{eventId='" + eventId + "', startTime='" + startTime
                + "', endTime='" + endTime + "', durationHours=" + durationHours
                + ", cause='" + cause + "', affectedService='" + affectedService + "'}";
    }
}
