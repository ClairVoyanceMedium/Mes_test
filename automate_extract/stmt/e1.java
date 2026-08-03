package com.llamalab.automate.stmt;

import android.content.AttributionSource;
import android.content.ContentResolver;
import android.content.Context;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f17389a = Uri.parse("content://settings");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f17390b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f17391c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f17392d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f17393e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f17394f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f17395g;

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f17396h;

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f17397i;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f17398j;

    static {
        String[] strArr = {"end_button_behavior", "wifi_static_ip", "wifi_use_static_ip", "wifi_static_gateway", "wifi_static_netmask", "wifi_static_dns1", "wifi_static_dns2", "bluetooth_discoverability", "bluetooth_discoverability_timeout", "next_alarm_formatted", "font_scale", "system_locales", "dim_screen", "screen_off_timeout", "screen_brightness", "screen_brightness_mode", "mode_ringer_streams_affected", "mute_streams_affected", "vibrate_on", "volume_ring", "volume_system", "volume_voice", "volume_music", "volume_alarm", "volume_notification", "volume_bluetooth_sco", "volume_assistant", "ringtone", "notification_sound", "alarm_alert", "auto_replace", "auto_caps", "auto_punctuate", "show_password", "SHOW_GTALK_SERVICE_STATUS", "wallpaper_activity", "time_12_24", "date_format", "setup_wizard_has_run", "accelerometer_rotation", "user_rotation", "dtmf_tone", "sound_effects_enabled", "haptic_feedback_enabled", "show_web_suggestions", "vibrate_when_ringing", "apply_ramping_ringer"};
        f17390b = strArr;
        int i8 = Build.VERSION.SDK_INT;
        if (35 <= i8) {
            Arrays.sort(strArr);
        }
        String[] strArr2 = {"end_button_behavior", "wifi_static_ip", "wifi_use_static_ip", "wifi_static_gateway", "wifi_static_netmask", "wifi_static_dns1", "wifi_static_dns2", "bluetooth_discoverability", "bluetooth_discoverability_timeout", "next_alarm_formatted", "font_scale", "system_locales", "dim_screen", "screen_off_timeout", "screen_brightness", "screen_brightness_float", "screen_brightness_mode", "mode_ringer_streams_affected", "mute_streams_affected", "vibrate_on", "volume_ring", "volume_system", "volume_voice", "volume_music", "volume_alarm", "volume_notification", "volume_bluetooth_sco", "volume_assistant", "ringtone", "notification_sound", "alarm_alert", "auto_replace", "auto_caps", "auto_punctuate", "show_password", "SHOW_GTALK_SERVICE_STATUS", "wallpaper_activity", "time_12_24", "date_format", "setup_wizard_has_run", "accelerometer_rotation", "user_rotation", "dtmf_tone", "sound_effects_enabled", "haptic_feedback_enabled", "show_web_suggestions", "vibrate_when_ringing", "apply_ramping_ringer"};
        f17391c = strArr2;
        if (34 == i8) {
            Arrays.sort(strArr2);
        }
        String[] strArr3 = {"end_button_behavior", "wifi_static_ip", "wifi_use_static_ip", "wifi_static_gateway", "wifi_static_netmask", "wifi_static_dns1", "wifi_static_dns2", "bluetooth_discoverability", "bluetooth_discoverability_timeout", "next_alarm_formatted", "font_scale", "system_locales", "dim_screen", "screen_off_timeout", "screen_brightness", "screen_brightness_float", "screen_brightness_for_vr", "screen_brightness_for_vr_float", "screen_brightness_mode", "mode_ringer_streams_affected", "mute_streams_affected", "vibrate_on", "volume_ring", "volume_system", "volume_voice", "volume_music", "volume_alarm", "volume_notification", "volume_bluetooth_sco", "volume_assistant", "ringtone", "notification_sound", "alarm_alert", "auto_replace", "auto_caps", "auto_punctuate", "show_password", "SHOW_GTALK_SERVICE_STATUS", "wallpaper_activity", "time_12_24", "date_format", "setup_wizard_has_run", "accelerometer_rotation", "user_rotation", "dtmf_tone", "sound_effects_enabled", "haptic_feedback_enabled", "show_web_suggestions", "vibrate_when_ringing", "apply_ramping_ringer"};
        f17392d = strArr3;
        if (33 == i8) {
            Arrays.sort(strArr3);
        }
        String[] strArr4 = {"end_button_behavior", "wifi_use_static_ip", "wifi_static_gateway", "wifi_static_netmask", "wifi_static_dns1", "wifi_static_dns2", "bluetooth_discoverability", "bluetooth_discoverability_timeout", "next_alarm_formatted", "font_scale", "system_locales", "dim_screen", "screen_off_timeout", "screen_brightness", "screen_brightness_float", "screen_brightness_for_vr", "screen_brightness_for_vr_float", "screen_brightness_mode", "mode_ringer_streams_affected", "mute_streams_affected", "vibrate_on", "volume_ring", "volume_system", "volume_voice", "volume_music", "volume_alarm", "volume_notification", "volume_bluetooth_sco", "volume_assistant", "ringtone", "notification_sound", "alarm_alert", "auto_replace", "auto_caps", "auto_punctuate", "show_password", "SHOW_GTALK_SERVICE_STATUS", "wallpaper_activity", "time_12_24", "date_format", "setup_wizard_has_run", "accelerometer_rotation", "user_rotation", "dtmf_tone", "sound_effects_enabled", "haptic_feedback_enabled", "show_web_suggestions", "vibrate_when_ringing"};
        f17393e = strArr4;
        if (31 == i8) {
            Arrays.sort(strArr4);
        }
        String[] strArr5 = {"bluetooth_name", "bluetooth_address", "bluetooth_addr_valid", "enabled_input_methods", "disabled_system_input_methods", "always_on_vpn_lockdown_whitelist", "sysui_qs_tiles"};
        f17394f = strArr5;
        if (34 <= i8) {
            Arrays.sort(strArr5);
        }
        f17395g = new String[]{"media_button_receiver"};
        String[] strArr6 = {"bluetooth_name", "bluetooth_address", "bluetooth_addr_valid", "always_on_vpn_lockdown_whitelist"};
        f17396h = strArr6;
        if (33 == i8) {
            Arrays.sort(strArr6);
        }
        f17397i = new String[]{"data_roaming"};
        String[] strArr7 = {"bluetooth_name", "bluetooth_address", "bluetooth_addr_valid"};
        f17398j = strArr7;
        if (31 == i8) {
            Arrays.sort(strArr7);
        }
    }

    public static void a(ContentResolver contentResolver, AttributionSource attributionSource, String str, Bundle bundle) {
        try {
            Class<?> cls = Class.forName("android.content.IContentProvider");
            Method method = ContentResolver.class.getMethod("acquireProvider", String.class);
            Method method2 = ContentResolver.class.getMethod("releaseProvider", cls);
            IInterface iInterface = (IInterface) method.invoke(contentResolver, "settings");
            if (iInterface == null) {
                throw new IllegalStateException("Failed to acquire provider");
            }
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.IContentProvider");
                    attributionSource.writeToParcel(obtain, 0);
                    obtain.writeString("settings");
                    obtain.writeString("PUT_system");
                    obtain.writeString(str);
                    obtain.writeBundle(bundle);
                    iInterface.asBinder().transact(21, obtain, obtain2, 0);
                    DatabaseUtils.readExceptionFromParcel(obtain2);
                    obtain2.readBundle();
                    method2.invoke(contentResolver, iInterface);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            } catch (Throwable th) {
                method2.invoke(contentResolver, iInterface);
                throw th;
            }
        } catch (ClassNotFoundException e8) {
            throw new UnsupportedOperationException(e8);
        } catch (IllegalAccessException e9) {
            throw new UnsupportedOperationException(e9);
        } catch (NoSuchMethodException e10) {
            throw new UnsupportedOperationException(e10);
        } catch (InvocationTargetException e11) {
            throw ((RuntimeException) e11.getTargetException());
        }
    }

    public static Bundle b(int i8, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("value", str);
        bundle.putInt("_user", i8);
        return bundle;
    }

    public static boolean c(Context context) {
        int checkOpNoThrow;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext.getPackageManager().checkSignatures(applicationContext.getPackageName(), "com.llamalab.automate.ext.settings") != 0) {
            return false;
        }
        if (23 > Build.VERSION.SDK_INT) {
            return applicationContext.getPackageManager().checkPermission("android.permission.WRITE_SETTINGS", "com.llamalab.automate.ext.settings") == 0;
        }
        checkOpNoThrow = B.A.c(applicationContext.getSystemService("appops")).checkOpNoThrow("android:write_settings", Process.myUid(), "com.llamalab.automate.ext.settings");
        if (checkOpNoThrow != 0) {
            return checkOpNoThrow == 3 && applicationContext.getPackageManager().checkPermission("android.permission.WRITE_SETTINGS", "com.llamalab.automate.ext.settings") == 0;
        }
        return true;
    }

    public static boolean d(String str) {
        int i8 = Build.VERSION.SDK_INT;
        if (35 <= i8) {
            return Arrays.binarySearch(f17390b, str) >= 0;
        }
        if (34 <= i8) {
            return Arrays.binarySearch(f17391c, str) >= 0;
        }
        if (33 <= i8) {
            return Arrays.binarySearch(f17392d, str) >= 0;
        }
        if (31 <= i8) {
            return Arrays.binarySearch(f17393e, str) >= 0;
        }
        try {
            return ((Set) Settings.System.class.getField("PUBLIC_SETTINGS").get(null)).contains(str);
        } catch (IllegalAccessException | NoSuchFieldException e8) {
            Log.e("SystemSettingUtils", "Failed to access Settings.System.PUBLIC_SETTINGS", e8);
            return true;
        }
    }

    public static void e(Context context, String str, String str2) {
        ContentResolver contentResolver;
        int i8 = Build.VERSION.SDK_INT;
        if (33 <= i8) {
            contentResolver = context.getContentResolver();
        } else {
            if (31 <= i8) {
                try {
                    a(context.getContentResolver(), new AttributionSource.Builder(Process.myUid()).setPackageName("com.llamalab.automate.ext.settings").build(), str, b(t3.o.b(), str2));
                    return;
                } catch (RemoteException e8) {
                    throw new RuntimeException(e8);
                }
            }
            contentResolver = context.createPackageContext("com.llamalab.automate.ext.settings", 0).getContentResolver();
            try {
                Field declaredField = ContentResolver.class.getDeclaredField("mPackageName");
                declaredField.setAccessible(true);
                declaredField.set(contentResolver, "com.llamalab.automate.ext.settings");
                if (29 > i8) {
                    contentResolver.call(f17389a, "PUT_system", str, b(t3.o.b(), str2));
                    return;
                }
            } catch (RuntimeException e9) {
                throw e9;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        contentResolver.call("settings", "PUT_system", str, b(t3.o.b(), str2));
    }
}
