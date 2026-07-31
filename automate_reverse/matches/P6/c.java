package P6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: Y, reason: collision with root package name */
    public final int f5968Y;

    /* renamed from: Z, reason: collision with root package name */
    public final h f5969Z;

    public c(int i8, h hVar) {
        super(false);
        this.f5968Y = i8;
        this.f5969Z = hVar;
    }

    public static c a(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj instanceof DataInputStream) {
            return new c(((DataInputStream) obj).readInt(), h.a(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(C2305a.i((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                c a8 = a(dataInputStream2);
                dataInputStream2.close();
                return a8;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f5968Y != cVar.f5968Y) {
            return false;
        }
        return this.f5969Z.equals(cVar.f5969Z);
    }

    @Override // l7.d
    public final byte[] getEncoded() {
        C2472a t8 = C2472a.t();
        t8.z(this.f5968Y);
        t8.s(this.f5969Z.getEncoded());
        return t8.l();
    }

    public final int hashCode() {
        return this.f5969Z.hashCode() + (this.f5968Y * 31);
    }
}
