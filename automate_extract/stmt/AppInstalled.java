package com.llamalab.automate.stmt;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.util.Log;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.UUID;
import t3.AbstractBinderC2328f;

@F3.f("app_installed.html")
@F3.a(C2541R.integer.ic_app_package)
@F3.i(C2541R.string.stmt_app_installed_title)
@F3.h(C2541R.string.stmt_app_installed_summary)
@F3.e(C2541R.layout.stmt_app_installed_edit)
/* loaded from: classes.dex */
public final class AppInstalled extends IntermittentDecision implements ReceiverStatement, AsyncStatement {
    public InterfaceC1700x0 packageName;
    public J3.l varCacheSize;
    public J3.l varCodeSize;
    public J3.l varDataSize;
    public J3.l varDisplayName;
    public J3.l varPackageName;
    public J3.l varSourceDirs;
    public J3.l varVersionCode;
    public J3.l varVersionName;

    public static final class AppSizeTaskLegacy extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final AbstractBinderC2328f f16250L1 = new AbstractBinderC2328f() { // from class: com.llamalab.automate.stmt.AppInstalled.AppSizeTaskLegacy.1
            @AbstractBinderC2328f.c
            public void onGetStatsCompleted(PackageStats packageStats, boolean z7) {
                AppSizeTaskLegacy appSizeTaskLegacy = AppSizeTaskLegacy.this;
                if (z7) {
                    appSizeTaskLegacy.q2(new Double[]{Double.valueOf(packageStats.cacheSize + packageStats.externalCacheSize), Double.valueOf(packageStats.dataSize + packageStats.externalDataSize), Double.valueOf(packageStats.codeSize + packageStats.externalCodeSize)}, false);
                } else {
                    appSizeTaskLegacy.q2(new Double[3], false);
                }
            }
        };

        /* renamed from: y1, reason: collision with root package name */
        public final String f16251y1;

        public AppSizeTaskLegacy(String str) {
            this.f16251y1 = str;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            n2(1);
            PackageManager packageManager = this.f15400Y.getPackageManager();
            Class<?> cls = packageManager.getClass();
            AbstractBinderC2328f abstractBinderC2328f = this.f16250L1;
            cls.getMethod("getPackageSizeInfo", String.class, abstractBinderC2328f.f22398Z).invoke(packageManager, this.f16251y1, abstractBinderC2328f.f22399x0);
        }
    }

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final String f16253x1;

        public a(String str) {
            this.f16253x1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            if (data != null) {
                String str = this.f16253x1;
                if (str == null || str.equals(data.getSchemeSpecificPart())) {
                    b(intent);
                }
            }
        }
    }

    public static final class b extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16254L1;

        /* renamed from: M1, reason: collision with root package name */
        public final UUID f16255M1;

        public b(String str, UUID uuid) {
            this.f16254L1 = str;
            this.f16255M1 = uuid;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, java.lang.Runnable
        public final void run() {
            UserHandle myUserHandle;
            StorageStats queryStatsForPackage;
            long cacheBytes;
            long dataBytes;
            long appBytes;
            UUID uuid;
            UUID uuid2;
            UserHandle myUserHandle2;
            StorageStats queryStatsForPackage2;
            long cacheBytes2;
            long dataBytes2;
            long appBytes2;
            String str = this.f16254L1;
            UUID uuid3 = this.f16255M1;
            try {
                StorageStatsManager g8 = B.a0.g(this.f15400Y.getSystemService("storagestats"));
                myUserHandle = Process.myUserHandle();
                queryStatsForPackage = g8.queryStatsForPackage(uuid3, str, myUserHandle);
                if (queryStatsForPackage != null) {
                    cacheBytes = queryStatsForPackage.getCacheBytes();
                    dataBytes = queryStatsForPackage.getDataBytes();
                    appBytes = queryStatsForPackage.getAppBytes();
                    uuid = StorageManager.UUID_DEFAULT;
                    if (!uuid.equals(uuid3)) {
                        uuid2 = StorageManager.UUID_DEFAULT;
                        myUserHandle2 = Process.myUserHandle();
                        queryStatsForPackage2 = g8.queryStatsForPackage(uuid2, str, myUserHandle2);
                        if (queryStatsForPackage2 != null) {
                            cacheBytes2 = queryStatsForPackage2.getCacheBytes();
                            cacheBytes += cacheBytes2;
                            dataBytes2 = queryStatsForPackage2.getDataBytes();
                            dataBytes += dataBytes2;
                            appBytes2 = queryStatsForPackage2.getAppBytes();
                            appBytes += appBytes2;
                        }
                    }
                    q2(new Double[]{Double.valueOf(cacheBytes), Double.valueOf(dataBytes), Double.valueOf(appBytes)}, false);
                    return;
                }
            } catch (SecurityException e8) {
                r2(e8);
                return;
            } catch (Throwable th) {
                Log.w("AppInstalled", "queryStatsForPackage failed", th);
            }
            q2(new Double[3], false);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:2|3)|(5:5|6|(1:8)(1:68)|9|10)|(8:15|16|17|(7:21|22|23|(2:25|(1:30))|32|33|(2:35|36)(3:38|(1:53)(1:44)|(2:46|47)(3:48|(1:50)(1:52)|51)))|56|57|33|(0)(0))|59|61|62|16|17|(8:19|21|22|23|(0)|32|33|(0)(0))|56|57|33|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
    
        r8 = r4.splitSourceDirs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0074, code lost:
    
        r11 = null;
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049 A[Catch: NameNotFoundException -> 0x006a, TryCatch #0 {NameNotFoundException -> 0x006a, blocks: (B:23:0x0043, B:25:0x0049, B:27:0x004f, B:30:0x0057), top: B:22:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean B(C1708z0 c1708z0, String str) {
        ApplicationInfo applicationInfo;
        String str2;
        Double d8;
        String str3;
        J3.a aVar;
        String str4;
        UUID uuid;
        PackageManager packageManager;
        Double valueOf;
        String str5;
        String str6;
        String[] strArr;
        String[] strArr2;
        int length;
        try {
            packageManager = c1708z0.getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        try {
            str2 = this.varDisplayName != null ? applicationInfo.loadLabel(packageManager).toString() : null;
            try {
            } catch (PackageManager.NameNotFoundException unused2) {
                d8 = null;
                str3 = null;
                aVar = null;
                str4 = str2;
                C(c1708z0, str, str4, d8, str3, aVar);
                if (applicationInfo != null) {
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            str2 = null;
            d8 = null;
            str3 = null;
            aVar = null;
            str4 = str2;
            C(c1708z0, str, str4, d8, str3, aVar);
            if (applicationInfo != null) {
            }
        }
        if (this.varVersionName == null && this.varVersionCode == null) {
            str5 = null;
            valueOf = null;
            if (this.varSourceDirs != null && (str6 = applicationInfo.sourceDir) != null) {
                J3.a aVar2 = new J3.a(1, new Object[]{str6});
                try {
                    if (21 <= Build.VERSION.SDK_INT) {
                        strArr = applicationInfo.splitSourceDirs;
                        if (strArr != null && (length = strArr2.length) > 0) {
                            aVar2.j(aVar2.f4627Y + length);
                            System.arraycopy(strArr2, 0, aVar2.f4626X, aVar2.f4627Y, length);
                            aVar2.f4627Y += length;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused4) {
                }
                str3 = str5;
                str4 = str2;
                d8 = valueOf;
                aVar = aVar2;
                C(c1708z0, str, str4, d8, str3, aVar);
                if (applicationInfo != null) {
                    D(c1708z0, null, null, null);
                    o(c1708z0, false);
                    return true;
                }
                if (!((this.varCacheSize == null && this.varDataSize == null && this.varCodeSize == null) ? false : true)) {
                    o(c1708z0, true);
                    return true;
                }
                if (26 <= Build.VERSION.SDK_INT) {
                    uuid = applicationInfo.storageUuid;
                    b bVar = new b(str, uuid);
                    c1708z0.w(bVar);
                    bVar.w2();
                } else {
                    c1708z0.w(new AppSizeTaskLegacy(str));
                }
                return false;
            }
            aVar = null;
            str3 = str5;
            str4 = str2;
            d8 = valueOf;
            C(c1708z0, str, str4, d8, str3, aVar);
            if (applicationInfo != null) {
            }
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
        valueOf = Double.valueOf(packageInfo.versionCode);
        str5 = packageInfo.versionName;
        if (this.varSourceDirs != null) {
            J3.a aVar22 = new J3.a(1, new Object[]{str6});
            if (21 <= Build.VERSION.SDK_INT) {
            }
            str3 = str5;
            str4 = str2;
            d8 = valueOf;
            aVar = aVar22;
            C(c1708z0, str, str4, d8, str3, aVar);
            if (applicationInfo != null) {
            }
        }
        aVar = null;
        str3 = str5;
        str4 = str2;
        d8 = valueOf;
        C(c1708z0, str, str4, d8, str3, aVar);
        if (applicationInfo != null) {
        }
    }

    public final void C(C1708z0 c1708z0, String str, String str2, Double d8, String str3, J3.a aVar) {
        J3.l lVar = this.varPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varDisplayName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varVersionCode;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        J3.l lVar4 = this.varVersionName;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, str3);
        }
        J3.l lVar5 = this.varSourceDirs;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, aVar);
        }
    }

    public final void D(C1708z0 c1708z0, Double d8, Double d9, Double d10) {
        J3.l lVar = this.varCacheSize;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varDataSize;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varCodeSize;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return this.varCacheSize != null || this.varDataSize != null || this.varCodeSize != null ? 26 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15559t} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.GET_PACKAGE_SIZE")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_app_installed_immediate, C2541R.string.caption_app_installed_change);
        return c1596k0.o(0, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            return B(c1708z0, schemeSpecificPart);
        }
        C(c1708z0, schemeSpecificPart, null, null, null, null);
        D(c1708z0, null, null, null);
        o(c1708z0, false);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.varPackageName);
        if (19 <= dVar.f6413Z) {
            dVar.g(this.varDisplayName);
        }
        if (48 <= dVar.f6413Z) {
            dVar.g(this.varVersionCode);
            dVar.g(this.varVersionName);
        }
        if (64 <= dVar.f6413Z) {
            dVar.g(this.varCacheSize);
            dVar.g(this.varDataSize);
            dVar.g(this.varCodeSize);
        }
        if (96 <= dVar.f6413Z) {
            dVar.g(this.varSourceDirs);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.varPackageName);
        visitor.b(this.varDisplayName);
        visitor.b(this.varVersionCode);
        visitor.b(this.varVersionName);
        visitor.b(this.varCacheSize);
        visitor.b(this.varDataSize);
        visitor.b(this.varCodeSize);
        visitor.b(this.varSourceDirs);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.varPackageName = (J3.l) cVar.readObject();
        if (19 <= cVar.f6409x0) {
            this.varDisplayName = (J3.l) cVar.readObject();
        }
        if (48 <= cVar.f6409x0) {
            this.varVersionCode = (J3.l) cVar.readObject();
            this.varVersionName = (J3.l) cVar.readObject();
        }
        if (64 <= cVar.f6409x0) {
            this.varCacheSize = (J3.l) cVar.readObject();
            this.varDataSize = (J3.l) cVar.readObject();
            this.varCodeSize = (J3.l) cVar.readObject();
        }
        if (96 <= cVar.f6409x0) {
            this.varSourceDirs = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_installed_title);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (J1(1) == 0) {
            if (x7 != null) {
                return B(c1708z0, x7);
            }
            throw new RequiredArgumentNullException("packageName");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        intentFilter.addDataScheme("package");
        a aVar = new a(x7);
        c1708z0.w(aVar);
        aVar.q(intentFilter);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Double[] dArr = (Double[]) obj;
        D(c1708z0, dArr[0], dArr[1], dArr[2]);
        o(c1708z0, true);
        return true;
    }
}
