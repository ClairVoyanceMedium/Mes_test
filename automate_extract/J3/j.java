package J3;

import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements Comparator<Object> {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ Map f4655X;

    /* renamed from: Y, reason: collision with root package name */
    public final /* synthetic */ Comparator f4656Y;

    public j(IdentityHashMap identityHashMap, Comparator comparator) {
        this.f4655X = identityHashMap;
        this.f4656Y = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Map map = this.f4655X;
        String str = (String) map.get(obj);
        if (str == null) {
            str = h.f0("", obj);
            map.put(obj, str);
        }
        String str2 = (String) map.get(obj2);
        if (str2 == null) {
            str2 = h.f0("", obj2);
            map.put(obj2, str2);
        }
        return this.f4656Y.compare(str, str2);
    }
}
