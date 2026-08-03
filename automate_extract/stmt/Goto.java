package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.L1;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@F3.f("goto.html")
@F3.a(C2541R.integer.ic_action_goto)
@F3.i(C2541R.string.stmt_goto_title)
@F3.h(C2541R.string.stmt_goto_summary)
@F3.b(C2541R.layout.block_goto)
@F3.e(C2541R.layout.stmt_goto_edit)
/* loaded from: classes.dex */
public final class Goto extends Action {

    /* renamed from: L1, reason: collision with root package name */
    public volatile Map<Object, Label> f16693L1;
    public InterfaceC1700x0 labelValue;
    public L1<Label>[] labels = L1.f15101Y;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        boolean z7;
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_goto_title);
        InterfaceC1700x0 interfaceC1700x0 = this.labelValue;
        Object obj = null;
        if (interfaceC1700x0 != null) {
            try {
                new M3.c(false).b(interfaceC1700x0);
                z7 = true;
            } catch (Visitor.AbortException unused) {
                z7 = false;
            }
            if (!z7) {
                l8.v(this.labelValue, 0);
                return l8.f16030c;
            }
            obj = this.labelValue.c2(null);
        }
        Label label = q().get(obj);
        if (label != null) {
            l8.m(C2541R.string.caption_label_id, Long.valueOf(label.f16218X));
        } else {
            l8.B(C2541R.string.connector_not_available);
        }
        l8.A(J3.h.c0(obj));
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        L1<Label>[] l1Arr = this.labels;
        int length = l1Arr.length;
        int i8 = 0;
        for (L1<Label> l12 : l1Arr) {
            if (l12.f15102X != null) {
                l1Arr[i8] = l12;
                i8++;
            }
        }
        if (i8 != length) {
            this.labels = (L1[]) Arrays.copyOf(l1Arr, i8);
        }
        dVar.f(i8);
        for (L1<Label> l13 : this.labels) {
            dVar.g(l13.f15102X);
        }
        dVar.g(this.labelValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.a(this.labels);
        visitor.b(this.labelValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        int d8 = cVar.d();
        this.labels = new L1[d8];
        int i8 = 0;
        while (true) {
            d8--;
            if (d8 < 0) {
                this.labelValue = (InterfaceC1700x0) cVar.readObject();
                return;
            } else {
                this.labels[i8] = new L1<>((Label) cVar.readObject());
                i8++;
            }
        }
    }

    public final Map<Object, Label> q() {
        if (this.f16693L1 == null) {
            int length = this.labels.length;
            if (length != 0) {
                HashMap hashMap = new HashMap(length);
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    Label label = this.labels[length].f15102X;
                    if (label != null) {
                        InterfaceC1700x0 interfaceC1700x0 = label.value;
                        hashMap.put(interfaceC1700x0 != null ? interfaceC1700x0.c2(null) : null, label);
                    }
                }
                this.f16693L1 = hashMap;
            } else {
                this.f16693L1 = Collections.emptyMap();
            }
        }
        return this.f16693L1;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_goto_title);
        Label label = q().get(J3.h.u(c1708z0, this.labelValue, null));
        if (label != null) {
            c1708z0.f17642x0 = label;
            return true;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
