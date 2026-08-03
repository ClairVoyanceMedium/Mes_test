package com.llamalab.automate.stmt;

import android.media.AudioDeviceInfo;
import android.os.Build;
import x3.C2440r;

/* renamed from: com.llamalab.automate.stmt.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1650j {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
    
        r2 = r2.getProductName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
    
        if (r3 != r1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(AudioDeviceInfo audioDeviceInfo, int i8, String str) {
        CharSequence productName;
        int type;
        if (i8 >= 0) {
            if (audioDeviceInfo != null) {
                type = audioDeviceInfo.getType();
            }
            return false;
        }
        if (str != null) {
            return (audioDeviceInfo == null || productName == null || !C2440r.v(str, productName)) ? false : true;
        }
        return true;
    }

    public static boolean b(AudioDeviceInfo audioDeviceInfo, int i8, String str, String str2) {
        String address;
        if (!a(audioDeviceInfo, i8, str)) {
            return false;
        }
        if (28 > Build.VERSION.SDK_INT) {
            return str2 == null;
        }
        if (str2 == null) {
            return true;
        }
        address = audioDeviceInfo.getAddress();
        return str2.equals(address);
    }
}
