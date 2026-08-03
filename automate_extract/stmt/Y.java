package com.llamalab.automate.stmt;

import C1.D1;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import com.llamalab.automate.AutomateAppWidgetProvider;
import com.llamalab.automate.AutomateWallpaperService;
import com.llamalab.automate.expr.func.Type;
import g4.C1827a;
import h4.C1881g;
import m3.C2145c;
import x3.C2440r;

/* loaded from: classes.dex */
public final class Y {
    public static boolean a(Intent intent, int i8) {
        int[] intArrayExtra = intent.getIntArrayExtra("appWidgetIds");
        return intArrayExtra != null ? C2440r.e(intArrayExtra, i8) : i8 == intent.getIntExtra("appWidgetId", 0);
    }

    public static Uri b(ContentProviderClient contentProviderClient, com.llamalab.automate.F0 f02, int i8, String str, ContentValues contentValues) {
        contentValues.put("flow_version", Integer.valueOf(f02.f14848y1));
        contentValues.put(Type.NAME, Integer.valueOf(i8));
        contentValues.put("native_id", str);
        return contentProviderClient.insert(C1827a.f.a(f02.f14847y0).build(), contentValues).buildUpon().appendEncodedPath(D1.e(i8)).build();
    }

    public static Uri c(ContentResolver contentResolver, com.llamalab.automate.F0 f02, int i8, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flow_version", Integer.valueOf(f02.f14848y1));
        contentValues.put(Type.NAME, Integer.valueOf(i8));
        contentValues.put("native_id", str);
        return contentResolver.insert(C1827a.f.a(f02.f14847y0).build(), contentValues).buildUpon().appendEncodedPath(D1.e(i8)).build();
    }

    public static Uri d(ContentProviderClient contentProviderClient, com.llamalab.automate.F0 f02, long j8, int i8, int i9) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("parent_id", Long.valueOf(j8));
        contentValues.put("position", Integer.valueOf(i8));
        return b(contentProviderClient, f02, 1, String.valueOf(i9), contentValues);
    }

    public static boolean e(Context context, AppWidgetProviderInfo appWidgetProviderInfo) {
        return appWidgetProviderInfo != null && context.getPackageName().equals(appWidgetProviderInfo.provider.getPackageName()) && AutomateAppWidgetProvider.class.getName().equals(appWidgetProviderInfo.provider.getClassName());
    }

    public static boolean f(Context context) {
        WallpaperManager wallpaperManager = (WallpaperManager) context.getSystemService("wallpaper");
        return 34 <= Build.VERSION.SDK_INT ? g(context, wallpaperManager.getWallpaperInfo(1)) || g(context, wallpaperManager.getWallpaperInfo(2)) : g(context, wallpaperManager.getWallpaperInfo());
    }

    public static boolean g(Context context, WallpaperInfo wallpaperInfo) {
        return wallpaperInfo != null && context.getPackageName().equals(wallpaperInfo.getPackageName()) && AutomateWallpaperService.class.getName().equals(wallpaperInfo.getServiceName());
    }

    public static void h(long j8, Uri uri) {
        if (C2145c.b(uri, 1) != j8) {
            throw new IllegalArgumentException("Interface URI for another flow");
        }
    }

    public static int i(C1881g c1881g, String str) {
        if (!str.startsWith("@")) {
            throw new IllegalArgumentException("View id not a resource reference");
        }
        int d8 = c1881g.d(str.substring(1), "id");
        if ("id".equals(c1881g.f(d8))) {
            return d8;
        }
        throw new Resources.NotFoundException("View id not found: ".concat(str));
    }

    public static boolean j(ContentProviderClient contentProviderClient, Uri uri, com.llamalab.automate.F0 f02, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", bArr);
        return contentProviderClient.update(uri, contentValues, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}) != 0;
    }

    public static void k(ContentProviderClient contentProviderClient, Uri uri, long j8, long j9, int i8, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", bArr);
        contentProviderClient.update(uri, contentValues, "native_id=? and parent_id=? and position=?", new String[]{String.valueOf(i8), String.valueOf(j8), String.valueOf(j9)});
    }
}
