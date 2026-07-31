package P6;

import P5.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.WeakHashMap;
import l5.C2125u;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class g extends f {

    /* renamed from: P1, reason: collision with root package name */
    public static final a f5983P1;

    /* renamed from: Q1, reason: collision with root package name */
    public static final a[] f5984Q1;

    /* renamed from: L1, reason: collision with root package name */
    public final int f5985L1;

    /* renamed from: M1, reason: collision with root package name */
    public final o f5986M1;

    /* renamed from: N1, reason: collision with root package name */
    public final int f5987N1;

    /* renamed from: O1, reason: collision with root package name */
    public h f5988O1;

    /* renamed from: Y, reason: collision with root package name */
    public final byte[] f5989Y;

    /* renamed from: Z, reason: collision with root package name */
    public final j f5990Z;

    /* renamed from: x0, reason: collision with root package name */
    public final d f5991x0;

    /* renamed from: x1, reason: collision with root package name */
    public final byte[] f5992x1;

    /* renamed from: y0, reason: collision with root package name */
    public final int f5993y0;

    /* renamed from: y1, reason: collision with root package name */
    public final WeakHashMap f5994y1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5995a;

        public a(int i8) {
            this.f5995a = i8;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && ((a) obj).f5995a == this.f5995a;
        }

        public final int hashCode() {
            return this.f5995a;
        }
    }

    static {
        a aVar = new a(1);
        f5983P1 = aVar;
        a[] aVarArr = new a[129];
        f5984Q1 = aVarArr;
        aVarArr[1] = aVar;
        int i8 = 2;
        while (true) {
            a[] aVarArr2 = f5984Q1;
            if (i8 >= aVarArr2.length) {
                return;
            }
            aVarArr2[i8] = new a(i8);
            i8++;
        }
    }

    public g(j jVar, d dVar, int i8, byte[] bArr, int i9, byte[] bArr2) {
        super(true);
        this.f5990Z = jVar;
        this.f5991x0 = dVar;
        this.f5987N1 = i8;
        this.f5989Y = l7.a.c(bArr);
        this.f5993y0 = i9;
        this.f5992x1 = l7.a.c(bArr2);
        this.f5985L1 = 1 << (jVar.f6012c + 1);
        this.f5994y1 = new WeakHashMap();
        this.f5986M1 = P6.a.a(jVar.f6013d);
    }

    public static g d(Object obj) {
        DataInputStream dataInputStream;
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            if (dataInputStream2.readInt() != 0) {
                throw new IllegalStateException("expected version 0 lms private key");
            }
            j jVar = j.f6009j.get(Integer.valueOf(dataInputStream2.readInt()));
            d dVar = d.f5974j.get(Integer.valueOf(dataInputStream2.readInt()));
            byte[] bArr = new byte[16];
            dataInputStream2.readFully(bArr);
            int readInt = dataInputStream2.readInt();
            int readInt2 = dataInputStream2.readInt();
            int readInt3 = dataInputStream2.readInt();
            if (readInt3 < 0) {
                throw new IllegalStateException("secret length less than zero");
            }
            if (readInt3 <= dataInputStream2.available()) {
                byte[] bArr2 = new byte[readInt3];
                dataInputStream2.readFully(bArr2);
                return new g(jVar, dVar, readInt, bArr, readInt2, bArr2);
            }
            throw new IOException("secret length exceeded " + dataInputStream2.available());
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return d(C2305a.i((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                g d8 = d(dataInputStream);
                dataInputStream.close();
                return d8;
            } catch (Throwable th) {
                th = th;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
    }

    public final byte[] a(int i8) {
        int i9 = 1 << this.f5990Z.f6012c;
        byte[] bArr = this.f5989Y;
        o oVar = this.f5986M1;
        if (i8 < i9) {
            int i10 = i8 * 2;
            byte[] b8 = b(i10);
            byte[] b9 = b(i10 + 1);
            byte[] c8 = l7.a.c(bArr);
            oVar.update(c8, 0, c8.length);
            oVar.d((byte) (i8 >>> 24));
            oVar.d((byte) (i8 >>> 16));
            oVar.d((byte) (i8 >>> 8));
            oVar.d((byte) i8);
            oVar.d((byte) 16777091);
            oVar.d((byte) (-31869));
            oVar.update(b8, 0, b8.length);
            oVar.update(b9, 0, b9.length);
            byte[] bArr2 = new byte[oVar.e()];
            oVar.c(bArr2, 0);
            return bArr2;
        }
        byte[] c9 = l7.a.c(bArr);
        oVar.update(c9, 0, c9.length);
        oVar.d((byte) (i8 >>> 24));
        oVar.d((byte) (i8 >>> 16));
        oVar.d((byte) (i8 >>> 8));
        oVar.d((byte) i8);
        oVar.d((byte) 16777090);
        oVar.d((byte) (-32126));
        byte[] c10 = l7.a.c(bArr);
        int i11 = i8 - i9;
        byte[] c11 = l7.a.c(this.f5992x1);
        d dVar = this.f5991x0;
        o a8 = P6.a.a(dVar.f5979e);
        C2472a t8 = C2472a.t();
        t8.s(c10);
        t8.z(i11);
        ((ByteArrayOutputStream) t8.f23561X).write((byte) 128);
        ((ByteArrayOutputStream) t8.f23561X).write((byte) 32896);
        while (((ByteArrayOutputStream) t8.f23561X).size() < 22) {
            ((ByteArrayOutputStream) t8.f23561X).write(0);
        }
        byte[] l8 = t8.l();
        a8.update(l8, 0, l8.length);
        C2125u c2125u = dVar.f5979e;
        o a9 = P6.a.a(c2125u);
        C2472a t9 = C2472a.t();
        t9.s(c10);
        t9.z(i11);
        int e8 = a9.e() + 23;
        while (((ByteArrayOutputStream) t9.f23561X).size() < e8) {
            ((ByteArrayOutputStream) t9.f23561X).write(0);
        }
        byte[] l9 = t9.l();
        o a10 = P6.a.a(c2125u);
        int i12 = (1 << dVar.f5977c) - 1;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = dVar.f5978d;
            if (i14 >= i15) {
                int e9 = a8.e();
                byte[] bArr3 = new byte[e9];
                a8.c(bArr3, 0);
                oVar.update(bArr3, 0, e9);
                byte[] bArr4 = new byte[oVar.e()];
                oVar.c(bArr4, 0);
                return bArr4;
            }
            boolean z7 = i14 < i15 + (-1);
            if (l9.length < a10.e()) {
                throw new IllegalArgumentException("target length is less than digest size.");
            }
            a10.update(c10, 0, c10.length);
            a10.d((byte) (i11 >>> 24));
            a10.d((byte) (i11 >>> 16));
            a10.d((byte) (i11 >>> 8));
            a10.d((byte) i11);
            a10.d((byte) (i13 >>> 8));
            a10.d((byte) i13);
            a10.d((byte) -1);
            a10.update(c11, 0, c11.length);
            a10.c(l9, 23);
            if (z7) {
                i13++;
            }
            short s8 = (short) i14;
            l9[20] = (byte) (s8 >>> 8);
            l9[21] = (byte) s8;
            for (int i16 = 0; i16 < i12; i16++) {
                l9[22] = (byte) i16;
                a9.update(l9, 0, l9.length);
                a9.c(l9, 23);
            }
            a8.update(l9, 23, dVar.f5976b);
            i14++;
        }
    }

    public final byte[] b(int i8) {
        if (i8 < this.f5985L1) {
            return c(i8 < 129 ? f5984Q1[i8] : new a(i8));
        }
        return a(i8);
    }

    public final byte[] c(a aVar) {
        synchronized (this.f5994y1) {
            byte[] bArr = (byte[]) this.f5994y1.get(aVar);
            if (bArr != null) {
                return bArr;
            }
            byte[] a8 = a(aVar.f5995a);
            this.f5994y1.put(aVar, a8);
            return a8;
        }
    }

    public final h e() {
        h hVar;
        synchronized (this) {
            if (this.f5988O1 == null) {
                this.f5988O1 = new h(this.f5990Z, this.f5991x0, c(f5983P1), this.f5989Y);
            }
            hVar = this.f5988O1;
        }
        return hVar;
    }

    public final boolean equals(Object obj) {
        h hVar;
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f5987N1 != gVar.f5987N1 || this.f5993y0 != gVar.f5993y0 || !Arrays.equals(this.f5989Y, gVar.f5989Y)) {
            return false;
        }
        j jVar = gVar.f5990Z;
        j jVar2 = this.f5990Z;
        if (jVar2 == null ? jVar != null : !jVar2.equals(jVar)) {
            return false;
        }
        d dVar = gVar.f5991x0;
        d dVar2 = this.f5991x0;
        if (dVar2 == null ? dVar != null : !dVar2.equals(dVar)) {
            return false;
        }
        if (!Arrays.equals(this.f5992x1, gVar.f5992x1)) {
            return false;
        }
        h hVar2 = this.f5988O1;
        if (hVar2 == null || (hVar = gVar.f5988O1) == null) {
            return true;
        }
        return hVar2.equals(hVar);
    }

    @Override // l7.d
    public final byte[] getEncoded() {
        C2472a t8 = C2472a.t();
        t8.z(0);
        t8.z(this.f5990Z.f6010a);
        t8.z(this.f5991x0.f5975a);
        t8.s(this.f5989Y);
        t8.z(this.f5987N1);
        t8.z(this.f5993y0);
        byte[] bArr = this.f5992x1;
        t8.z(bArr.length);
        t8.s(bArr);
        return t8.l();
    }

    public final int hashCode() {
        int n8 = (l7.a.n(this.f5989Y) + (this.f5987N1 * 31)) * 31;
        j jVar = this.f5990Z;
        int hashCode = (n8 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        d dVar = this.f5991x0;
        int n9 = (l7.a.n(this.f5992x1) + ((((hashCode + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.f5993y0) * 31)) * 31;
        h hVar = this.f5988O1;
        return n9 + (hVar != null ? hVar.hashCode() : 0);
    }
}
