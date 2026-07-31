package L3;

import C1.C1;
import J3.e;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.ConversionType;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class F implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0[] f4929X;

    /* renamed from: Y, reason: collision with root package name */
    public InterfaceC1700x0[] f4930Y;

    /* renamed from: Z, reason: collision with root package name */
    public ConversionType[] f4931Z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public F() {
        this(r0, r0, ConversionType.EMPTY_ARRAY);
        InterfaceC1700x0[] interfaceC1700x0Arr = InterfaceC1700x0.f17620D1;
    }

    public static F b(J3.e eVar) {
        int i8 = eVar.f4641x1;
        if (i8 == 0) {
            return new F();
        }
        InterfaceC1700x0[] interfaceC1700x0Arr = new InterfaceC1700x0[i8];
        InterfaceC1700x0[] interfaceC1700x0Arr2 = new InterfaceC1700x0[i8];
        ConversionType[] conversionTypeArr = new ConversionType[i8];
        C1231k c1231k = (C1231k) eVar.f9362Z;
        int i9 = 0;
        while (true) {
            if (!(c1231k != eVar)) {
                return new F(interfaceC1700x0Arr, interfaceC1700x0Arr2, conversionTypeArr);
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            interfaceC1700x0Arr[i9] = new W(aVar.f4645y0);
            interfaceC1700x0Arr2[i9] = C1.j(aVar.f4644x1);
            conversionTypeArr[i9] = aVar.f4646y1;
            c1231k = c1231k2;
            i9++;
        }
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        int length = this.f4929X.length;
        dVar.f(length);
        for (int i8 = 0; i8 < length; i8++) {
            dVar.g(this.f4929X[i8]);
            dVar.g(this.f4930Y[i8]);
            ConversionType.writeObject(dVar, this.f4931Z[i8]);
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        int length = this.f4929X.length;
        for (int i8 = 0; i8 < length; i8++) {
            visitor.b(this.f4929X[i8]);
            visitor.b(this.f4930Y[i8]);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int length = this.f4929X.length;
        J3.e eVar = new J3.e(length);
        for (int i8 = 0; i8 < length; i8++) {
            eVar.m0(J3.h.e0(this.f4929X[i8].c2(c1708z0)), this.f4930Y[i8].c2(c1708z0), this.f4931Z[i8]);
        }
        return eVar;
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int d8 = cVar.d();
        if (d8 != 0) {
            this.f4929X = new InterfaceC1700x0[d8];
            this.f4930Y = new InterfaceC1700x0[d8];
            this.f4931Z = new ConversionType[d8];
            for (int i8 = 0; i8 < d8; i8++) {
                this.f4929X[i8] = (InterfaceC1700x0) cVar.readObject();
                this.f4930Y[i8] = (InterfaceC1700x0) cVar.readObject();
                this.f4931Z[i8] = ConversionType.readObject(cVar);
            }
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        int length = this.f4929X.length;
        StringBuilder sb = new StringBuilder();
        int i9 = i8 & 8;
        if (i9 == 0) {
            sb.append('{');
        }
        String str = "";
        int i10 = 0;
        while (i10 < length) {
            sb.append(str);
            int i11 = i8 & (-9);
            sb.append(this.f4929X[i10].x(i11));
            ConversionType conversionType = this.f4931Z[i10];
            if (conversionType != null) {
                sb.append(" as ");
                sb.append(conversionType);
            }
            sb.append(": ");
            sb.append(this.f4930Y[i10].x(i11));
            i10++;
            str = ", ";
        }
        if (i9 == 0) {
            sb.append('}');
        }
        return sb.toString();
    }

    public F(InterfaceC1700x0[] interfaceC1700x0Arr, InterfaceC1700x0[] interfaceC1700x0Arr2, ConversionType[] conversionTypeArr) {
        this.f4929X = interfaceC1700x0Arr;
        this.f4930Y = interfaceC1700x0Arr2;
        this.f4931Z = conversionTypeArr;
    }
}
