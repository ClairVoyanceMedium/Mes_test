package P6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: Y, reason: collision with root package name */
    public final j f5996Y;

    /* renamed from: Z, reason: collision with root package name */
    public final d f5997Z;

    /* renamed from: x0, reason: collision with root package name */
    public final byte[] f5998x0;

    /* renamed from: y0, reason: collision with root package name */
    public final byte[] f5999y0;

    public h(j jVar, d dVar, byte[] bArr, byte[] bArr2) {
        super(false);
        this.f5996Y = jVar;
        this.f5997Z = dVar;
        this.f5998x0 = l7.a.c(bArr2);
        this.f5999y0 = l7.a.c(bArr);
    }

    public static h a(Object obj) {
        DataInputStream dataInputStream;
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            j jVar = j.f6009j.get(Integer.valueOf(dataInputStream2.readInt()));
            d dVar = d.f5974j.get(Integer.valueOf(dataInputStream2.readInt()));
            byte[] bArr = new byte[16];
            dataInputStream2.readFully(bArr);
            byte[] bArr2 = new byte[jVar.f6011b];
            dataInputStream2.readFully(bArr2);
            return new h(jVar, dVar, bArr2, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(C2305a.i((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                h a8 = a(dataInputStream);
                dataInputStream.close();
                return a8;
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f5996Y.equals(hVar.f5996Y) && this.f5997Z.equals(hVar.f5997Z) && Arrays.equals(this.f5998x0, hVar.f5998x0)) {
            return Arrays.equals(this.f5999y0, hVar.f5999y0);
        }
        return false;
    }

    @Override // l7.d
    public final byte[] getEncoded() {
        C2472a t8 = C2472a.t();
        t8.z(this.f5996Y.f6010a);
        t8.z(this.f5997Z.f5975a);
        t8.s(this.f5998x0);
        t8.s(this.f5999y0);
        return t8.l();
    }

    public final int hashCode() {
        return l7.a.n(this.f5999y0) + ((l7.a.n(this.f5998x0) + ((this.f5997Z.hashCode() + (this.f5996Y.hashCode() * 31)) * 31)) * 31);
    }
}
