package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.T2;
import com.llamalab.automate.Visitor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.dinglisch.android.tasker.PluginResultReceiver;
import x3.C2434l;

/* loaded from: classes.dex */
public class C0 implements R3.e, T2 {

    /* renamed from: L1, reason: collision with root package name */
    public static final Pattern f16394L1 = Pattern.compile("%?((\\w+?)([1-9][0-9]*)?)");

    /* renamed from: X, reason: collision with root package name */
    public String f16395X;

    /* renamed from: Y, reason: collision with root package name */
    public String f16396Y;

    /* renamed from: Z, reason: collision with root package name */
    public Bundle f16397Z;

    /* renamed from: x0, reason: collision with root package name */
    public String f16398x0;

    /* renamed from: y1, reason: collision with root package name */
    public boolean f16401y1;

    /* renamed from: y0, reason: collision with root package name */
    public String[] f16400y0 = C2434l.f23396g;

    /* renamed from: x1, reason: collision with root package name */
    public J0[] f16399x1 = J0.f16816x0;

    public static String d(C1708z0 c1708z0, TreeMap treeMap, String str) {
        int length = str.length();
        int indexOf = str.indexOf(37);
        if (indexOf == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i8 = 0;
        do {
            sb.append((CharSequence) str, i8, indexOf);
            i8 = indexOf + 1;
            if (i8 < length) {
                char charAt = str.charAt(i8);
                Pattern pattern = J3.h.f4650a;
                if (Character.isUnicodeIdentifierStart(charAt)) {
                    int i9 = i8;
                    do {
                        i9++;
                        if (i9 >= length) {
                            break;
                        }
                    } while (Character.isUnicodeIdentifierPart(str.charAt(i9)));
                    J3.m mVar = (J3.m) treeMap.get(str.subSequence(i8, i9));
                    if (mVar != null) {
                        sb.append(J3.h.f0("", mVar.c2(c1708z0)));
                        i8 = i9;
                        indexOf = str.indexOf(37, i8);
                    } else {
                        i8 = i9;
                    }
                }
            }
            sb.append((CharSequence) str, indexOf, i8);
            indexOf = str.indexOf(37, i8);
        } while (indexOf != -1);
        sb.append((CharSequence) str, i8, length);
        return sb.toString();
    }

    public static Intent e(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (26 > Build.VERSION.SDK_INT || (queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0)) == null || queryBroadcastReceivers.isEmpty()) {
            return intent;
        }
        ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return intent2.setClassName(activityInfo.packageName, activityInfo.name);
    }

    public static ComponentName h(Context context, Intent intent, PluginResultReceiver pluginResultReceiver) {
        boolean isIgnoringBatteryOptimizations;
        ComponentName startForegroundService;
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        Intent intent2 = new Intent(intent);
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        Intent className = intent2.setClassName(serviceInfo.packageName, serviceInfo.name);
        int i8 = Build.VERSION.SDK_INT;
        if (16 <= i8) {
            className.setFlags(intent.getFlags() & (-268435457));
        }
        if (pluginResultReceiver != null) {
            className.putExtra("net.dinglisch.android.tasker.EXTRA_RESULT_RECEIVER", pluginResultReceiver);
        }
        if (26 <= i8) {
            try {
                if (26 <= packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0).targetSdkVersion) {
                    isIgnoringBatteryOptimizations = ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(resolveInfo.serviceInfo.packageName);
                    if (isIgnoringBatteryOptimizations) {
                        startForegroundService = context.startForegroundService(className);
                        return startForegroundService;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            } catch (IllegalStateException e8) {
                e = e8;
                Log.w("PlugInMixin", "Failed to start plug-in service, fallback to broadcast", e);
                return null;
            } catch (SecurityException e9) {
                e = e9;
                Log.w("PlugInMixin", "Failed to start plug-in service, fallback to broadcast", e);
                return null;
            }
        }
        return context.startService(className);
    }

    @Override // R3.e
    public void Y0(R3.d dVar) {
        dVar.k(this.f16395X);
        dVar.k(this.f16396Y);
        dVar.i(this.f16397Z);
        dVar.k(this.f16398x0);
        String[] strArr = this.f16400y0;
        dVar.f(strArr.length);
        for (String str : strArr) {
            dVar.k(str);
        }
        J0[] j0Arr = this.f16399x1;
        dVar.f(j0Arr.length);
        for (J0 j02 : j0Arr) {
            j02.Y0(dVar);
        }
        dVar.write(this.f16401y1 ? 1 : 0);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.a(this.f16399x1);
    }

    public final Intent b(C1708z0 c1708z0, String str) {
        if (this.f16395X == null || this.f16396Y == null) {
            throw new RequiredArgumentNullException("No plug-in selected");
        }
        Intent intent = new Intent(str).setPackage(this.f16395X);
        if (16 <= Build.VERSION.SDK_INT) {
            intent.addFlags(268435456);
        }
        if (this.f16397Z != null) {
            Bundle bundle = new Bundle(this.f16397Z);
            if (this.f16400y0.length != 0) {
                TreeMap d8 = c1708z0.f17641Z.d(true);
                for (String str2 : this.f16400y0) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof String) {
                        bundle.putString(str2, d(c1708z0, d8, (String) obj));
                    } else if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        int length = strArr.length;
                        String[] strArr2 = new String[length];
                        while (true) {
                            length--;
                            if (length < 0) {
                                break;
                            }
                            String str3 = strArr[length];
                            if (str3 != null) {
                                strArr2[length] = d(c1708z0, d8, str3);
                            }
                        }
                        bundle.putStringArray(str2, strArr2);
                    } else if (obj instanceof ArrayList) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator it = ((ArrayList) obj).iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            arrayList.add(next != null ? d(c1708z0, d8, next.toString()) : null);
                        }
                        bundle.putStringArrayList(str2, arrayList);
                    }
                }
            }
            intent.putExtras(bundle).putExtra("com.twofortyfouram.locale.intent.extra.BUNDLE", bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(".hints.TIMEOUT", 3600000);
        return intent.putExtra("net.dinglisch.android.tasker.extras.HOST_CAPABILITIES", 94).putExtra("net.dinglisch.android.tasker.extras.HINTS", bundle2);
    }

    public final void c(C1708z0 c1708z0, Bundle bundle) {
        Bundle bundle2;
        Iterator<String> it;
        if (bundle == null || (bundle2 = bundle.getBundle("net.dinglisch.android.tasker.extras.VARIABLES")) == null) {
            return;
        }
        List emptyList = Collections.emptyList();
        int i8 = 2;
        HashMap hashMap = new HashMap(2);
        Iterator<String> it2 = bundle2.keySet().iterator();
        TreeMap treeMap = null;
        while (it2.hasNext()) {
            String next = it2.next();
            if (next != null) {
                Matcher matcher = f16394L1.matcher(next);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    Object U7 = J3.h.U(bundle2.get(next));
                    String group2 = matcher.group(3);
                    if (group2 != null) {
                        String group3 = matcher.group(i8);
                        List list = (List) hashMap.get(group3);
                        if (emptyList != list) {
                            long parseLong = Long.parseLong(group2);
                            it = it2;
                            long j8 = parseLong - 1;
                            if (j8 < 65535) {
                                if (list == null) {
                                    list = new ArrayList(4);
                                    hashMap.put(group3, list);
                                }
                                while (list.size() <= j8) {
                                    list.add(null);
                                }
                                list.set((int) j8, U7);
                            } else {
                                hashMap.put(group3, emptyList);
                                Log.w("PlugInMixin", "Ignoring pseudo-array " + group3 + " larger than 65535");
                            }
                        } else {
                            it = it2;
                        }
                    } else {
                        it = it2;
                        hashMap.put(group, emptyList);
                    }
                    if (this.f16401y1 && treeMap == null) {
                        treeMap = c1708z0.f17641Z.d(false);
                    }
                    f(c1708z0, treeMap, group, U7);
                    it2 = it;
                    i8 = 2;
                }
            }
            it = it2;
            Log.w("PlugInMixin", "Illegal variable: " + next);
            it2 = it;
            i8 = 2;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            if (emptyList != list2) {
                String str = (String) entry.getKey();
                Object[] array = list2.toArray();
                f(c1708z0, treeMap, str, new J3.a(array.length, array));
            }
        }
    }

    public final void f(C1708z0 c1708z0, TreeMap treeMap, String str, Object obj) {
        for (J0 j02 : this.f16399x1) {
            if (j02.f16819Z != null && j02.f16817X.equalsIgnoreCase(str)) {
                c1708z0.z(j02.f16819Z.f4659Y, obj);
            }
        }
        if (treeMap != null) {
            J3.m mVar = (J3.m) treeMap.get(str);
            if (mVar instanceof J3.l) {
                c1708z0.z(((J3.l) mVar).f4659Y, obj);
            }
        }
    }

    @Override // R3.e
    public void o0(R3.c cVar) {
        this.f16395X = cVar.i();
        this.f16396Y = cVar.i();
        this.f16397Z = (Bundle) cVar.h(Bundle.CREATOR);
        this.f16398x0 = cVar.i();
        String[] strArr = this.f16400y0;
        int d8 = cVar.d();
        if (strArr.length != d8) {
            strArr = new String[d8];
        }
        for (int i8 = 0; i8 < d8; i8++) {
            strArr[i8] = cVar.i();
        }
        this.f16400y0 = strArr;
        J0[] j0Arr = this.f16399x1;
        Class<?> componentType = j0Arr.getClass().getComponentType();
        int d9 = cVar.d();
        int length = j0Arr.length;
        R3.e[] eVarArr = j0Arr;
        if (length != d9) {
            eVarArr = (R3.e[]) Array.newInstance(componentType, d9);
        }
        for (int i9 = 0; i9 < d9; i9++) {
            try {
                R3.e eVar = (R3.e) componentType.newInstance();
                eVarArr[i9] = eVar;
                eVar.o0(cVar);
            } catch (IllegalAccessException e8) {
                throw new IOException(e8);
            } catch (InstantiationException e9) {
                throw new IOException(e9);
            }
        }
        this.f16399x1 = (J0[]) eVarArr;
        this.f16401y1 = cVar.readBoolean();
    }
}
