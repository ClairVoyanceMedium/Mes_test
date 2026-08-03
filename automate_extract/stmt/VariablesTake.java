package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.IdentityHashMap;
import x3.C2434l;

@F3.f("variables_take.html")
@F3.a(C2541R.integer.ic_var_take)
@F3.i(C2541R.string.stmt_variables_take_title)
@F3.h(C2541R.string.stmt_variables_take_summary)
@F3.e(C2541R.layout.stmt_variables_take_edit)
/* loaded from: classes.dex */
public final class VariablesTake extends IntermittentDecision implements InterfaceC1622q2 {
    public J3.l varGiverFiberUri;
    public J3.l[] variables = J3.l.f4657Z;

    /* renamed from: L1, reason: collision with root package name */
    public int f17236L1 = -1;

    public static final class a implements R3.e {

        /* renamed from: X, reason: collision with root package name */
        public String f17237X;

        /* renamed from: Y, reason: collision with root package name */
        public Object[] f17238Y;

        public a() {
            this(null, C2434l.f23395f);
        }

        @Override // R3.e
        public final void Y0(R3.d dVar) {
            dVar.k(this.f17237X);
            dVar.h(this.f17238Y);
        }

        @Override // R3.e
        public final void o0(R3.c cVar) {
            this.f17237X = cVar.i();
            this.f17238Y = cVar.g(this.f17238Y);
        }

        public a(String str, Object[] objArr) {
            this.f17237X = str;
            this.f17238Y = objArr;
        }
    }

    public final void B(C1708z0 c1708z0, a aVar) {
        Object[] objArr;
        Object[] objArr2 = (Object[]) c1708z0.j(this.f17236L1);
        if (objArr2 == null || objArr2.length == 0) {
            objArr = new Object[]{aVar};
        } else {
            int length = objArr2.length;
            if (length == 20000) {
                throw new IllegalStateException("Queue size exceeded: 20000");
            }
            objArr = Arrays.copyOf(objArr2, length + 1);
            objArr[length] = aVar;
        }
        c1708z0.z(this.f17236L1, objArr);
    }

    public final a C(C1708z0 c1708z0, IdentityHashMap<J3.d<?>, J3.d<?>> identityHashMap) {
        int length = this.variables.length;
        Object[] objArr = new Object[length];
        for (int i8 = 0; i8 < length; i8++) {
            objArr[i8] = D1.P.g(c1708z0.j(this.variables[i8].f4659Y), identityHashMap);
        }
        return new a(F5.n.d(c1708z0).toString(), objArr);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_variables_take_immediate, C2541R.string.caption_variables_take_available);
        J3.l[] lVarArr = this.variables;
        if (lVarArr != null) {
            for (J3.l lVar : lVarArr) {
                c1596k0.v(lVar, 0);
            }
        }
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        s(dVar, 32);
        if (32 <= dVar.f6413Z) {
            dVar.g(this.continuity);
        }
        dVar.g(this.varGiverFiberUri);
        dVar.h(this.variables);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varGiverFiberUri);
        visitor.a(this.variables);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17236L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        p(cVar, 32);
        if (32 <= cVar.f6409x0) {
            this.continuity = (Integer) cVar.readObject();
        }
        this.varGiverFiberUri = (J3.l) cVar.readObject();
        this.variables = (J3.l[]) cVar.g(this.variables);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_variables_take_title);
        Object[] objArr = (Object[]) c1708z0.j(this.f17236L1);
        a aVar = null;
        aVar = null;
        if (objArr != null && objArr.length != 0) {
            c1708z0.z(this.f17236L1, objArr.length != 1 ? Arrays.copyOfRange(objArr, 1, objArr.length) : null);
            aVar = (a) objArr[0];
        }
        if (aVar == null) {
            if (J1(1) != 0) {
                return false;
            }
            o(c1708z0, false);
            return true;
        }
        J3.l lVar = this.varGiverFiberUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar.f17237X);
        }
        int length = this.variables.length;
        for (int i8 = 0; i8 < length; i8++) {
            c1708z0.z(this.variables[i8].f4659Y, aVar.f17238Y[i8]);
        }
        o(c1708z0, true);
        return true;
    }
}
