package P6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: Y, reason: collision with root package name */
    public final int f5962Y;

    /* renamed from: Z, reason: collision with root package name */
    public final boolean f5963Z;

    /* renamed from: x0, reason: collision with root package name */
    public final List<g> f5964x0;

    /* renamed from: x1, reason: collision with root package name */
    public final long f5965x1;

    /* renamed from: y0, reason: collision with root package name */
    public final List<i> f5966y0;

    /* renamed from: y1, reason: collision with root package name */
    public final long f5967y1;

    public b(int i8, ArrayList arrayList, ArrayList arrayList2, long j8, long j9, boolean z7) {
        super(true);
        this.f5967y1 = 0L;
        this.f5962Y = i8;
        this.f5964x0 = Collections.unmodifiableList(arrayList);
        this.f5966y0 = Collections.unmodifiableList(arrayList2);
        this.f5967y1 = j8;
        this.f5965x1 = j9;
        this.f5963Z = z7;
    }

    public static b a(Object obj) {
        DataInputStream dataInputStream;
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            if (dataInputStream2.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int readInt = dataInputStream2.readInt();
            long readLong = dataInputStream2.readLong();
            long readLong2 = dataInputStream2.readLong();
            boolean readBoolean = dataInputStream2.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i8 = 0; i8 < readInt; i8++) {
                arrayList.add(g.d(obj));
            }
            for (int i9 = 0; i9 < readInt - 1; i9++) {
                arrayList2.add(i.a(obj));
            }
            return new b(readInt, arrayList, arrayList2, readLong, readLong2, readBoolean);
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
                b a8 = a(dataInputStream);
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

    public final Object clone() {
        try {
            return a(getEncoded());
        } catch (Exception e8) {
            throw new RuntimeException(e8.getMessage(), e8);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5962Y == bVar.f5962Y && this.f5963Z == bVar.f5963Z && this.f5965x1 == bVar.f5965x1 && this.f5967y1 == bVar.f5967y1 && this.f5964x0.equals(bVar.f5964x0)) {
            return this.f5966y0.equals(bVar.f5966y0);
        }
        return false;
    }

    @Override // l7.d
    public final synchronized byte[] getEncoded() {
        C2472a t8;
        t8 = C2472a.t();
        t8.z(0);
        t8.z(this.f5962Y);
        long j8 = this.f5967y1;
        t8.z((int) (j8 >>> 32));
        t8.z((int) j8);
        long j9 = this.f5965x1;
        t8.z((int) (j9 >>> 32));
        t8.z((int) j9);
        ((ByteArrayOutputStream) t8.f23561X).write(this.f5963Z ? 1 : 0);
        Iterator<g> it = this.f5964x0.iterator();
        while (it.hasNext()) {
            t8.r(it.next());
        }
        Iterator<i> it2 = this.f5966y0.iterator();
        while (it2.hasNext()) {
            t8.r(it2.next());
        }
        return t8.l();
    }

    public final int hashCode() {
        int hashCode = (this.f5966y0.hashCode() + ((this.f5964x0.hashCode() + (((this.f5962Y * 31) + (this.f5963Z ? 1 : 0)) * 31)) * 31)) * 31;
        long j8 = this.f5965x1;
        int i8 = (hashCode + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j9 = this.f5967y1;
        return i8 + ((int) (j9 ^ (j9 >>> 32)));
    }
}
