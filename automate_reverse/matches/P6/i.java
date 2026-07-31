package P6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class i implements l7.d {

    /* renamed from: X, reason: collision with root package name */
    public final int f6000X;

    /* renamed from: Y, reason: collision with root package name */
    public final e f6001Y;

    /* renamed from: Z, reason: collision with root package name */
    public final j f6002Z;

    /* renamed from: x0, reason: collision with root package name */
    public final byte[][] f6003x0;

    public i(int i8, e eVar, j jVar, byte[][] bArr) {
        this.f6000X = i8;
        this.f6001Y = eVar;
        this.f6002Z = jVar;
        this.f6003x0 = bArr;
    }

    public static i a(Object obj) {
        DataInputStream dataInputStream;
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            int readInt = dataInputStream2.readInt();
            e a8 = e.a(obj);
            j jVar = j.f6009j.get(Integer.valueOf(dataInputStream2.readInt()));
            int i8 = jVar.f6012c;
            byte[][] bArr = new byte[i8][];
            for (int i9 = 0; i9 < i8; i9++) {
                byte[] bArr2 = new byte[jVar.f6011b];
                bArr[i9] = bArr2;
                dataInputStream2.readFully(bArr2);
            }
            return new i(readInt, a8, jVar, bArr);
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
                i a9 = a(dataInputStream);
                dataInputStream.close();
                return a9;
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
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f6000X != iVar.f6000X) {
            return false;
        }
        e eVar = iVar.f6001Y;
        e eVar2 = this.f6001Y;
        if (eVar2 == null ? eVar != null : !eVar2.equals(eVar)) {
            return false;
        }
        j jVar = iVar.f6002Z;
        j jVar2 = this.f6002Z;
        if (jVar2 == null ? jVar == null : jVar2.equals(jVar)) {
            return Arrays.deepEquals(this.f6003x0, iVar.f6003x0);
        }
        return false;
    }

    @Override // l7.d
    public final byte[] getEncoded() {
        C2472a t8 = C2472a.t();
        t8.z(this.f6000X);
        t8.s(this.f6001Y.getEncoded());
        t8.z(this.f6002Z.f6010a);
        try {
            for (byte[] bArr : this.f6003x0) {
                ((ByteArrayOutputStream) t8.f23561X).write(bArr);
            }
            return t8.l();
        } catch (Exception e8) {
            throw new RuntimeException(e8.getMessage(), e8);
        }
    }

    public final int hashCode() {
        int i8 = this.f6000X * 31;
        e eVar = this.f6001Y;
        int hashCode = (i8 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        j jVar = this.f6002Z;
        return Arrays.deepHashCode(this.f6003x0) + ((hashCode + (jVar != null ? jVar.hashCode() : 0)) * 31);
    }
}
