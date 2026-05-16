package utsdb4o;

import com.db4o.ObjectContainer;
import java.util.ArrayList;
import com.db4o.query.Predicate;
import utsdb4o.*;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 * NativeQueryService: Demonstrates Native Query (NQ) technique using db4o.
 * NQ uses Java's type system and compiler to formulate queries as Predicates.
 */
public class NQQuery{ 

    private ObjectContainer db;

    public NQQuery(ObjectContainer db) {
        this.db = db;
    }

    /**
     * NQ 1: Find all EBusiness with annualRevenue > threshold
     */
    public List<EBusiness> findHighRevenueBusinesses(final double threshold) {
        System.out.println("\n[NQ] Finding EBusiness with annualRevenue > " + threshold);
        List<EBusiness> result = db.query(new Predicate<EBusiness>() {
            @Override
            public boolean match(EBusiness eb) {
                return eb.getAnnualRevenue() > threshold;
            }
        });
        System.out.println("  Found " + result.size() + " result(s):");
        for (EBusiness eb : result) {
            System.out.println("    -> " + eb);
        }
        return result;
    }

    /**
     * NQ 2: Find all DataCenters with currentAvailability below target
     */
    public List<DataCenter> findUnderperformingDataCenters() {
        System.out.println("\n[NQ] Finding DataCenters where currentAvailability < targetAvailability");
        List<DataCenter> result = db.query(new Predicate<DataCenter>() {
            @Override
            public boolean match(DataCenter dc) {
                return dc.getCurrentAvailability() < dc.getTargetAvailability();
            }
        });
        System.out.println("  Found " + result.size() + " result(s):");
        for (DataCenter dc : result) {
            System.out.println("    -> " + dc);
        }
        return result;
    }

    /**
     * NQ 3: Find all Complaints that are escalated and not resolved
     */
    public List<Complaint> findEscalatedUnresolvedComplaints() {
        System.out.println("\n[NQ] Finding Complaints that are escalated and NOT resolved");
        List<Complaint> result = db.query(new Predicate<Complaint>() {
            @Override
            public boolean match(Complaint c) {
                return c.isEscalate() && !c.isResolve();
            }
        });
        System.out.println("  Found " + result.size() + " result(s):");
        for (Complaint c : result) {
            System.out.println("    -> " + c);
        }
        return result;
    }

    /**
     * NQ 4: Find all Servers with a specific status
     */
    public List<Server> findServersByStatus(final String status) {
        System.out.println("\n[NQ] Finding Servers with status = '" + status + "'");
        List<Server> result = db.query(new Predicate<Server>() {
            @Override
            public boolean match(Server s) {
                return s.getStatus() != null && s.getStatus().equalsIgnoreCase(status);
            }
        });
        System.out.println("  Found " + result.size() + " result(s):");
        for (Server s : result) {
            System.out.println("    -> " + s);
        }
        return result;
    }

    /**
     * NQ 5: Find CostAnalysis where netSavings > threshold
     */
    public List<CostAnalysis> findProfitableAnalyses(final double minSavings) {
        System.out.println("\n[NQ] Finding CostAnalysis where netSavings > " + minSavings);
        List<CostAnalysis> result = db.query(new Predicate<CostAnalysis>() {
            @Override
            public boolean match(CostAnalysis ca) {
                return ca.getNetSavings() > minSavings;
            }
        });
        System.out.println("  Found " + result.size() + " result(s):");
        for (CostAnalysis ca : result) {
            System.out.println("    -> " + ca);
        }
        return result;
    }

    /**
     * NQ 6: Mencari Downtime dan diurutkan berdasarkan durasi (Sorting)
     */
    public List<DowntimeEvent> findLongDowntimeEventsSorted(final double minHours) {
        System.out.println("\n[NQ] Finding DowntimeEvents > " + minHours + " hours (Sorted Descending)");
        
        List<DowntimeEvent> result = new ArrayList<>(db.query(new Predicate<DowntimeEvent>() {
            @Override
            public boolean match(DowntimeEvent de) {
                return de.getDurationHours() > minHours;
            }
        }));

        // IMPLEMENTASI SORTING
        Collections.sort(result, new Comparator<DowntimeEvent>() {
            @Override
            public int compare(DowntimeEvent o1, DowntimeEvent o2) {
                return Double.compare(o2.getDurationHours(), o1.getDurationHours());
            }
        });

        for (DowntimeEvent de : result) {
            System.out.println("    -> " + de);
        }
        return result;
    }
}
