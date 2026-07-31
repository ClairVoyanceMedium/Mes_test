package L3;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class V implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public String[] f4943X;

    /* renamed from: Y, reason: collision with root package name */
    public InterfaceC1700x0[] f4944Y;

    /* renamed from: Z, reason: collision with root package name */
    public byte[] f4945Z;

    public V() {
    }

    public V(int i8) {
        this.f4943X = new String[i8 + 1];
        this.f4944Y = new InterfaceC1700x0[i8];
        this.f4945Z = new byte[(i8 / 8) + 1];
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        int length = this.f4943X.length;
        dVar.f(length);
        for (int i8 = 0; i8 < length; i8++) {
            dVar.writeUTF(this.f4943X[i8]);
        }
        int i9 = length - 1;
        for (int i10 = 0; i10 < i9; i10++) {
            dVar.g(this.f4944Y[i10]);
        }
        int i11 = (i9 / 8) + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            dVar.write(this.f4945Z[i12]);
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4944Y) {
            visitor.b(interfaceC1700x0);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22;
        StringBuilder sb = new StringBuilder();
        int length = this.f4943X.length;
        int i8 = -1;
        while (true) {
            length--;
            if (length <= 0) {
                sb.append(this.f4943X[i8 + 1]);
                return sb.toString();
            }
            i8++;
            sb.append(this.f4943X[i8]);
            InterfaceC1700x0 interfaceC1700x0 = this.f4944Y[i8];
            if (interfaceC1700x0 != null && (c22 = interfaceC1700x0.c2(c1708z0)) != null) {
                sb.append(J3.h.e0(c22));
            }
        }
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int d8 = cVar.d();
        this.f4943X = new String[d8];
        for (int i8 = 0; i8 < d8; i8++) {
            this.f4943X[i8] = cVar.readUTF();
        }
        int i9 = d8 - 1;
        this.f4944Y = new InterfaceC1700x0[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            this.f4944Y[i10] = (InterfaceC1700x0) cVar.readObject();
        }
        int i11 = (i9 / 8) + 1;
        this.f4945Z = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.f4945Z[i12] = (byte) cVar.readUnsignedByte();
        }
    }

    public final String toString() {
        return x(5);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        int i9 = i8 & 1;
        if (i9 == 0) {
            sb.append('\"');
        }
        int length = this.f4943X.length;
        int i10 = -1;
        while (true) {
            length--;
            if (length <= 0) {
                break;
            }
            i10++;
            String str = this.f4943X[i10];
            Pattern pattern = J3.h.f4650a;
            J3.h.b(str, str.length(), i8, sb);
            sb.append('{');
            InterfaceC1700x0 interfaceC1700x0 = this.f4944Y[i10];
            if (interfaceC1700x0 != null) {
                sb.append(interfaceC1700x0.x(((1 << (i10 % 8)) & this.f4945Z[i10 / 8]) != 0 ? i8 | 1 : i8 & (-6)));
            }
            sb.append('}');
        }
        String str2 = this.f4943X[i10 + 1];
        Pattern pattern2 = J3.h.f4650a;
        J3.h.b(str2, str2.length(), i8, sb);
        if (i9 == 0) {
            sb.append('\"');
        }
        return sb.toString();
    }
}
