package com.llamalab.automate.stmt;

import J3.e;
import android.content.Context;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.A2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.NoSuchElementException;

@F3.f("for_each.html")
@F3.a(C2541R.integer.ic_for_each)
@F3.i(C2541R.string.stmt_for_each_title)
@F3.h(C2541R.string.stmt_for_each_summary)
@F3.b(C2541R.layout.block_for_each)
@F3.e(C2541R.layout.stmt_for_each_edit)
/* loaded from: classes.dex */
public final class ForEach extends Action implements InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f16648L1 = -1;

    /* renamed from: M1, reason: collision with root package name */
    public int f16649M1 = -1;

    /* renamed from: N1, reason: collision with root package name */
    public int f16650N1 = -1;
    public InterfaceC1700x0 container;

    @F3.d(C2541R.id.right)
    public A2 onEachElement;
    public InterfaceC1700x0 until;
    public J3.l varEntryIndex;
    public J3.l varEntryKey;
    public J3.l varEntryValue;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_for_each);
        l8.u(C2541R.string.caption_in, this.container);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onEachElement);
        dVar.g(this.container);
        if (47 <= dVar.f6413Z) {
            dVar.g(this.until);
        }
        dVar.g(this.varEntryValue);
        dVar.g(this.varEntryIndex);
        dVar.g(this.varEntryKey);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.onEachElement);
        visitor.b(this.container);
        visitor.b(this.until);
        visitor.b(this.varEntryValue);
        visitor.b(this.varEntryIndex);
        visitor.b(this.varEntryKey);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16648L1 = c1625r2.d(false);
        this.f16649M1 = c1625r2.d(false);
        this.f16650N1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.onEachElement = (A2) cVar.readObject();
        this.container = (InterfaceC1700x0) cVar.readObject();
        if (47 <= cVar.f6409x0) {
            this.until = (InterfaceC1700x0) cVar.readObject();
        }
        this.varEntryValue = (J3.l) cVar.readObject();
        this.varEntryIndex = (J3.l) cVar.readObject();
        this.varEntryKey = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, int i8, String str, Object obj) {
        Double valueOf = Double.valueOf(i8);
        J3.l lVar = this.varEntryIndex;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        J3.l lVar2 = this.varEntryKey;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str);
        }
        J3.l lVar3 = this.varEntryValue;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, obj);
        }
        if (!J3.h.f(c1708z0, this.until, false)) {
            c1708z0.z(this.f16648L1, Integer.valueOf(i8 + 1));
            c1708z0.f17642x0 = this.onEachElement;
        } else {
            c1708z0.z(this.f16648L1, null);
            c1708z0.z(this.f16649M1, null);
            c1708z0.z(this.f16650N1, null);
            c1708z0.f17642x0 = this.onComplete;
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_for_each_title);
        if (this.onEachElement != null) {
            Integer num = (Integer) c1708z0.j(this.f16648L1);
            int i8 = -1;
            int intValue = num != null ? num.intValue() : -1;
            if (intValue == -1) {
                Object u8 = J3.h.u(c1708z0, this.container, null);
                if (u8 instanceof J3.a) {
                    Object[] array = ((J3.a) u8).toArray();
                    if (array.length != 0) {
                        c1708z0.z(this.f16649M1, null);
                        c1708z0.z(this.f16650N1, array);
                        q(c1708z0, 0, null, array[0]);
                        return true;
                    }
                } else if (u8 instanceof J3.e) {
                    J3.e eVar = (J3.e) u8;
                    if (!eVar.isEmpty()) {
                        int i9 = eVar.f4641x1;
                        String[] strArr = new String[i9];
                        Object[] objArr = new Object[i9];
                        C1231k c1231k = (C1231k) eVar.f9362Z;
                        while (true) {
                            if (!(c1231k != eVar)) {
                                c1708z0.z(this.f16649M1, strArr);
                                c1708z0.z(this.f16650N1, objArr);
                                q(c1708z0, 0, strArr[0], objArr[0]);
                                return true;
                            }
                            if (c1231k == eVar) {
                                throw new NoSuchElementException();
                            }
                            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                            e.a aVar = (e.a) c1231k;
                            i8++;
                            strArr[i8] = aVar.f4645y0;
                            objArr[i8] = aVar.f4644x1;
                            c1231k = c1231k2;
                        }
                    }
                } else if (u8 instanceof Double) {
                    int intValue2 = ((Double) u8).intValue();
                    if (intValue2 > 0) {
                        c1708z0.z(this.f16649M1, null);
                        c1708z0.z(this.f16650N1, Integer.valueOf(intValue2));
                        q(c1708z0, 0, null, Double.valueOf(0.0d));
                        return true;
                    }
                } else if (u8 instanceof String) {
                    String str = (String) u8;
                    if (str.length() > 0) {
                        c1708z0.z(this.f16649M1, null);
                        c1708z0.z(this.f16650N1, str);
                        q(c1708z0, 0, null, Double.valueOf(str.charAt(0)));
                        return true;
                    }
                }
            } else {
                Object j8 = c1708z0.j(this.f16650N1);
                if (j8 instanceof Object[]) {
                    Object[] objArr2 = (Object[]) j8;
                    if (intValue < objArr2.length) {
                        String[] strArr2 = (String[]) c1708z0.j(this.f16649M1);
                        q(c1708z0, intValue, strArr2 != null ? strArr2[intValue] : null, objArr2[intValue]);
                        return true;
                    }
                } else if (j8 instanceof Integer) {
                    if (intValue < ((Integer) j8).intValue()) {
                        q(c1708z0, intValue, null, Double.valueOf(intValue));
                        return true;
                    }
                } else if (j8 instanceof String) {
                    if (intValue < ((String) j8).length()) {
                        q(c1708z0, intValue, null, Double.valueOf(r3.charAt(intValue)));
                        return true;
                    }
                }
            }
        }
        J3.l lVar = this.varEntryIndex;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, null);
        }
        J3.l lVar2 = this.varEntryKey;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, null);
        }
        J3.l lVar3 = this.varEntryValue;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, null);
        }
        c1708z0.z(this.f16648L1, null);
        c1708z0.z(this.f16649M1, null);
        c1708z0.z(this.f16650N1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
