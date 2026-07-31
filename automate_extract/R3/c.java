package R3;

import J3.m;
import R3.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.llamalab.automate.io.InvalidVersionException;
import d4.C1724e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class c extends C1724e {

    /* renamed from: Y, reason: collision with root package name */
    public final ArrayList f6407Y;

    /* renamed from: Z, reason: collision with root package name */
    public h f6408Z;

    /* renamed from: x0, reason: collision with root package name */
    public int f6409x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f6410y0;

    public static class a extends c {

        /* renamed from: x1, reason: collision with root package name */
        public final Map<CharSequence, m> f6411x1;

        public a(ByteArrayInputStream byteArrayInputStream, TreeMap treeMap) {
            super(byteArrayInputStream);
            this.f6411x1 = treeMap;
        }

        @Override // R3.c
        public final <T> T readObject() {
            T t8;
            T t9 = (T) super.readObject();
            return (!(t9 instanceof m) || (t8 = (T) this.f6411x1.get(t9.toString())) == null) ? t9 : t8;
        }
    }

    public c(InputStream inputStream) {
        super(inputStream);
        this.f6407Y = new ArrayList();
    }

    public final void f(Object obj) {
        this.f6407Y.add(obj);
    }

    public final <T> T[] g(T[] tArr) {
        int d8 = d();
        if (tArr.length != d8) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d8));
        }
        for (int i8 = 0; i8 < d8; i8++) {
            tArr[i8] = readObject();
        }
        return tArr;
    }

    public final <T extends Parcelable> T h(Parcelable.Creator<T> creator) {
        int d8 = d();
        if (d8 == 0) {
            return null;
        }
        byte[] bArr = new byte[d8];
        readFully(bArr, 0, d8);
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, d8);
            obtain.setDataPosition(0);
            obtain.setDataSize(d8);
            return creator.createFromParcel(obtain);
        } catch (RuntimeException e8) {
            IOException iOException = new IOException("Failed to read parcel: " + creator, e8);
            h hVar = this.f6408Z;
            if (hVar == null) {
                throw iOException;
            }
            hVar.j();
            return null;
        } finally {
            obtain.recycle();
        }
    }

    public final String i() {
        String readUTF = readUTF();
        if (readUTF.isEmpty()) {
            return null;
        }
        return readUTF;
    }

    public final <T extends Parcelable> void k(T[] tArr, Parcelable.Creator<T> creator) {
        int d8 = d();
        if (d8 != 0) {
            byte[] bArr = new byte[d8];
            readFully(bArr, 0, d8);
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(bArr, 0, d8);
                    obtain.setDataPosition(0);
                    obtain.setDataSize(d8);
                    obtain.readTypedArray(tArr, creator);
                } catch (RuntimeException e8) {
                    IOException iOException = new IOException("Failed to read parcel: " + creator, e8);
                    h hVar = this.f6408Z;
                    if (hVar == null) {
                        throw iOException;
                    }
                    hVar.j();
                }
            } finally {
                obtain.recycle();
            }
        }
    }

    public final Uri m() {
        String i8 = i();
        if (i8 != null) {
            return Uri.parse(i8);
        }
        return null;
    }

    public final int n(int i8) {
        int readUnsignedShort = readUnsignedShort();
        this.f6409x0 = readUnsignedShort;
        if (readUnsignedShort <= i8) {
            return readUnsignedShort;
        }
        throw new InvalidVersionException(readUnsignedShort);
    }

    public <T> T readObject() {
        int a8 = a();
        if (a8 < 0) {
            try {
                return (T) this.f6407Y.get((-a8) - 1);
            } catch (IndexOutOfBoundsException unused) {
                throw new InvalidObjectException(B4.g.g("Illegal object reference: ", a8));
            }
        }
        f<?> fVar = null;
        if (a8 <= 0) {
            return null;
        }
        f<?>[] fVarArr = g.d.f6421a.f6418a;
        int length = fVarArr.length - 1;
        int i8 = 0;
        while (true) {
            if (i8 <= length) {
                int i9 = (i8 + length) >>> 1;
                f<?> fVar2 = fVarArr[i9];
                int i10 = fVar2.f6416a;
                if (i10 >= a8) {
                    if (i10 <= a8) {
                        fVar = fVar2;
                        break;
                    }
                    length = i9 - 1;
                } else {
                    i8 = i9 + 1;
                }
            } else {
                break;
            }
        }
        if (fVar != null) {
            return (T) fVar.a(this);
        }
        throw new InvalidObjectException(B4.g.g("Illegal object type: ", a8));
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return this.f6410y0 ? C1724e.c(this, d()) : C1724e.c(this, readUnsignedShort());
    }
}
