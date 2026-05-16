package utsdb4o;

import com.db4o.ObjectContainer;
import utsdb4o.*;
import java.util.Scanner;

/**
 * MainApp: Versi perbaikan untuk mendukung fitur Sorting pada NQ,
 * Update/Delete pada QBE, serta NOT/AND pada SODA.
 */
public class MainApp {

    static ObjectContainer db;
    static NQQuery nqService;
    static QBEQuery qbeService;
    static SODAQuery sodaService;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     E-Business OODB Management System (db4o)        ║");
        System.out.println("║     Kelompok 2 - SBDL UTS (Updated Version)         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        db = InsertData.openDatabase();
        InsertData.seedData(db);

        nqService  = new NQQuery(db);
        qbeService = new QBEQuery(db);
        sodaService = new SODAQuery(db);

        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": menuNativeQuery(); break;
                case "2": menuQBE(); break;
                case "3": menuSODA(); break;
                case "4": menuAddData(); break;
                case "5": menuDeleteData(); break;
                case "6": menuUpdateData(); break;
                case "0":
                    running = false;
                    System.out.println("\n[EXIT] Closing database. Goodbye!");
                    break;
                default:
                    System.out.println("  [!] Invalid option.");
            }
        }
        db.close();
    }

    static void printMainMenu() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  MAIN MENU");
        System.out.println("══════════════════════════════════════════");
        System.out.println("  1. Native Query (NQ) [+ Sorting]");
        System.out.println("  2. Query By Example (QBE) [+ Update/Delete]");
        System.out.println("  3. SODA Query [+ NOT/AND Logic]");
        System.out.println("  4. Add New Data (Create)");
        System.out.println("  5. Delete Data");
        System.out.println("  6. Update Data");
        System.out.println("  0. Exit");
        System.out.print("  Enter choice: ");
    }

    // ─────────── 1. NQ Menu ───────────
    static void menuNativeQuery() {
        System.out.println("\n── Native Query (NQ) ──────────────────────");
        System.out.println("  1. High-Revenue EBusinesses");
        System.out.println("  2. Underperforming DataCenters");
        System.out.println("  3. Escalated & Unresolved Complaints");
        System.out.println("  4. Servers by Status");
        System.out.println("  5. Profitable CostAnalyses");
        System.out.println("  6. Long Downtime Events (Sorted Descending)");
        System.out.println("  0. Back");
        System.out.print("  Choice: ");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1": nqService.findHighRevenueBusinesses(5000000); break;
            case "2": nqService.findUnderperformingDataCenters(); break;
            case "3": nqService.findEscalatedUnresolvedComplaints(); break;
            case "4": nqService.findServersByStatus("Active"); break;
            case "5": nqService.findProfitableAnalyses(100000); break;
            case "6": nqService.findLongDowntimeEventsSorted(1.0); break; // Menggunakan method sorted
            case "0": break;
        }
    }

    // ─────────── 2. QBE Menu ───────────
    static void menuQBE() {
        System.out.println("\n── Query By Example (QBE) ─────────────────");
        System.out.println("  1. SELECT: EBusiness by type");
        System.out.println("  2. SELECT: DataCenter by location");
        System.out.println("  3. UPDATE: Change Complaint Status");
        System.out.println("  4. DELETE: Remove Vendor by Name");
        System.out.println("  0. Back");
        System.out.print("  Choice: ");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1": qbeService.findByBusinessType("Cloud Service"); break;
            case "2": qbeService.findDataCenterByLocation("Jakarta"); break;
            case "3": 
                System.out.print("  Enter old status: "); String oldS = scanner.nextLine();
                System.out.print("  Enter new status: "); String newS = scanner.nextLine();
                qbeService.updateComplaintStatusQBE(oldS, newS); 
                break;
            case "4": 
                System.out.print("  Enter vendor name to delete: ");
                qbeService.deleteVendorByNameQBE(scanner.nextLine()); 
                break;
            case "0": break;
        }
    }

    // ─────────── 3. SODA Menu ───────────
    static void menuSODA() {
        System.out.println("\n── SODA Query ──────────────────────────────");
        System.out.println("  1. WHERE NOT: Find Non-Healthy DiskDrives");
        System.out.println("  2. AND Logic: High Revenue + Specific Type");
        System.out.println("  3. OR Logic: Problematic Drives (Degraded/Failed)");
        System.out.println("  4. SORTING: All Customers by Name");
        System.out.println("  0. Back");
        System.out.print("  Choice: ");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1": sodaService.findUnhealthyDrives(); break;
            case "2": sodaService.findHighRevenueByType("E-Commerce", 10000000); break;
            case "3": sodaService.findProblematicDiskDrives(); break;
            case "4": sodaService.findAllCustomersSortedByName(); break;
            case "0": break;
        }
    }

    // ─────────── Helper / CRUD ───────────
    static void menuAddData() {
        System.out.println("\n  [Add EBusiness]");
        System.out.print("  ID: "); String id = scanner.nextLine();
        System.out.print("  Type: "); String type = scanner.nextLine();
        System.out.print("  Revenue: "); double rev = parseDouble(scanner.nextLine(), 0);
        EBusiness eb = new EBusiness(id, type, rev, 99.9);
        db.store(eb);
        db.commit();
        System.out.println("  [OK] Stored.");
    }

    static void menuDeleteData() {
        System.out.print("\n  Enter customerId to delete: ");
        String cid = scanner.nextLine();
        deleteCustomer(cid);
    }

    static void deleteCustomer(String customerId) {
        // Logika delete (Retrieve then Delete)
        com.db4o.ObjectSet<Customer> result = db.queryByExample(new Customer(customerId, null, null, null));
        if (result.hasNext()) {
            db.delete(result.next());
            db.commit();
            System.out.println("  [OK] Deleted.");
        } else {
            System.out.println("  [!] Not found.");
        }
    }

    static void menuUpdateData() {
        System.out.print("\n  Enter complaintId to resolve: ");
        String id = scanner.nextLine();
        updateComplaintStatus(id, "Resolved");
    }

    static void updateComplaintStatus(String complaintId, String newStatus) {
        Complaint proto = new Complaint();
        proto.setComplaintId(complaintId);
        com.db4o.ObjectSet<Complaint> result = db.queryByExample(proto);
        if (result.hasNext()) {
            Complaint c = result.next();
            c.setStatus(newStatus);
            c.setResolve(true);
            db.store(c);
            db.commit();
            System.out.println("  [OK] Updated.");
        }
    }

    static double parseDouble(String input, double defaultVal) {
        try { return Double.parseDouble(input.trim()); }
        catch (Exception e) { return defaultVal; }
    }
}