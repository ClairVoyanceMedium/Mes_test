package com.llamalab.automate;

import B.AbstractServiceC0291s;
import android.R;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import g4.C1827a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import x3.C2424b;
import x3.C2434l;

/* loaded from: classes.dex */
public final class AutomateAppWidgetService extends AbstractServiceC0291s {

    /* renamed from: L1, reason: collision with root package name */
    public AppWidgetManager f14515L1;

    public static final class Receiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            AutomateAppWidgetService.e(context, intent);
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f14516a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f14517b;

        public a(Uri uri, Uri uri2) {
            this.f14516a = uri;
            this.f14517b = uri2;
        }

        public static a a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                short readShort = dataInputStream.readShort();
                if (readShort == 1) {
                    a aVar = new a(b(dataInputStream), C1827a.h.a(dataInputStream.readChar()).build());
                    dataInputStream.close();
                    return aVar;
                }
                if (readShort != 2) {
                    throw new IOException("Bad widget file version");
                }
                a aVar2 = new a(b(dataInputStream), b(dataInputStream));
                dataInputStream.close();
                return aVar2;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        }

        public static Uri b(DataInputStream dataInputStream) {
            String readUTF = dataInputStream.readUTF();
            if (TextUtils.isEmpty(readUTF)) {
                return null;
            }
            return Uri.parse(readUTF);
        }

        public final void c(File file) {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            try {
                dataOutputStream.writeShort(2);
                dataOutputStream.writeUTF(O.b.d("", this.f14516a));
                dataOutputStream.writeUTF(O.b.d("", this.f14517b));
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        }
    }

    public static void e(Context context, Intent intent) {
        ComponentName componentName = new ComponentName(context, (Class<?>) AutomateAppWidgetService.class);
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (AbstractServiceC0291s.f268x1) {
            AbstractServiceC0291s.g b8 = AbstractServiceC0291s.b(context, componentName, true, C2541R.id.job_id_app_widget);
            b8.b(C2541R.id.job_id_app_widget);
            b8.a(intent);
        }
    }

    public static int[] f(Intent intent) {
        int[] intArrayExtra = intent.getIntArrayExtra("appWidgetIds");
        if (intArrayExtra != null) {
            return intArrayExtra;
        }
        int intExtra = intent.getIntExtra("appWidgetId", 0);
        return intExtra != 0 ? new int[]{intExtra} : C2434l.f23393d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // B.AbstractServiceC0291s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Intent intent) {
        char c8;
        Bundle bundleExtra;
        Bundle appWidgetOptions;
        Bundle appWidgetOptions2;
        Uri uri;
        Uri uri2;
        Bundle appWidgetOptions3;
        String action = intent.getAction();
        if (action != null) {
            int i8 = 0;
            switch (action.hashCode()) {
                case -689938766:
                    if (action.equals("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS")) {
                        c8 = 0;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 299056860:
                    if (action.equals("android.appwidget.action.APPWIDGET_CONFIGURE")) {
                        c8 = 1;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 452171151:
                    if (action.equals("android.appwidget.action.APPWIDGET_DELETED")) {
                        c8 = 2;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 583631782:
                    if (action.equals("android.appwidget.action.APPWIDGET_DISABLED")) {
                        c8 = 3;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 1619576947:
                    if (action.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
                        c8 = 4;
                        break;
                    }
                    c8 = 65535;
                    break;
                default:
                    c8 = 65535;
                    break;
            }
            if (c8 == 0) {
                if (16 > Build.VERSION.SDK_INT || (bundleExtra = intent.getBundleExtra("appWidgetOptions")) == null) {
                    return;
                }
                int[] f8 = f(intent);
                int length = f8.length;
                while (i8 < length) {
                    int i9 = f8[i8];
                    File g8 = g(i9);
                    try {
                        a a8 = a.a(g8);
                        h(i9, a8.f14516a, a8.f14517b, bundleExtra);
                    } catch (FileNotFoundException unused) {
                        Log.w("AutomateAppWidgetService", "Widget not found: 0x" + Integer.toHexString(i9));
                    } catch (IOException e8) {
                        Log.w("AutomateAppWidgetService", "Failed to read file: " + g8, e8);
                    }
                    i8++;
                }
                return;
            }
            if (c8 == 1) {
                Uri data = intent.getData();
                Uri uri3 = (Uri) intent.getParcelableExtra("com.llamalab.automate.intent.extra.ICON_URI");
                int[] f9 = f(intent);
                int length2 = f9.length;
                while (i8 < length2) {
                    int i10 = f9[i8];
                    if (data != null) {
                        File g9 = g(i10);
                        try {
                            new a(data, uri3).c(g9);
                        } catch (IOException e9) {
                            Log.w("AutomateAppWidgetService", "Failed to write file: " + g9, e9);
                        }
                    }
                    if (16 <= Build.VERSION.SDK_INT) {
                        try {
                            appWidgetOptions = this.f14515L1.getAppWidgetOptions(i10);
                        } catch (IllegalArgumentException unused2) {
                        }
                        h(i10, data, uri3, appWidgetOptions);
                        i8++;
                    }
                    appWidgetOptions = null;
                    h(i10, data, uri3, appWidgetOptions);
                    i8++;
                }
                return;
            }
            if (c8 == 2) {
                int[] f10 = f(intent);
                int length3 = f10.length;
                while (i8 < length3) {
                    g(f10[i8]).delete();
                    i8++;
                }
                return;
            }
            if (c8 == 3) {
                File[] listFiles = getDir("widgets", 0).listFiles();
                if (listFiles != null) {
                    int length4 = listFiles.length;
                    while (i8 < length4) {
                        listFiles[i8].delete();
                        i8++;
                    }
                    return;
                }
                return;
            }
            if (c8 != 4) {
                return;
            }
            Uri data2 = intent.getData();
            Uri uri4 = (Uri) intent.getParcelableExtra("com.llamalab.automate.intent.extra.ICON_URI");
            int[] f11 = f(intent);
            int length5 = f11.length;
            while (i8 < length5) {
                int i11 = f11[i8];
                File g10 = g(i11);
                try {
                    a a9 = a.a(g10);
                    uri = a9.f14516a;
                    uri2 = a9.f14517b;
                } catch (FileNotFoundException unused3) {
                    Log.w("AutomateAppWidgetService", "Widget not found: 0x" + Integer.toHexString(i11));
                    if (16 <= Build.VERSION.SDK_INT) {
                        try {
                            appWidgetOptions2 = this.f14515L1.getAppWidgetOptions(i11);
                        } catch (IllegalArgumentException unused4) {
                            appWidgetOptions2 = null;
                            h(i11, data2, uri4, appWidgetOptions2);
                            i8++;
                        }
                        h(i11, data2, uri4, appWidgetOptions2);
                        i8++;
                    }
                    appWidgetOptions2 = null;
                    h(i11, data2, uri4, appWidgetOptions2);
                    i8++;
                } catch (IOException e10) {
                    Log.w("AutomateAppWidgetService", "Failed to read file: " + g10, e10);
                    if (16 <= Build.VERSION.SDK_INT) {
                    }
                    appWidgetOptions2 = null;
                    h(i11, data2, uri4, appWidgetOptions2);
                    i8++;
                }
                if (16 <= Build.VERSION.SDK_INT) {
                    try {
                        appWidgetOptions3 = this.f14515L1.getAppWidgetOptions(i11);
                    } catch (IllegalArgumentException unused5) {
                    }
                    h(i11, uri, uri2, appWidgetOptions3);
                    i8++;
                }
                appWidgetOptions3 = null;
                h(i11, uri, uri2, appWidgetOptions3);
                i8++;
            }
        }
    }

    public final File g(int i8) {
        return new File(getDir("widgets", 0), Integer.toHexString(i8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0097 -> B:12:0x00a8). Please report as a decompilation issue!!! */
    public final void h(int i8, Uri uri, Uri uri2, Bundle bundle) {
        Resources resources = getResources();
        String packageName = getPackageName();
        RemoteViews remoteViews = new RemoteViews(packageName, C2541R.layout.appwidget_icon);
        if (uri != null) {
            remoteViews.setOnClickPendingIntent(R.id.icon, C2424b.g(0, 134217728 | C2424b.f23370a, this, new Intent("com.llamalab.automate.intent.action.START_FLOW").setDataAndType(uri, "vnd.android.cursor.item/vnd.com.llamalab.automate.provider.flow_statement").setPackage(packageName)));
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(C2541R.dimen.appwidget_icon_size);
        if (bundle != null) {
            int i9 = bundle.getInt("appWidgetMaxWidth", bundle.getInt("appWidgetMinWidth", -1));
            int i10 = bundle.getInt("appWidgetMaxHeight", bundle.getInt("appWidgetMinHeight", -1));
            if (i9 > 0 && i10 > 0) {
                dimensionPixelSize = (int) ((Math.min(i9, i10) * resources.getDisplayMetrics().density) + 0.5f);
            }
        }
        Uri uri3 = uri2;
        try {
            if (uri2 != null) {
                try {
                    if (23 <= Build.VERSION.SDK_INT) {
                        remoteViews.setImageViewIcon(R.id.icon, C1617p1.u(this).g(uri2, dimensionPixelSize));
                        uri2 = uri2;
                    } else {
                        C1617p1 u8 = C1617p1.u(this);
                        remoteViews.setImageViewBitmap(R.id.icon, u8.h(uri2, 0.8333333f, dimensionPixelSize, u8.i(C2541R.color.appwidget_icon)));
                        uri2 = uri2;
                    }
                } catch (Exception e8) {
                    String str = "Failed to load icon: " + uri2;
                    Log.w("AutomateAppWidgetService", str, e8);
                    uri3 = str;
                }
                this.f14515L1.updateAppWidget(i8, remoteViews);
                return;
            }
            this.f14515L1.updateAppWidget(i8, remoteViews);
            return;
        } catch (IllegalArgumentException e9) {
            Log.w("AutomateAppWidgetService", "Failed to update widget", e9);
            return;
        }
        remoteViews.setImageViewResource(R.id.icon, C2541R.drawable.ic_todo_white20_24dp);
        uri2 = uri3;
    }

    @Override // B.AbstractServiceC0291s, android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f14515L1 = AppWidgetManager.getInstance(this);
    }
}
