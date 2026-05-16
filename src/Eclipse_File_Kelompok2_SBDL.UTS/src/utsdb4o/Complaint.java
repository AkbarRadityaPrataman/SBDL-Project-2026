package utsdb4o;


public class Complaint {
    private String complaintId;
    private String date;           // ISO date string e.g. "2026-04-10"
    private String issue;          // Description of issue
    private String issueType;      // e.g., "Downtime", "Performance", "Billing"
    private String status;         // "Open", "Resolved", "Escalated"
    private boolean resolve;
    private boolean escalate;
    private String logIssue;       // Log message

    public Complaint() {}

    public Complaint(String complaintId, String date, String issue, String issueType,
                     String status, boolean resolve, boolean escalate, String logIssue) {
        this.complaintId = complaintId;
        this.date = date;
        this.issue = issue;
        this.issueType = issueType;
        this.status = status;
        this.resolve = resolve;
        this.escalate = escalate;
        this.logIssue = logIssue;
    }

    public String getComplaintId() { return complaintId; }
    public void setComplaintId(String complaintId) { this.complaintId = complaintId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getIssue() { return issue; }
    public void setIssue(String issue) { this.issue = issue; }

    public String getIssueType() { return issueType; }
    public void setIssueType(String issueType) { this.issueType = issueType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isResolve() { return resolve; }
    public void setResolve(boolean resolve) { this.resolve = resolve; }

    public boolean isEscalate() { return escalate; }
    public void setEscalate(boolean escalate) { this.escalate = escalate; }

    public String getLogIssue() { return logIssue; }
    public void setLogIssue(String logIssue) { this.logIssue = logIssue; }

    @Override
    public String toString() {
        return "Complaint{complaintId='" + complaintId + "', date='" + date
                + "', issue='" + issue + "', issueType='" + issueType
                + "', status='" + status + "', resolve=" + resolve
                + ", escalate=" + escalate + ", logIssue='" + logIssue + "'}";
    }
}
