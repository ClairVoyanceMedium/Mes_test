package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import android.database.DatabaseUtils;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class SqlEncode extends UnaryFunction {
    public static final String NAME = "sqlEncode";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        StringBuilder sb;
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 == null) {
            return "null";
        }
        if (c22 instanceof Number) {
            return h.d0(((Number) c22).doubleValue());
        }
        String str = "";
        if (!(c22 instanceof a)) {
            if (c22 instanceof e) {
                sb = new StringBuilder("(");
                e eVar = (e) c22;
                C1231k c1231k = (C1231k) eVar.f9362Z;
                while (true) {
                    if (!(c1231k != eVar)) {
                        sb.append(')');
                        break;
                    }
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    sb.append(str);
                    DatabaseUtils.appendEscapedSQLString(sb, ((e.a) c1231k).f4645y0);
                    str = ",";
                    c1231k = c1231k2;
                }
            } else {
                sb = new StringBuilder();
                DatabaseUtils.appendEscapedSQLString(sb, c22.toString());
            }
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<Object> it = ((a) c22).iterator();
        while (true) {
            a.C0026a c0026a = (a.C0026a) it;
            if (!c0026a.hasNext()) {
                sb2.append(')');
                return sb2.toString();
            }
            Object next = c0026a.next();
            sb2.append(str);
            if (next == null) {
                sb2.append("null");
            } else if (next instanceof Number) {
                sb2.append(h.d0(((Number) next).doubleValue()));
            } else {
                DatabaseUtils.appendEscapedSQLString(sb2, next.toString());
            }
            str = ",";
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
