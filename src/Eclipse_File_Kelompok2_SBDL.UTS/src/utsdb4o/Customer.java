package utsdb4o;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String customerId;
    public String name;
    public String email;
    public String contactDate;  // ISO date string e.g. "2026-04-01"

    // Association: Customer has many Complaints
    private List<Complaint> complaints;

    public Customer() {
        this.complaints = new ArrayList<>();
    }

    public Customer(String customerId, String name, String email, String contactDate) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contactDate = contactDate;
        this.complaints = new ArrayList<>();
    }

    public void submitComplaint(Complaint complaint) {
        complaints.add(complaint);
        System.out.println("[Customer " + name + "] Submitted complaint: " + complaint.getComplaintId());
    }

    public List<Complaint> getComplaintHistory() {
        return complaints;
    }

    public void contactSupport() {
        System.out.println("[Customer " + name + "] Contacting support via " + email);
    }

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContactDate() { return contactDate; }
    public void setContactDate(String contactDate) { this.contactDate = contactDate; }

    public List<Complaint> getComplaints() { return complaints; }
    public void addComplaint(Complaint complaint) { this.complaints.add(complaint); }

    @Override
    public String toString() {
        return "Customer{customerId='" + customerId + "', name='" + name
                + "', email='" + email + "', contactDate='" + contactDate + "'}";
    }
}