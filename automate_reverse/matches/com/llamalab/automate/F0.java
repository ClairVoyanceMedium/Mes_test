package com.llamalab.automate;

import android.content.Context;
import android.util.SparseArray;
import com.llamalab.automate.A2;
import com.llamalab.automate.Visitor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class F0 implements R3.e, T2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f14841L1;

    /* renamed from: X, reason: collision with root package name */
    public String f14842X;

    /* renamed from: Y, reason: collision with root package name */
    public String f14843Y;

    /* renamed from: Z, reason: collision with root package name */
    public A2[] f14844Z;

    /* renamed from: x0, reason: collision with root package name */
    public SparseArray<b> f14845x0;

    /* renamed from: x1, reason: collision with root package name */
    public long f14846x1;

    /* renamed from: y0, reason: collision with root package name */
    public long f14847y0;

    /* renamed from: y1, reason: collision with root package name */
    public int f14848y1;

    public class a extends AbstractC1595k {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ A2[] f14849b;

        public a(A2[] a2Arr) {
            this.f14849b = a2Arr;
        }

        @Override // com.llamalab.automate.Visitor
        public final void b(T2 t22) {
            if (c(t22) && (t22 instanceof A2)) {
                A2.a aVar = A2.f14470F1;
                if (Arrays.binarySearch(this.f14849b, (A2) t22, aVar) < 0) {
                    throw Visitor.AbortException.f15398X;
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f14850a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14851b;

        public b(int i8, long[] jArr) {
            this.f14850a = jArr;
            this.f14851b = i8;
        }
    }

    public F0() {
        this.f14841L1 = 1;
        this.f14844Z = A2.f14469E1;
    }

    public final CharSequence A(Context context) {
        String str = this.f14842X;
        return str != null ? str : context.getText(C2541R.string.untitled);
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.writeInt(1279346284);
        dVar.p(114);
        dVar.f6414x0 = true;
        dVar.d(this.f14846x1);
        dVar.f(this.f14844Z.length);
        for (A2 a22 : this.f14844Z) {
            dVar.g(a22);
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        for (A2 a22 : this.f14844Z) {
            visitor.b(a22);
        }
    }

    public final <T extends A2> T b(long j8) {
        for (A2 a22 : this.f14844Z) {
            T t8 = (T) a22;
            if (t8.g() == j8) {
                return t8;
            }
        }
        return null;
    }

    public final b c(int i8) {
        SparseArray<b> sparseArray = this.f14845x0;
        if (sparseArray != null) {
            b bVar = sparseArray.get(i8);
            if (bVar != null) {
                return bVar;
            }
        } else {
            this.f14845x0 = new SparseArray<>(1);
        }
        C1625r2 c1625r2 = new C1625r2(i8);
        c1625r2.b(this);
        b bVar2 = new b(c1625r2.f16206d, c1625r2.f16205c);
        this.f14845x0.put(i8, bVar2);
        return bVar2;
    }

    public final TreeMap d(boolean z7) {
        TreeMap i8 = M3.d.i(z7);
        new G0(i8).b(this);
        return i8;
    }

    public final int e(R3.c cVar, boolean z7) {
        int readInt = cVar.readInt();
        if (1279346284 != readInt) {
            throw new StreamCorruptedException(B4.g.f(readInt, new StringBuilder("Bad magic: 0x")));
        }
        cVar.f6410y0 = 35 <= cVar.n(z7 ? 114 : Integer.MAX_VALUE);
        this.f14846x1 = cVar.b();
        return cVar.d();
    }

    public final void f(InputStream inputStream, R3.h hVar) {
        R3.c cVar = new R3.c(inputStream);
        try {
            cVar.f6408Z = hVar;
            o0(cVar);
        } finally {
            cVar.close();
        }
    }

    public final void h(byte[] bArr, R3.h hVar) {
        f(new ByteArrayInputStream(bArr), hVar);
    }

    public final byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        R3.d dVar = new R3.d(byteArrayOutputStream);
        try {
            Y0(dVar);
            dVar.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            dVar.close();
            throw th;
        }
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int i8 = 1;
        int e8 = e(cVar, true);
        if (e8 == 0) {
            return;
        }
        this.f14844Z = new A2[e8];
        for (int i9 = 0; i9 < e8; i9++) {
            this.f14844Z[i9] = (A2) cVar.readObject();
        }
        A2[] a2Arr = new A2[e8];
        System.arraycopy(this.f14844Z, 0, a2Arr, 0, e8);
        Arrays.sort(a2Arr, A2.f14470F1);
        long g8 = a2Arr[0].g();
        while (i8 < e8) {
            long g9 = a2Arr[i8].g();
            if (g9 == g8) {
                throw new InvalidObjectException("Duplicate statement id: " + g9);
            }
            i8++;
            g8 = g9;
        }
        if (this.f14846x1 < g8) {
            this.f14846x1 = g8 + 1;
        }
        try {
            new a(a2Arr).b(this);
        } catch (Visitor.AbortException unused) {
            throw new InvalidObjectException("Invalid statement list");
        }
    }

    public final String toString() {
        return super.toString() + "[id=" + this.f14847y0 + "]";
    }

    public F0(A2[] a2Arr, long j8) {
        this.f14841L1 = 1;
        this.f14844Z = a2Arr;
        this.f14846x1 = j8;
    }
}
