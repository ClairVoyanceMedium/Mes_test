package L3;

import C1.C1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class E implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0[] f4928X;

    public E() {
        this(InterfaceC1700x0.f17620D1);
    }

    public static E b(Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return new E();
        }
        InterfaceC1700x0[] interfaceC1700x0Arr = new InterfaceC1700x0[size];
        Iterator<?> it = collection.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            interfaceC1700x0Arr[i8] = C1.j(it.next());
            i8++;
        }
        return new E(interfaceC1700x0Arr);
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        int length = this.f4928X.length;
        dVar.f(length);
        for (int i8 = 0; i8 < length; i8++) {
            dVar.g(this.f4928X[i8]);
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4928X) {
            visitor.b(interfaceC1700x0);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int length = this.f4928X.length;
        Object[] objArr = new Object[length];
        for (int i8 = 0; i8 < length; i8++) {
            InterfaceC1700x0 interfaceC1700x0 = this.f4928X[i8];
            if (interfaceC1700x0 != null) {
                objArr[i8] = interfaceC1700x0.c2(c1708z0);
            }
        }
        return new J3.a(length, objArr);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int d8 = cVar.d();
        if (d8 != 0) {
            this.f4928X = new InterfaceC1700x0[d8];
            for (int i8 = 0; i8 < d8; i8++) {
                this.f4928X[i8] = (InterfaceC1700x0) cVar.readObject();
            }
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        int i9 = i8 & 8;
        if (i9 == 0) {
            sb.append('[');
        }
        InterfaceC1700x0[] interfaceC1700x0Arr = this.f4928X;
        int length = interfaceC1700x0Arr.length;
        String str = "";
        int i10 = 0;
        while (i10 < length) {
            InterfaceC1700x0 interfaceC1700x0 = interfaceC1700x0Arr[i10];
            sb.append(str);
            sb.append(interfaceC1700x0.x(i8 & (-9)));
            i10++;
            str = ", ";
        }
        if (i9 == 0) {
            sb.append(']');
        }
        return sb.toString();
    }

    public E(InterfaceC1700x0[] interfaceC1700x0Arr) {
        this.f4928X = interfaceC1700x0Arr;
    }
}
