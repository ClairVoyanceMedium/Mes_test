package com.llamalab.automate.stmt;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AutomateService;
import x3.C2431i;

/* renamed from: com.llamalab.automate.stmt.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1677x extends com.llamalab.automate.W implements DatabaseErrorHandler {

    /* renamed from: L1, reason: collision with root package name */
    public SQLiteDatabase f17563L1;

    /* renamed from: M1, reason: collision with root package name */
    public Thread f17564M1;

    /* renamed from: y1, reason: collision with root package name */
    public final com.llamalab.safs.n f17565y1;

    /* renamed from: com.llamalab.automate.stmt.x$a */
    public interface a {
        Object a(C1677x c1677x, SQLiteDatabase sQLiteDatabase);
    }

    public C1677x(com.llamalab.safs.n nVar) {
        this.f17565y1 = nVar;
    }

    public static void v2(C1677x c1677x, int i8) {
        SQLiteDatabase sQLiteDatabase = c1677x.f17563L1;
        if (sQLiteDatabase != null) {
            if (c1677x.f17565y1.equals(I2.k(sQLiteDatabase.getPath(), new String[0]))) {
                if ((i8 & 1) == 0 && c1677x.f17563L1.isReadOnly()) {
                    try {
                        c1677x.f17563L1.getClass().getMethod("reopenReadWrite", new Class[0]).invoke(c1677x.f17563L1, new Object[0]);
                        if (!c1677x.f17563L1.isReadOnly()) {
                            C2431i.b(c1677x.f17563L1);
                            return;
                        }
                    } catch (NoSuchMethodException e8) {
                        Log.w("DatabaseTask", "reopenReadWrite failed", e8);
                    }
                    c1677x.f17563L1.close();
                    c1677x.f17563L1 = null;
                    c1677x.w2(i8, false);
                    return;
                }
                return;
            }
            c1677x.f17563L1.close();
            c1677x.f17563L1 = null;
        }
        c1677x.w2(i8, true);
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public void F(AutomateService automateService) {
        F5.n.h(this);
        SQLiteDatabase sQLiteDatabase = this.f17563L1;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
            this.f17563L1 = null;
        }
        this.f17564M1 = null;
        u2();
    }

    @Override // android.database.DatabaseErrorHandler
    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Log.w("DatabaseTask", "Database corrupt: " + sQLiteDatabase.getPath());
    }

    public final void w2(int i8, boolean z7) {
        com.llamalab.safs.n nVar = this.f17565y1;
        if (z7) {
            try {
                s4.d k8 = I2.k(this.f15400Y.getDatabasePath("automate.db").toString(), new String[0]);
                com.llamalab.safs.k[] kVarArr = com.llamalab.safs.i.f17783a;
                if (nVar.E().f22244X.isSameFile(nVar, k8)) {
                    throw new SecurityException("Automate is not permitted");
                }
            } catch (Exception unused) {
            }
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(nVar.toString(), null, i8, this);
        this.f17563L1 = openDatabase;
        if (openDatabase.isReadOnly()) {
            return;
        }
        C2431i.b(this.f17563L1);
    }
}
