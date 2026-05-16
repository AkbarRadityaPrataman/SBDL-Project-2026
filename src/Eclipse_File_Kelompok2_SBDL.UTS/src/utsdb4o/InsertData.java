package utsdb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import utsdb4o.*;

/**
 * DatabaseManager: manages db4o connection and seeds initial data
 * based on the object diagram from Papyrus.
 */
public class InsertData {

    public static final String DB_FILE = "ebusiness.db4o";

    public static ObjectContainer openDatabase() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        // Cascade on update/delete for nested objects
        config.common().objectClass(EBusiness.class).cascadeOnUpdate(true);
        config.common().objectClass(DataCenter.class).cascadeOnUpdate(true);
        config.common().objectClass(Customer.class).cascadeOnUpdate(true);
        config.common().objectClass(Vendor.class).cascadeOnUpdate(true);
        return Db4oEmbedded.openFile(config, DB_FILE);
    }

    /**
     * Seeds the database with objects from the Papyrus object diagram.
     */
    public static void seedData(ObjectContainer db) {
        // Check if already seeded
        if (db.query(EBusiness.class).size() > 0) {
            System.out.println("[DB] Database already has data. Skipping seed.");
            return;
        }

        System.out.println("[DB] Seeding database with object diagram data...");

        // =========================================================
        // OBJECT: webServer1 : Server (SRV-001)
        // =========================================================
        Server webServer1 = new Server("SRV-001", "Web", "192.168.1.10", "Active");

        // OBJECT: disk01 : DiskDrive (DISK-001)
        DiskDrive disk01 = new DiskDrive("DISK-001", "SSD", 2048, "Healthy");

        // Association: Server has DiskDrive
        webServer1.addDiskDrive(disk01);

        // =========================================================
        // OBJECT: avRec01 : AvailabilityRecord (REC-001)
        // =========================================================
        AvailabilityRecord avRec01 = new AvailabilityRecord("REC-001", 98.5, 9300, 139500.0);

        // =========================================================
        // OBJECT: dc01 : DataCenter (DC-001)
        // =========================================================
        DataCenter dc01 = new DataCenter("DC-001", "Jakarta", 98.5, 99.9, 150.0);
        // Association: DataCenter aggregates Server
        dc01.addServer(webServer1);
        // Association: DataCenter has AvailabilityRecord
        dc01.addAvailabilityRecord(avRec01);

        // =========================================================
        // OBJECT: techCorp : EBusiness (EB-001)
        // =========================================================
        EBusiness techCorp = new EBusiness("EB-001", "Cloud Service", 15000000.0, 99.9);
        // Association: EBusiness has DataCenter
        techCorp.addDataCenter(dc01);

        // =========================================================
        // OBJECT: upgrade01 : SoftwareUpgrade (UPG-001)
        // =========================================================
        SoftwareUpgrade upgrade01 = new SoftwareUpgrade(
                "UPG-001", "Patch OS kernel", 5000000.0, 99.5, "512 GB");

        // =========================================================
        // OBJECT: vendorA : Vendor (VND-001)
        // =========================================================
        Vendor vendorA = new Vendor("VND-001", "TechSupply Inc", "sales@tech.id", 8200.0);
        // Association: Vendor provides SoftwareUpgrade
        vendorA.addSoftwareUpgrade(upgrade01);
        // Association: EBusiness works with Vendor
        techCorp.addVendor(vendorA);

        // =========================================================
        // OBJECT: comp01 : Complaint
        // =========================================================
        Complaint comp01 = new Complaint(
                "CMP-001", "2026-04-10", "Server timeout", "Downtime",
                "Open", false, true, "Server timeout");

        // =========================================================
        // OBJECT: budi : Customer (CUST-001)
        // =========================================================
        Customer Sintia = new Customer("CUST-001", "Putri Sintia", "sintia@gmail.com", "2026-04-01");
        // Association: Customer has Complaint
        Sintia.addComplaint(comp01);

        // =========================================================
        // OBJECT: downEv01 : DowntimeEvent (DT-001)
        // =========================================================
        DowntimeEvent downEv01 = new DowntimeEvent(
                "DT-001", "2026-04-10 01:00", "2026-04-10 03:00",
                2.0, "Disk failure", "WebApp");

        // =========================================================
        // OBJECT: costAnal01 : CostAnalysis (CA-001)
        // =========================================================
        CostAnalysis costAnal01 = new CostAnalysis(
                "CA-001", 394200.0, 268800.0, 14400.0, 125400.0, true);

        // --- Additional sample data for richer queries ---
        // Extra servers
        Server dbServer = new Server("SRV-002", "Database", "192.168.1.20", "Active");
        DiskDrive disk02 = new DiskDrive("DISK-002", "HDD", 4096, "Degraded");
        dbServer.addDiskDrive(disk02);

        DataCenter dc02 = new DataCenter("DC-002", "Surabaya", 97.0, 99.5, 120.0);
        AvailabilityRecord avRec02 = new AvailabilityRecord("REC-002", 97.0, 13140, 210000.0);
        dc02.addServer(dbServer);
        dc02.addAvailabilityRecord(avRec02);

        EBusiness eStore = new EBusiness("EB-002", "E-Commerce", 8000000.0, 99.5);
        eStore.addDataCenter(dc02);

        Vendor vendorB = new Vendor("VND-002", "CloudSolutions Ltd", "info@cloudsol.id", 6500.0);
        SoftwareUpgrade upgrade02 = new SoftwareUpgrade("UPG-002", "DB Cluster Upgrade", 3000000.0, 99.0, "1 TB");
        vendorB.addSoftwareUpgrade(upgrade02);
        eStore.addVendor(vendorB);

        Customer sari = new Customer("CUST-002", "Sari Dewi", "sari@mail.com", "2026-03-15");
        Complaint comp02 = new Complaint("CMP-002", "2026-03-20", "Slow response", "Performance",
                "Resolved", true, false, "DB query timeout");
        sari.addComplaint(comp02);

        DowntimeEvent downEv02 = new DowntimeEvent(
                "DT-002", "2026-03-20 09:00", "2026-03-20 11:30",
                2.5, "Network failure", "Database");

        CostAnalysis costAnal02 = new CostAnalysis(
                "CA-002", 500000.0, 380000.0, 20000.0, 100000.0, true);

        Customer andi = new Customer("CUST-003", "Andi Kurniawan", "andi@biz.id", "2026-02-10");
        Complaint comp03 = new Complaint("CMP-003", "2026-04-01", "Data loss", "Critical",
                "Escalated", false, true, "RAID failure detected");
        andi.addComplaint(comp03);

        // Store all objects
        db.store(techCorp);
        db.store(eStore);
        db.store(Sintia);
        db.store(sari);
        db.store(andi);
        db.store(downEv01);
        db.store(downEv02);
        db.store(costAnal01);
        db.store(costAnal02);
        db.store(avRec01);
        db.store(avRec02);

        db.commit();
        System.out.println("[DB] Seeding complete. Objects stored successfully.");
    }
}