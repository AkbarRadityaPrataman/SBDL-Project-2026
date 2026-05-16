package utsdb4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import utsdb4o.*;

import java.util.List;
import java.util.ArrayList;

/**
 * QBEQuery: Demonstrasi teknik Query By Example (QBE) menggunakan db4o.
 * Sesuai ketentuan: Minimal 6 query yang mencakup SELECT, UPDATE, dan DELETE.
 */
public class QBEQuery {

    private ObjectContainer db;

    public QBEQuery(ObjectContainer db) {
        this.db = db;
    }

    // --- 1. SELECT QUERIES ---

    /**
     * QBE SELECT 1: Mencari EBusiness berdasarkan businessType
     */
    public List<EBusiness> findByBusinessType(String businessType) {
        System.out.println("\n[QBE SELECT] Searching EBusiness with businessType = '" + businessType + "'");
        EBusiness prototype = new EBusiness();
        prototype.setBusinessType(businessType);
        
        ObjectSet<EBusiness> result = db.queryByExample(prototype);
        return displayAndReturn(result);
    }

    /**
     * QBE SELECT 2: Mencari DataCenter berdasarkan lokasi
     */
    public List<DataCenter> findDataCenterByLocation(String location) {
        System.out.println("\n[QBE SELECT] Searching DataCenter in: '" + location + "'");
        DataCenter prototype = new DataCenter();
        prototype.setLocation(location);
        
        ObjectSet<DataCenter> result = db.queryByExample(prototype);
        return displayAndReturn(result);
    }

    /**
     * QBE SELECT 3: Mencari Server berdasarkan tipe (Web/Database/dll)
     */
    public List<Server> findServerByType(String type) {
        System.out.println("\n[QBE SELECT] Searching Server with type = '" + type + "'");
        Server prototype = new Server();
        prototype.setType(type);
        
        ObjectSet<Server> result = db.queryByExample(prototype);
        return displayAndReturn(result);
    }

    /**
     * QBE SELECT 4: Mencari Customer berdasarkan email spesifik
     */
    public List<Customer> findCustomerByEmail(String email) {
        System.out.println("\n[QBE SELECT] Searching Customer with email = '" + email + "'");
        Customer prototype = new Customer();
        prototype.setEmail(email);
        
        ObjectSet<Customer> result = db.queryByExample(prototype);
        return displayAndReturn(result);
    }


    // --- 2. UPDATE QUERIES ---

    /**
     * QBE UPDATE 5: Mencari Complaint berdasarkan status lama, lalu mengubahnya
     */
    public void updateComplaintStatusQBE(String oldStatus, String newStatus) {
        System.out.println("\n[QBE UPDATE] Changing Complaint Status from '" + oldStatus + "' to '" + newStatus + "'");
        Complaint prototype = new Complaint();
        prototype.setStatus(oldStatus);
        
        ObjectSet<Complaint> result = db.queryByExample(prototype);
        if (result.isEmpty()) {
            System.out.println("  [!] No complaints found with status: " + oldStatus);
        } else {
            while (result.hasNext()) {
                Complaint c = result.next();
                c.setStatus(newStatus);
                // Jika status diubah ke 'Resolved', set juga boolean flag-nya
                if (newStatus.equalsIgnoreCase("Resolved")) {
                    c.setResolve(true);
                }
                db.store(c); // Update objek ke database
                System.out.println("    [Updated] -> " + c);
            }
            db.commit(); // Simpan perubahan secara permanen
            System.out.println("  [OK] Update successful.");
        }
    }


    // --- 3. DELETE QUERIES ---

    /**
     * QBE DELETE 6: Mencari Vendor berdasarkan nama, lalu menghapusnya
     */
    public void deleteVendorByNameQBE(String vendorName) {
        System.out.println("\n[QBE DELETE] Deleting Vendor with name: '" + vendorName + "'");
        Vendor prototype = new Vendor();
        prototype.setVendorName(vendorName);
        
        ObjectSet<Vendor> result = db.queryByExample(prototype);
        if (result.isEmpty()) {
            System.out.println("  [!] No vendor found with name: " + vendorName);
        } else {
            while (result.hasNext()) {
                Vendor v = result.next();
                db.delete(v); // Hapus objek dari database
                System.out.println("    [Deleted] -> " + v.getVendorName());
            }
            db.commit(); // Simpan perubahan secara permanen
            System.out.println("  [OK] Delete successful.");
        }
    }


    // --- HELPER METHOD ---

    private <T> List<T> displayAndReturn(ObjectSet<T> result) {
        List<T> list = new ArrayList<>();
        System.out.println("  Found " + result.size() + " result(s):");
        while (result.hasNext()) {
            T item = result.next();
            System.out.println("    -> " + item);
            list.add(item);
        }
        return list;
    }
}