package com.llamalab.automate.stmt;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.stmt.C1677x;
import x3.C2431i;

@F3.f("database_modify.html")
@F3.a(C2541R.integer.ic_database_edit)
@F3.i(C2541R.string.stmt_database_modify_title)
@F3.h(C2541R.string.stmt_database_modify_summary)
@F3.e(C2541R.layout.stmt_database_modify_edit)
/* loaded from: classes.dex */
public final class DatabaseModify extends DatabaseAction {

    public static final class a implements C1677x.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f16547a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f16548b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16549c;

        public a(String str, String[] strArr, int i8) {
            this.f16547a = str;
            this.f16548b = strArr;
            this.f16549c = i8;
        }

        @Override // com.llamalab.automate.stmt.C1677x.a
        public final Object a(C1677x c1677x, SQLiteDatabase sQLiteDatabase) {
            String str = this.f16547a;
            if (3 == DatabaseUtils.getSqlStatementType(str)) {
                throw new SecurityException("ATTACH statement not allowed");
            }
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
            try {
                String[] strArr = this.f16548b;
                int i8 = C2431i.f23387a;
                if (strArr != null) {
                    int length = strArr.length;
                    int i9 = 0;
                    while (i9 < length) {
                        int i10 = i9 + 1;
                        String str2 = strArr[i9];
                        if (str2 == null) {
                            compileStatement.bindNull(i10);
                        } else {
                            compileStatement.bindString(i10, str2);
                        }
                        i9 = i10;
                    }
                }
                int i11 = this.f16549c;
                if (i11 == 3) {
                    return Double.valueOf(compileStatement.executeInsert());
                }
                if (i11 == 4) {
                    return Double.valueOf(compileStatement.executeUpdateDelete());
                }
                compileStatement.execute();
                compileStatement.close();
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
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_database_modify);
        l8.v(this.statement, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_database_modify_title);
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
        q(c1708z0, p8, 268435456, new a(str, J3.h.y(c1708z0, this.parameters), J3.h.m(c1708z0, this.resultType, 4)));
        return false;
    }
}
