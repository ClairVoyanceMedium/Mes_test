package J3;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class i implements Comparator<Object> {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ Map f4653X;

    /* renamed from: Y, reason: collision with root package name */
    public final /* synthetic */ Collator f4654Y;

    public i(IdentityHashMap identityHashMap, Collator collator) {
        this.f4653X = identityHashMap;
        this.f4654Y = collator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Map map = this.f4653X;
        CollationKey collationKey = (CollationKey) map.get(obj);
        Collator collator = this.f4654Y;
        if (collationKey == null) {
            collationKey = collator.getCollationKey(h.f0("", obj));
            map.put(obj, collationKey);
        }
        CollationKey collationKey2 = (CollationKey) map.get(obj2);
        if (collationKey2 == null) {
            collationKey2 = collator.getCollationKey(h.f0("", obj2));
            map.put(obj2, collationKey2);
        }
        return collationKey.compareTo(collationKey2);
    }
}
