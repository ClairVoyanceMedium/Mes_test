package com.llamalab.automate.expr.func;

import C1.D1;
import F3.g;
import J3.h;
import R3.c;
import R3.d;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.C1708z0;
import java.io.File;

@g(0)
/* loaded from: classes.dex */
public class Storage extends BinaryFunction {
    public static final String NAME = "storage";

    @Override // L3.AbstractC1040e, R3.e
    public final void Y0(d dVar) {
        dVar.g(this.f4950X);
        if (38 <= dVar.f6413Z) {
            dVar.g(this.f4951Y);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        File externalStorageDirectory;
        String str;
        String x7 = h.x(c1708z0, this.f4950X, "primary");
        if ("primary".equalsIgnoreCase(x7) || "sdcard".equalsIgnoreCase(x7)) {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        } else if ("cache".equalsIgnoreCase(x7)) {
            externalStorageDirectory = c1708z0.getExternalCacheDir();
        } else if ("internal".equalsIgnoreCase(x7)) {
            externalStorageDirectory = new File(new File(c1708z0.getExternalFilesDir(null), "flows"), Long.toString(c1708z0.f17641Z.f14847y0));
        } else if ("external".equalsIgnoreCase(x7)) {
            externalStorageDirectory = c1708z0.getExternalFilesDir(null);
        } else {
            if ("alarms".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_ALARMS;
            } else if ("dcim".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_DCIM;
            } else if ("downloads".equalsIgnoreCase(x7) || "download".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_DOWNLOADS;
            } else if ("movies".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_MOVIES;
            } else if ("music".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_MUSIC;
            } else if ("notifications".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_NOTIFICATIONS;
            } else if ("pictures".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_PICTURES;
            } else if ("podcasts".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_PODCASTS;
            } else if ("ringtones".equalsIgnoreCase(x7)) {
                str = Environment.DIRECTORY_RINGTONES;
            } else if ("documents".equalsIgnoreCase(x7)) {
                if (19 <= Build.VERSION.SDK_INT) {
                    str = Environment.DIRECTORY_DOCUMENTS;
                } else {
                    externalStorageDirectory = new File(Environment.getExternalStorageDirectory(), "Documents");
                }
            } else if ("audiobooks".equalsIgnoreCase(x7)) {
                if (29 <= Build.VERSION.SDK_INT) {
                    str = Environment.DIRECTORY_AUDIOBOOKS;
                } else {
                    externalStorageDirectory = new File(Environment.getExternalStorageDirectory(), "Audiobooks");
                }
            } else if ("screenshots".equalsIgnoreCase(x7)) {
                if (29 <= Build.VERSION.SDK_INT) {
                    str = Environment.DIRECTORY_SCREENSHOTS;
                } else {
                    externalStorageDirectory = new File(Environment.getExternalStorageDirectory(), "Screenshots");
                }
            } else {
                if (!"recordings".equalsIgnoreCase(x7)) {
                    throw new IllegalArgumentException(D1.k("Illegal storage: ", x7));
                }
                if (31 <= Build.VERSION.SDK_INT) {
                    str = Environment.DIRECTORY_RECORDINGS;
                } else {
                    externalStorageDirectory = new File(Environment.getExternalStorageDirectory(), "Recordings");
                }
            }
            externalStorageDirectory = Environment.getExternalStoragePublicDirectory(str);
        }
        return h.k(c1708z0, this.f4951Y, externalStorageDirectory, externalStorageDirectory).getAbsolutePath();
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }

    @Override // L3.AbstractC1040e, R3.e
    public final void o0(c cVar) {
        b(cVar, 38);
    }
}
