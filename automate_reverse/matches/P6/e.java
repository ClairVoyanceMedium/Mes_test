package P6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class e implements l7.d {

    /* renamed from: X, reason: collision with root package name */
    public final d f5980X;

    /* renamed from: Y, reason: collision with root package name */
    public final byte[] f5981Y;

    /* renamed from: Z, reason: collision with root package name */
    public final byte[] f5982Z;

    public e(d dVar, byte[] bArr, byte[] bArr2) {
        this.f5980X = dVar;
        this.f5981Y = bArr;
        this.f5982Z = bArr2;
    }

    public static e a(Object obj) {
        DataInputStream dataInputStream;
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            d dVar = d.f5974j.get(Integer.valueOf(dataInputStream2.readInt()));
            byte[] bArr = new byte[dVar.f5976b];
            dataInputStream2.readFully(bArr);
            byte[] bArr2 = new byte[dVar.f5978d * dVar.f5976b];
            dataInputStream2.readFully(bArr2);
            return new e(dVar, bArr, bArr2);
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
                e a8 = a(dataInputStream);
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
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        d dVar = eVar.f5980X;
        d dVar2 = this.f5980X;
        if (dVar2 == null ? dVar != null : !dVar2.equals(dVar)) {
            return false;
        }
        if (Arrays.equals(this.f5981Y, eVar.f5981Y)) {
            return Arrays.equals(this.f5982Z, eVar.f5982Z);
        }
        return false;
    }

    @Override // l7.d
    public final byte[] getEncoded() {
        C2472a t8 = C2472a.t();
        t8.z(this.f5980X.f5975a);
        t8.s(this.f5981Y);
        t8.s(this.f5982Z);
        return t8.l();
    }

    public final int hashCode() {
        d dVar = this.f5980X;
        return Arrays.hashCode(this.f5982Z) + ((Arrays.hashCode(this.f5981Y) + ((dVar != null ? dVar.hashCode() : 0) * 31)) * 31);
    }
}
