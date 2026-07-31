package R3;

import R3.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import d4.C1725f;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.util.IdentityHashMap;

/* loaded from: classes.dex */
public class d extends C1725f {

    /* renamed from: Y, reason: collision with root package name */
    public final IdentityHashMap<Object, Integer> f6412Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f6413Z;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f6414x0;

    public d(OutputStream outputStream) {
        super(outputStream);
        this.f6412Y = new IdentityHashMap<>();
    }

    public void g(Object obj) {
        int i8;
        if (obj == null) {
            i8 = 0;
        } else {
            IdentityHashMap<Object, Integer> identityHashMap = this.f6412Y;
            Integer num = identityHashMap.get(obj);
            if (num == null) {
                f fVar = (f) g.d.f6421a.f6419b.get(obj.getClass());
                if (fVar == null) {
                    throw new InvalidObjectException("Illegal object: " + obj.getClass());
                }
                identityHashMap.put(obj, Integer.valueOf(identityHashMap.size() + 1));
                c(fVar.f6416a);
                fVar.b(this, obj);
                return;
            }
            i8 = -num.intValue();
        }
        c(i8);
    }

    public final <T> void h(T[] tArr) {
        f(tArr.length);
        for (T t8 : tArr) {
            g(t8);
        }
    }

    public final void i(Parcelable parcelable) {
        if (parcelable == null) {
            f(0);
            return;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                parcelable.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                f(marshall.length);
                write(marshall);
                flush();
            } catch (RuntimeException e8) {
                throw new IOException("Failed to marshal: " + parcelable.getClass(), e8);
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void k(String str) {
        if (str == null) {
            str = "";
        }
        writeUTF(str);
    }

    public final <T extends Parcelable> void m(T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            f(0);
            return;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.writeTypedArray(tArr, 0);
                byte[] marshall = obtain.marshall();
                f(marshall.length);
                write(marshall);
                flush();
            } catch (RuntimeException e8) {
                throw new IOException("Failed to marshal: " + tArr.getClass().getComponentType() + "[]", e8);
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void n(Uri uri) {
        k(uri != null ? uri.toString() : null);
    }

    public final void p(int i8) {
        this.f6413Z = i8;
        writeShort(i8);
    }

    @Override // d4.C1725f, java.io.DataOutput
    public final void writeUTF(String str) {
        if (this.f6414x0) {
            b(str);
            return;
        }
        byte[] a8 = C1725f.a(65535, str);
        writeShort((short) a8.length);
        write(a8);
    }
}
