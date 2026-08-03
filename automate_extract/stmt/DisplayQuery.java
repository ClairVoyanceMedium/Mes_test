package com.llamalab.automate.stmt;

import P.C1091g;
import android.content.Context;
import android.hardware.display.DeviceProductInfo;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.lang.reflect.InvocationTargetException;
import x3.C2424b;
import x3.C2440r;

@F3.f("display_query.html")
@F3.a(C2541R.integer.ic_cast_connected)
@F3.i(C2541R.string.stmt_display_query_title)
@F3.h(C2541R.string.stmt_display_query_summary)
@F3.e(C2541R.layout.stmt_display_query_edit)
/* loaded from: classes.dex */
public final class DisplayQuery extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 connection;
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 name;
    public J3.l varDisplayIds;
    public J3.l varDisplayNames;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f16598a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16599b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16600c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16601d;

        public a(Display display) {
            String name;
            int flags;
            DeviceProductInfo deviceProductInfo;
            name = display.getName();
            this.f16598a = name;
            this.f16599b = display.getDisplayId();
            int i8 = C2424b.f23370a;
            flags = display.getFlags();
            if (19 > Build.VERSION.SDK_INT) {
                try {
                    int intValue = ((Integer) Display.class.getMethod("getType", new Class[0]).invoke(display, new Object[0])).intValue();
                    if (intValue == 2 || intValue == 3 || intValue == 4) {
                        flags |= 8;
                    }
                } catch (IllegalAccessException | NoSuchMethodException unused) {
                } catch (InvocationTargetException e8) {
                    throw ((RuntimeException) e8.getTargetException());
                }
            }
            this.f16600c = (flags ^ 20) & 30;
            if (31 > Build.VERSION.SDK_INT) {
                this.f16601d = 1;
            } else {
                deviceProductInfo = display.getDeviceProductInfo();
                this.f16601d = 1 << (deviceProductInfo != null ? deviceProductInfo.getConnectionToSinkType() : 0);
            }
        }

        public final boolean a(int i8, int i9, String str) {
            if (i8 != 0 && (i8 & this.f16600c) == 0) {
                return false;
            }
            if (i9 == 0 || (this.f16601d & i9) != 0) {
                return str == null || C2440r.v(this.f16598a, str);
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16599b == aVar.f16599b && this.f16600c == aVar.f16600c && this.f16601d == aVar.f16601d && C2440r.h(this.f16598a, aVar.f16598a);
        }
    }

    public static final class b extends com.llamalab.automate.W implements DisplayManager.DisplayListener {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16602L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16603M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16604N1;

        /* renamed from: O1, reason: collision with root package name */
        public DisplayManager f16605O1;

        /* renamed from: y1, reason: collision with root package name */
        public final SparseArray<a> f16606y1 = new SparseArray<>();

        public b(int i8, int i9, String str) {
            this.f16602L1 = str;
            this.f16603M1 = i8;
            this.f16604N1 = i9;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            Display[] displays;
            super.C(automateService, j8, j9, j10);
            DisplayManager e8 = C1091g.e(automateService.getSystemService("display"));
            this.f16605O1 = e8;
            displays = e8.getDisplays();
            for (Display display : displays) {
                a aVar = new a(display);
                if (aVar.a(this.f16603M1, this.f16604N1, this.f16602L1)) {
                    this.f16606y1.put(aVar.f16599b, aVar);
                }
            }
            this.f16605O1.registerDisplayListener(this, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16605O1.unregisterDisplayListener(this);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i8) {
            Display display;
            display = this.f16605O1.getDisplay(i8);
            if (display != null) {
                a aVar = new a(display);
                if (aVar.a(this.f16603M1, this.f16604N1, this.f16602L1)) {
                    this.f16606y1.put(aVar.f16599b, aVar);
                    q2(this.f16606y1, false);
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i8) {
            Display display;
            display = this.f16605O1.getDisplay(i8);
            if (display != null) {
                a aVar = new a(display);
                if (aVar.equals(this.f16606y1.get(aVar.f16599b))) {
                    return;
                }
                q2(this.f16606y1, false);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i8) {
            int indexOfKey = this.f16606y1.indexOfKey(i8);
            if (indexOfKey >= 0) {
                this.f16606y1.removeAt(indexOfKey);
                q2(this.f16606y1, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_display_query_immediate, C2541R.string.caption_display_query_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.name);
        dVar.g(this.flags);
        if (101 <= dVar.f6413Z) {
            dVar.g(this.connection);
        }
        dVar.g(this.varDisplayIds);
        dVar.g(this.varDisplayNames);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.name);
        visitor.b(this.flags);
        visitor.b(this.connection);
        visitor.b(this.varDisplayIds);
        visitor.b(this.varDisplayNames);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.name = (InterfaceC1700x0) cVar.readObject();
        this.flags = (InterfaceC1700x0) cVar.readObject();
        if (101 <= cVar.f6409x0) {
            this.connection = (InterfaceC1700x0) cVar.readObject();
        }
        this.varDisplayIds = (J3.l) cVar.readObject();
        this.varDisplayNames = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Display[] displays;
        c1708z0.q(C2541R.string.stmt_display_query_title);
        IncapableAndroidVersionException.a(17);
        J3.a aVar = null;
        String x7 = J3.h.x(c1708z0, this.name, null);
        int m8 = J3.h.m(c1708z0, this.flags, 0) & 30;
        int m9 = J3.h.m(c1708z0, this.connection, 0) & 69915;
        if (J1(1) != 0) {
            c1708z0.w(new b(m8, m9, x7));
            return false;
        }
        displays = C1091g.e(c1708z0.getSystemService("display")).getDisplays();
        J3.a aVar2 = null;
        for (Display display : displays) {
            a aVar3 = new a(display);
            if (aVar3.a(m8, m9, x7)) {
                if (aVar == null) {
                    aVar = new J3.a(4);
                    aVar2 = new J3.a(4);
                }
                aVar.add(Double.valueOf(aVar3.f16599b));
                aVar2.add(aVar3.f16598a);
            }
        }
        s(c1708z0, aVar, aVar2);
        return true;
    }

    public final boolean s(C1708z0 c1708z0, J3.a aVar, J3.a aVar2) {
        J3.l lVar = this.varDisplayIds;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varDisplayNames;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar2);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int size = sparseArray.size();
        if (size == 0) {
            s(c1708z0, null, null);
            return true;
        }
        J3.a aVar = new J3.a(size);
        J3.a aVar2 = new J3.a(size);
        for (int i8 = 0; i8 < size; i8++) {
            a aVar3 = (a) sparseArray.valueAt(i8);
            aVar.add(Double.valueOf(aVar3.f16599b));
            aVar2.add(aVar3.f16598a);
        }
        s(c1708z0, aVar, aVar2);
        return true;
    }
}
