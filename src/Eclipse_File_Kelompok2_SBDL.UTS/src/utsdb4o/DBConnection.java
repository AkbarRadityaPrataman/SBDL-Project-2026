package utsdb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DBConnection {

    public static ObjectContainer db;

    public static void open() {
        db = Db4oEmbedded.openFile("utsdb4o.db4o");
    }

    public static void close() {
        db.close();
    }
}