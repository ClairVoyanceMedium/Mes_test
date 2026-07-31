package L3;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class a0 implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0[] f4948X;

    public a0() {
        this.f4948X = InterfaceC1700x0.f17620D1;
    }

    @Override // R3.e
    public void Y0(R3.d dVar) {
        int length = this.f4948X.length;
        dVar.f(length);
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            dVar.g(this.f4948X[i8]);
            i8++;
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4948X) {
            visitor.b(interfaceC1700x0);
        }
    }

    public final void b(R3.c cVar) {
        if (47 <= cVar.f6409x0) {
            c(cVar);
        } else {
            this.f4948X = new InterfaceC1700x0[]{(InterfaceC1700x0) cVar.readObject(), (InterfaceC1700x0) cVar.readObject()};
        }
    }

    public final void c(R3.c cVar) {
        int d8 = cVar.d();
        if (d8 <= 0) {
            return;
        }
        this.f4948X = new InterfaceC1700x0[d8];
        int i8 = 0;
        while (true) {
            d8--;
            if (d8 < 0) {
                return;
            }
            this.f4948X[i8] = (InterfaceC1700x0) cVar.readObject();
            i8++;
        }
    }

    public final void d(R3.d dVar) {
        int i8 = 0;
        if (47 > dVar.f6413Z) {
            InterfaceC1700x0[] interfaceC1700x0Arr = this.f4948X;
            if (interfaceC1700x0Arr.length != 2) {
                throw new IllegalStateException("Too many operands");
            }
            dVar.g(interfaceC1700x0Arr[0]);
            dVar.g(this.f4948X[1]);
            return;
        }
        int length = this.f4948X.length;
        dVar.f(length);
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            dVar.g(this.f4948X[i8]);
            i8++;
        }
    }

    @Override // R3.e
    public void o0(R3.c cVar) {
        c(cVar);
    }

    public a0(InterfaceC1700x0... interfaceC1700x0Arr) {
        this.f4948X = interfaceC1700x0Arr;
    }
}
