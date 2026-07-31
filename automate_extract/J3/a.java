package J3;

import D1.P;
import L3.C1049n;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a extends AbstractCollection<Object> implements d<a>, R3.e {

    /* renamed from: Z, reason: collision with root package name */
    public static final Object[] f4625Z = new Object[0];

    /* renamed from: X, reason: collision with root package name */
    public Object[] f4626X;

    /* renamed from: Y, reason: collision with root package name */
    public int f4627Y;

    /* renamed from: J3.a$a, reason: collision with other inner class name */
    public final class C0026a implements Iterator<Object> {

        /* renamed from: X, reason: collision with root package name */
        public int f4628X;

        /* renamed from: Y, reason: collision with root package name */
        public int f4629Y = -1;

        public C0026a() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4628X < a.this.f4627Y;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i8 = this.f4628X;
            a aVar = a.this;
            if (i8 >= aVar.f4627Y) {
                throw new NoSuchElementException();
            }
            this.f4628X = i8 + 1;
            this.f4629Y = i8;
            return aVar.get(i8);
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i8 = this.f4629Y;
            if (i8 == -1) {
                throw new IllegalStateException();
            }
            a.this.remove(i8);
            this.f4628X = this.f4629Y;
            this.f4629Y = -1;
        }
    }

    public a() {
        this.f4626X = f4625Z;
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        int i8 = this.f4627Y;
        dVar.f(i8);
        int i9 = 0;
        while (true) {
            i8--;
            if (i8 < 0) {
                return;
            }
            dVar.g(this.f4626X[i9]);
            i9++;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        j(this.f4627Y + 1);
        Object[] objArr = this.f4626X;
        int i8 = this.f4627Y;
        this.f4627Y = i8 + 1;
        objArr[i8] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return false;
        }
        j(this.f4627Y + size);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Arrays.fill(this.f4626X, (Object) null);
        this.f4627Y = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr = this.f4626X;
        int i8 = this.f4627Y;
        int i9 = 0;
        while (true) {
            i8--;
            if (i8 < 0) {
                return false;
            }
            if (C1049n.d(obj, objArr[i9])) {
                return true;
            }
            i9++;
        }
    }

    @Override // J3.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a o(IdentityHashMap<d<?>, d<?>> identityHashMap) {
        if (identityHashMap == null) {
            return new a(this);
        }
        a aVar = (a) identityHashMap.get(this);
        if (aVar != null) {
            return aVar;
        }
        int i8 = this.f4627Y;
        if (i8 == 0) {
            a aVar2 = new a();
            identityHashMap.put(this, aVar2);
            return aVar2;
        }
        Object[] objArr = this.f4626X;
        Object[] objArr2 = new Object[i8];
        a aVar3 = new a(i8, objArr2);
        identityHashMap.put(this, aVar3);
        for (int i9 = 0; i9 < i8; i9++) {
            objArr2[i9] = P.g(objArr[i9], identityHashMap);
        }
        return aVar3;
    }

    public final Object get(int i8) {
        int i9 = y4.j.i(i8, this.f4627Y);
        if (i9 < this.f4627Y) {
            return this.f4626X[i9];
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f4627Y == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new C0026a();
    }

    public final void j(int i8) {
        if (i8 > this.f4626X.length) {
            Object[] objArr = new Object[y4.j.a(i8)];
            Object[] objArr2 = this.f4626X;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4626X = objArr;
        }
    }

    public final String l(String str) {
        StringBuilder sb = new StringBuilder();
        int i8 = 0;
        if (str != null && !str.isEmpty()) {
            int i9 = this.f4627Y;
            String str2 = "";
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                sb.append(str2);
                sb.append(h.e0(this.f4626X[i8]));
                i8++;
                str2 = str;
            }
        } else {
            int i10 = this.f4627Y;
            while (true) {
                i10--;
                if (i10 < 0) {
                    break;
                }
                sb.append(h.e0(this.f4626X[i8]));
                i8++;
            }
        }
        return sb.toString();
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int d8 = cVar.d();
        this.f4627Y = d8;
        this.f4626X = new Object[d8];
        int i8 = 0;
        while (true) {
            d8--;
            if (d8 < 0) {
                return;
            }
            this.f4626X[i8] = cVar.readObject();
            i8++;
        }
    }

    public final Object remove(int i8) {
        int i9 = y4.j.i(i8, this.f4627Y);
        if (i9 >= this.f4627Y) {
            return null;
        }
        Object[] objArr = this.f4626X;
        Object obj = objArr[i9];
        System.arraycopy(objArr, i9 + 1, objArr, i9, (r0 - i9) - 1);
        Object[] objArr2 = this.f4626X;
        int i10 = this.f4627Y - 1;
        this.f4627Y = i10;
        objArr2[i10] = null;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f4627Y;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int i8 = this.f4627Y;
        if (i8 == 0) {
            return f4625Z;
        }
        Object[] objArr = new Object[i8];
        System.arraycopy(this.f4626X, 0, objArr, 0, i8);
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return l(", ");
    }

    public a(int i8) {
        this.f4626X = i8 == 0 ? f4625Z : new Object[i8];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        Object[] objArr = this.f4626X;
        int i8 = this.f4627Y;
        int i9 = 0;
        while (true) {
            i8--;
            if (i8 < 0) {
                return false;
            }
            if (C1049n.d(obj, objArr[i9])) {
                remove(i9);
                return true;
            }
            i9++;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i8 = this.f4627Y;
        if (length < i8) {
            objArr = new Object[i8];
        } else {
            Arrays.fill(objArr, i8 + 1, objArr.length, (Object) null);
        }
        System.arraycopy(this.f4626X, 0, objArr, 0, this.f4627Y);
        return objArr;
    }

    public a(int i8, Object[] objArr) {
        this.f4626X = objArr;
        this.f4627Y = i8;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(a aVar) {
        this(r2.length, r2);
        Object[] copyOf = Arrays.copyOf(aVar.f4626X, aVar.f4627Y);
    }
}
