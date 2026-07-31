package J3;

import D1.P;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.expr.ConversionType;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e extends C1231k implements Iterable<a>, d<e>, R3.e {

    /* renamed from: x0, reason: collision with root package name */
    public a[] f4640x0;

    /* renamed from: x1, reason: collision with root package name */
    public int f4641x1;

    /* renamed from: y0, reason: collision with root package name */
    public int f4642y0;

    public static final class a extends C1231k {

        /* renamed from: x0, reason: collision with root package name */
        public a f4643x0;

        /* renamed from: x1, reason: collision with root package name */
        public Object f4644x1;

        /* renamed from: y0, reason: collision with root package name */
        public final String f4645y0;

        /* renamed from: y1, reason: collision with root package name */
        public ConversionType f4646y1;

        public a(C1231k c1231k, a aVar, String str, Object obj, ConversionType conversionType) {
            super(13);
            C1231k c1231k2 = (C1231k) c1231k.f9361Y;
            this.f9361Y = c1231k2;
            this.f9362Z = c1231k;
            c1231k.f9361Y = this;
            c1231k2.f9362Z = this;
            this.f4643x0 = aVar;
            this.f4645y0 = str;
            this.f4644x1 = obj;
            this.f4646y1 = conversionType;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    if (this.f4645y0.equals(((a) obj).f4645y0)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f4645y0.hashCode();
        }
    }

    public static final class b implements Iterator<a> {

        /* renamed from: X, reason: collision with root package name */
        public final e f4647X;

        /* renamed from: Y, reason: collision with root package name */
        public C1231k f4648Y;

        /* renamed from: Z, reason: collision with root package name */
        public C1231k f4649Z;

        public b(e eVar) {
            this.f4647X = eVar;
            this.f4649Z = (C1231k) eVar.f9362Z;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4649Z != this.f4647X;
        }

        @Override // java.util.Iterator
        public final a next() {
            C1231k c1231k = this.f4649Z;
            if (c1231k == this.f4647X) {
                throw new NoSuchElementException();
            }
            this.f4648Y = c1231k;
            this.f4649Z = (C1231k) c1231k.f9362Z;
            return (a) c1231k;
        }

        @Override // java.util.Iterator
        public final void remove() {
            C1231k c1231k = this.f4648Y;
            if (c1231k == null) {
                throw new IllegalStateException();
            }
            this.f4647X.s0(((a) c1231k).f4645y0);
            this.f4648Y = null;
        }
    }

    public e() {
        super(13);
        this.f9362Z = this;
        this.f9361Y = this;
        this.f4640x0 = new a[4];
        this.f4642y0 = 3;
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.f(this.f4641x1);
        C1231k c1231k = (C1231k) this.f9362Z;
        while (true) {
            if (!(c1231k != this)) {
                return;
            }
            if (c1231k == this) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            a aVar = (a) c1231k;
            dVar.writeUTF(aVar.f4645y0);
            dVar.g(aVar.f4644x1);
            ConversionType.writeObject(dVar, aVar.f4646y1);
            c1231k = c1231k2;
        }
    }

    public final boolean i0(String str) {
        if (str == null) {
            return false;
        }
        int hashCode = str.hashCode();
        for (a aVar = this.f4640x0[hashCode & (r1.length - 1)]; aVar != null; aVar = aVar.f4643x0) {
            if (aVar.f4645y0.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEmpty() {
        return this.f4641x1 == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<a> iterator() {
        return new b(this);
    }

    public final Object j0(String str) {
        if (str == null) {
            return null;
        }
        int hashCode = str.hashCode();
        for (a aVar = this.f4640x0[hashCode & (r1.length - 1)]; aVar != null; aVar = aVar.f4643x0) {
            if (aVar.f4645y0.equals(str)) {
                return aVar.f4644x1;
            }
        }
        return null;
    }

    public final a k0(String str) {
        if (str == null) {
            return null;
        }
        int hashCode = str.hashCode();
        for (a aVar = this.f4640x0[hashCode & (r1.length - 1)]; aVar != null; aVar = aVar.f4643x0) {
            if (aVar.f4645y0.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final void l0(int i8, String str, Object obj, ConversionType conversionType) {
        a[] aVarArr = this.f4640x0;
        aVarArr[i8] = new a(this, aVarArr[i8], str, obj, conversionType);
        int i9 = this.f4641x1;
        this.f4641x1 = i9 + 1;
        if (i9 < this.f4642y0) {
            return;
        }
        int length = aVarArr.length;
        int i10 = length * 2;
        a[] aVarArr2 = new a[i10];
        while (true) {
            length--;
            if (length < 0) {
                this.f4640x0 = aVarArr2;
                this.f4642y0 = (int) (i10 * 0.75f);
                return;
            }
            a aVar = aVarArr[length];
            if (aVar != null) {
                while (true) {
                    a aVar2 = aVar.f4643x0;
                    int hashCode = aVar.f4645y0.hashCode() & (i10 - 1);
                    aVar.f4643x0 = aVarArr2[hashCode];
                    aVarArr2[hashCode] = aVar;
                    if (aVar2 == null) {
                        break;
                    } else {
                        aVar = aVar2;
                    }
                }
            }
        }
    }

    public final Object m0(String str, Object obj, ConversionType conversionType) {
        int hashCode = str.hashCode();
        int length = hashCode & (r1.length - 1);
        for (a aVar = this.f4640x0[length]; aVar != null; aVar = aVar.f4643x0) {
            if (aVar.f4645y0.equals(str)) {
                Object obj2 = aVar.f4644x1;
                aVar.f4644x1 = obj;
                aVar.f4646y1 = conversionType;
                return obj2;
            }
        }
        l0(length, str, obj, conversionType);
        return null;
    }

    public final void n0(e eVar) {
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            a aVar = (a) c1231k;
            m0(aVar.f4645y0, aVar.f4644x1, aVar.f4646y1);
            c1231k = c1231k2;
        }
    }

    @Override // J3.d
    public final e o(IdentityHashMap identityHashMap) {
        if (identityHashMap == null) {
            return new e(this);
        }
        e eVar = (e) identityHashMap.get(this);
        if (eVar == null) {
            int i8 = this.f4641x1;
            if (i8 == 0) {
                eVar = new e();
                identityHashMap.put(this, eVar);
            } else {
                e eVar2 = new e(i8);
                identityHashMap.put(this, eVar2);
                C1231k c1231k = (C1231k) this.f9362Z;
                while (true) {
                    if (!(c1231k != this)) {
                        return eVar2;
                    }
                    if (c1231k == this) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    a aVar = (a) c1231k;
                    eVar2.m0(aVar.f4645y0, P.g(aVar.f4644x1, identityHashMap), aVar.f4646y1);
                    c1231k = c1231k2;
                }
            }
        }
        return eVar;
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int d8 = cVar.d();
        if (d8 >= this.f4642y0) {
            int a8 = y4.j.a((int) Math.ceil(d8 / 0.75f));
            this.f4640x0 = new a[a8];
            this.f4642y0 = (int) (a8 * 0.75f);
        }
        while (true) {
            d8--;
            if (d8 < 0) {
                return;
            }
            String readUTF = cVar.readUTF();
            l0(readUTF.hashCode() & (this.f4640x0.length - 1), readUTF, cVar.readObject(), ConversionType.readObject(cVar));
        }
    }

    public final Object p0(String str, Object obj, ConversionType conversionType) {
        int hashCode = str.hashCode();
        int length = hashCode & (r1.length - 1);
        for (a aVar = this.f4640x0[length]; aVar != null; aVar = aVar.f4643x0) {
            if (aVar.f4645y0.equals(str)) {
                return aVar.f4644x1;
            }
        }
        l0(length, str, obj, conversionType);
        return null;
    }

    public final void r0(e eVar) {
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            s0(((a) c1231k).f4645y0);
            c1231k = c1231k2;
        }
    }

    public final a s0(String str) {
        int hashCode = str.hashCode();
        int length = hashCode & (r1.length - 1);
        a aVar = this.f4640x0[length];
        a aVar2 = null;
        while (aVar != null) {
            a aVar3 = aVar.f4643x0;
            if (aVar.f4645y0.equals(str)) {
                if (aVar2 != null) {
                    aVar2.f4643x0 = aVar3;
                } else {
                    this.f4640x0[length] = aVar3;
                }
                aVar.f4643x0 = null;
                Object obj = aVar.f9361Y;
                ((C1231k) obj).f9362Z = (C1231k) aVar.f9362Z;
                ((C1231k) aVar.f9362Z).f9361Y = (C1231k) obj;
                aVar.f9362Z = this;
                aVar.f9361Y = this;
                this.f4641x1--;
                return aVar;
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return null;
    }

    public final <T> T[] t0(T[] tArr) {
        if (tArr.length < this.f4641x1) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f4641x1));
        }
        C1231k c1231k = (C1231k) this.f9362Z;
        int i8 = 0;
        while (true) {
            if (!(c1231k != this)) {
                Arrays.fill(tArr, this.f4641x1, tArr.length, (Object) null);
                return tArr;
            }
            if (c1231k == this) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            tArr[i8] = ((a) c1231k).f4645y0;
            c1231k = c1231k2;
            i8++;
        }
    }

    public final String toString() {
        return v0(", ");
    }

    public final String v0(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            C1231k c1231k = (C1231k) this.f9362Z;
            String str2 = "";
            while (true) {
                if (!(c1231k != this)) {
                    break;
                }
                if (c1231k == this) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                a aVar = (a) c1231k;
                sb.append(str2);
                sb.append(aVar.f4645y0);
                if (aVar.f4646y1 != null) {
                    sb.append(" as ");
                    sb.append(aVar.f4646y1);
                }
                sb.append(": ");
                sb.append(h.e0(aVar.f4644x1));
                str2 = str;
                c1231k = c1231k2;
            }
        } else {
            C1231k c1231k3 = (C1231k) this.f9362Z;
            while (true) {
                if (!(c1231k3 != this)) {
                    break;
                }
                if (c1231k3 == this) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k4 = (C1231k) c1231k3.f9362Z;
                a aVar2 = (a) c1231k3;
                sb.append(aVar2.f4645y0);
                if (aVar2.f4646y1 != null) {
                    sb.append(" as ");
                    sb.append(aVar2.f4646y1);
                }
                sb.append(": ");
                sb.append(h.e0(aVar2.f4644x1));
                c1231k3 = c1231k4;
            }
        }
        return sb.toString();
    }

    public e(int i8) {
        super(13);
        this.f9362Z = this;
        this.f9361Y = this;
        int a8 = y4.j.a((int) Math.ceil(i8 / 0.75f));
        this.f4640x0 = new a[a8];
        this.f4642y0 = (int) (a8 * 0.75f);
    }

    public e(e eVar) {
        this(eVar.f4641x1);
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return;
            }
            if (c1231k != eVar) {
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                a aVar = (a) c1231k;
                Object obj = aVar.f4644x1;
                ConversionType conversionType = aVar.f4646y1;
                String str = aVar.f4645y0;
                l0(str.hashCode() & (this.f4640x0.length - 1), str, obj, conversionType);
                c1231k = c1231k2;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
