package com.llamalab.automate.stmt;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.C1677x;
import x3.C2431i;

@F3.f("database_query.html")
@F3.a(C2541R.integer.ic_database_list)
@F3.i(C2541R.string.stmt_database_query_title)
@F3.h(C2541R.string.stmt_database_query_summary)
@F3.e(C2541R.layout.stmt_database_query_edit)
/* loaded from: classes.dex */
public final class DatabaseQuery extends DatabaseAction {
    public InterfaceC1700x0 columnResultType;

    public static final class a implements C1677x.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f16550a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f16551b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16552c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16553d;

        public a(String str, String[] strArr, int i8, int i9) {
            this.f16550a = str;
            this.f16551b = strArr;
            this.f16552c = i8;
            this.f16553d = i9;
        }

        @Override // com.llamalab.automate.stmt.C1677x.a
        public final Object a(C1677x c1677x, SQLiteDatabase sQLiteDatabase) {
            String str = this.f16550a;
            if (3 == DatabaseUtils.getSqlStatementType(str)) {
                throw new SecurityException("ATTACH statement not allowed");
            }
            String[] strArr = this.f16551b;
            int i8 = this.f16552c;
            if (i8 != 0) {
                Cursor rawQuery = 16 <= Build.VERSION.SDK_INT ? sQLiteDatabase.rawQuery(str, strArr, ((C1679y) c1677x).x2()) : sQLiteDatabase.rawQuery(str, strArr);
                try {
                    if (!rawQuery.moveToNext()) {
                        return null;
                    }
                    int count = rawQuery.getCount();
                    if (count <= 500) {
                        return w0.L.r(rawQuery, count, i8, this.f16553d);
                    }
                    throw new IllegalStateException("Row limit exceeded, append a \"LIMIT 500\" to statement");
                } finally {
                    rawQuery.close();
                }
            }
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
            try {
                int i9 = C2431i.f23387a;
                if (strArr != null) {
                    int length = strArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        int i11 = i10 + 1;
                        String str2 = strArr[i10];
                        if (str2 == null) {
                            compileStatement.bindNull(i11);
                        } else {
                            compileStatement.bindString(i11, str2);
                        }
                        i10 = i11;
                    }
                }
                compileStatement.execute();
                return null;
            } finally {
                compileStatement.close();
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_database_query);
        l8.v(this.statement, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.DatabaseAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (112 <= dVar.f6413Z) {
            dVar.g(this.columnResultType);
        }
    }

    @Override // com.llamalab.automate.stmt.DatabaseAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.columnResultType);
    }

    @Override // com.llamalab.automate.stmt.DatabaseAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (112 <= cVar.f6409x0) {
            this.columnResultType = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_database_query_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.databaseFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("databaseFile");
        }
        String str = null;
        String x7 = J3.h.x(c1708z0, this.statement, null);
        if (x7 != null) {
            String trim = x7.trim();
            if (!trim.isEmpty()) {
                str = trim;
            }
        }
        q(c1708z0, p8, 1, new a(str, J3.h.y(c1708z0, this.parameters), J3.h.m(c1708z0, this.resultType, 1), J3.h.m(c1708z0, this.columnResultType, 0)));
        return false;
    }
}
