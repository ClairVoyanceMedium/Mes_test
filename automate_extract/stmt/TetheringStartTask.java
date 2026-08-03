package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.llamalab.automate.AutomateService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import x3.C2429g;

/* loaded from: classes.dex */
public final class TetheringStartTask extends com.llamalab.automate.W {

    /* renamed from: L1, reason: collision with root package name */
    public final boolean f17191L1 = false;

    /* renamed from: M1, reason: collision with root package name */
    public final String f17192M1;

    /* renamed from: y1, reason: collision with root package name */
    public final int f17193y1;

    public final class Callback implements InvocationHandler {
        public Callback() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            return Callback.class.getMethod(method.getName(), method.getParameterTypes()).invoke(this, objArr);
        }

        public void onTetheringFailed(int i8) {
            TetheringStartTask.this.r2(new IllegalStateException(C2429g.i(i8)).fillInStackTrace());
        }

        public void onTetheringStarted() {
            TetheringStartTask.this.p2(null);
        }
    }

    public final class a extends ResultReceiver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i8, Bundle bundle) {
            TetheringStartTask tetheringStartTask = TetheringStartTask.this;
            if (i8 == 0) {
                tetheringStartTask.p2(null);
            } else {
                tetheringStartTask.r2(new IllegalStateException(C2429g.i(i8)).fillInStackTrace());
            }
        }
    }

    public TetheringStartTask(int i8, String str) {
        this.f17193y1 = i8;
        this.f17192M1 = str;
    }

    public static void v2(int i8, Context context, String str) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            int i9 = Build.VERSION.SDK_INT;
            if (30 <= i9) {
                Object systemService = context.getSystemService("tethering");
                systemService.getClass().getMethod("stopTethering", Integer.TYPE).invoke(systemService, Integer.valueOf(i8));
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                Field declaredField = ConnectivityManager.class.getDeclaredField("mService");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(connectivityManager);
                if (27 <= i9) {
                    obj.getClass().getMethod("stopTethering", Integer.TYPE, String.class).invoke(obj, Integer.valueOf(i8), str);
                } else {
                    obj.getClass().getMethod("stopTethering", Integer.TYPE).invoke(obj, Integer.valueOf(i8));
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            int i8 = Build.VERSION.SDK_INT;
            boolean z7 = this.f17191L1;
            int i9 = this.f17193y1;
            if (30 <= i8) {
                Class<?> cls = Class.forName("android.net.TetheringManager$TetheringRequest");
                Class<?> cls2 = Class.forName("android.net.TetheringManager$TetheringRequest$Builder");
                Class<?> cls3 = Class.forName("android.net.TetheringManager$StartTetheringCallback");
                Object newInstance = cls2.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i9));
                cls2.getMethod("setShouldShowEntitlementUi", Boolean.TYPE).invoke(newInstance, Boolean.valueOf(z7));
                Object invoke = cls2.getMethod("build", new Class[0]).invoke(newInstance, new Object[0]);
                Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new Callback());
                Object systemService = automateService.getSystemService("tethering");
                systemService.getClass().getMethod("startTethering", cls, Executor.class, cls3).invoke(systemService, invoke, automateService.getMainExecutor(), newProxyInstance);
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) automateService.getSystemService("connectivity");
                Field declaredField = ConnectivityManager.class.getDeclaredField("mService");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(connectivityManager);
                a aVar = new a(automateService.f14581L1);
                if (27 <= i8) {
                    obj.getClass().getMethod("startTethering", Integer.TYPE, ResultReceiver.class, Boolean.TYPE, String.class).invoke(obj, Integer.valueOf(i9), aVar, Boolean.valueOf(z7), this.f17192M1);
                } else {
                    obj.getClass().getMethod("startTethering", Integer.TYPE, ResultReceiver.class, Boolean.TYPE).invoke(obj, Integer.valueOf(i9), aVar, Boolean.valueOf(z7));
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
