package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import x3.C2425c;
import x3.C2434l;
import x3.C2446x;

@F3.f("speech_recognition.html")
@F3.a(C2541R.integer.ic_voice_search)
@F3.i(C2541R.string.stmt_speech_recognition_title)
@F3.h(C2541R.string.stmt_speech_recognition_summary)
@F3.e(C2541R.layout.stmt_speech_recognition_edit)
/* loaded from: classes.dex */
public final class SpeechRecognition extends Action implements ReceiverStatement, AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final String[] f17152L1 = {"android.speech.action.RECOGNIZE_SPEECH", "android.speech.action.VOICE_SEARCH_HANDS_FREE", "android.speech.action.WEB_SEARCH"};
    public InterfaceC1700x0 formatting;
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 model;
    public InterfaceC1700x0 offline;
    public InterfaceC1700x0 silenceDuration;
    public J3.l varConfidenceScores;
    public J3.l varSpokenTexts;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final Intent f17153x1;

        /* renamed from: y1, reason: collision with root package name */
        public final ComponentName f17154y1;

        public a(Intent intent, ComponentName componentName) {
            this.f17153x1 = intent;
            this.f17154y1 = componentName;
        }
    }

    public static final class b extends com.llamalab.automate.W implements RecognitionListener {

        /* renamed from: L1, reason: collision with root package name */
        public final ComponentName f17155L1;

        /* renamed from: M1, reason: collision with root package name */
        public SpeechRecognizer f17156M1;

        /* renamed from: N1, reason: collision with root package name */
        public ToneGenerator f17157N1;

        /* renamed from: O1, reason: collision with root package name */
        public boolean f17158O1;

        /* renamed from: P1, reason: collision with root package name */
        public final RunnableC0180b f17159P1 = new RunnableC0180b();

        /* renamed from: y1, reason: collision with root package name */
        public final Intent f17160y1;

        public class a implements Runnable {

            /* renamed from: X, reason: collision with root package name */
            public final /* synthetic */ SpeechRecognizer f17161X;

            public a(SpeechRecognizer speechRecognizer) {
                this.f17161X = speechRecognizer;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizer speechRecognizer = this.f17161X;
                try {
                    speechRecognizer.cancel();
                } catch (Throwable unused) {
                }
                try {
                    speechRecognizer.destroy();
                } catch (Throwable unused2) {
                }
            }
        }

        /* renamed from: com.llamalab.automate.stmt.SpeechRecognition$b$b, reason: collision with other inner class name */
        public class RunnableC0180b implements Runnable {
            public RunnableC0180b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                try {
                    if (bVar.f17156M1 == null) {
                        bVar.f17156M1 = SpeechRecognizer.createSpeechRecognizer(bVar.f15400Y.getApplicationContext(), bVar.f17155L1);
                        bVar.f17156M1.setRecognitionListener(bVar);
                    }
                    bVar.f17156M1.startListening(bVar.f17160y1);
                } catch (Throwable th) {
                    bVar.r2(th);
                }
            }
        }

        public b(Intent intent, ComponentName componentName) {
            this.f17160y1 = intent;
            this.f17155L1 = componentName;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            n2(1);
            automateService.f14581L1.post(this.f17159P1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this.f17159P1);
            SpeechRecognizer speechRecognizer = this.f17156M1;
            if (speechRecognizer != null) {
                this.f17156M1 = null;
                automateService.Z(new a(speechRecognizer));
            }
            ToneGenerator toneGenerator = this.f17157N1;
            if (toneGenerator != null) {
                try {
                    toneGenerator.release();
                } catch (Throwable unused) {
                }
            }
            u2();
        }

        @Override // android.speech.RecognitionListener
        public final void onBeginningOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public final void onBufferReceived(byte[] bArr) {
        }

        @Override // android.speech.RecognitionListener
        public final void onEndOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public final void onError(int i8) {
            RunnableC0180b runnableC0180b = this.f17159P1;
            try {
                switch (i8) {
                    case 1:
                        throw new SocketTimeoutException("Network timeout");
                    case 2:
                        throw new SocketException("Network error");
                    case 3:
                        v2();
                        throw new IllegalStateException("Audio error");
                    case 4:
                        throw new IllegalStateException("Server error");
                    case 5:
                        v2();
                        throw new IllegalStateException("Client error");
                    case 6:
                        break;
                    case 7:
                        if (!this.f17158O1) {
                            this.f15400Y.Z(runnableC0180b);
                            return;
                        }
                        break;
                    case 8:
                        this.f15400Y.f14581L1.postDelayed(runnableC0180b, 1000L);
                        return;
                    case 9:
                        v2();
                        throw new SecurityException("Missing android.permission.RECORD_AUDIO");
                    case 10:
                        throw new IllegalStateException("Too many requests");
                    case 11:
                        throw new IllegalStateException("Server disconnected");
                    case 12:
                        throw new IllegalStateException("Language not supported");
                    case 13:
                        throw new IllegalStateException("Language unavailable");
                    case 14:
                        throw new IllegalStateException("Cannot check support");
                    default:
                        throw new IllegalStateException("Unknown error: " + i8);
                }
                q2(null, false);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // android.speech.RecognitionListener
        public final void onEvent(int i8, Bundle bundle) {
        }

        @Override // android.speech.RecognitionListener
        public final void onPartialResults(Bundle bundle) {
        }

        @Override // android.speech.RecognitionListener
        public final void onReadyForSpeech(Bundle bundle) {
            if (this.f17158O1) {
                return;
            }
            this.f17158O1 = true;
            if (16 > Build.VERSION.SDK_INT) {
                try {
                    if (this.f17157N1 == null) {
                        this.f17157N1 = new ToneGenerator(5, 100);
                    }
                    this.f17157N1.startTone(27);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.speech.RecognitionListener
        public final void onResults(Bundle bundle) {
            q2(bundle, false);
        }

        @Override // android.speech.RecognitionListener
        public final void onRmsChanged(float f8) {
        }

        public final void v2() {
            ComponentName componentName = this.f17155L1;
            if (componentName == null || this.f15400Y.getPackageManager().checkPermission("android.permission.RECORD_AUDIO", componentName.getPackageName()) == 0) {
                return;
            }
            F5.n.g(this, "Package " + componentName.getPackageName() + " is missing android.permission.RECORD_AUDIO");
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO")};
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    @Override // com.llamalab.automate.ReceiverStatement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        int resultCode = abstractC1618p2.getResultCode();
        if (-1 != resultCode) {
            throw new IllegalStateException(B4.g.g("Failed to get voice details: ", resultCode));
        }
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        a aVar = (a) abstractC1618p2;
        Bundle resultExtras = abstractC1618p2.getResultExtras(true);
        ArrayList<String> stringArrayList = resultExtras.getStringArrayList("android.speech.extra.SUPPORTED_LANGUAGES");
        String string = resultExtras.getString("android.speech.extra.LANGUAGE_PREFERENCE");
        if (a8) {
            c1708z0.p("SpeechRecognition Supported languages: " + stringArrayList);
            c1708z0.p("SpeechRecognition Language preference: " + string);
        }
        Intent intent2 = aVar.f17153x1;
        String stringExtra = intent2.getStringExtra("android.speech.extra.LANGUAGE");
        if (stringExtra != null) {
            if (stringArrayList != null && !stringArrayList.contains(stringExtra)) {
                throw new IllegalArgumentException("Language not supported: ".concat(stringExtra));
            }
        } else if (string != null) {
            intent2.putExtra("android.speech.extra.LANGUAGE", string).putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", C2434l.f23396g);
            if (a8) {
                c1708z0.p("SpeechRecognition Using language: " + string);
            }
            c1708z0.w(new b(intent2, aVar.f17154y1));
            return false;
        }
        string = stringExtra;
        if (a8) {
        }
        c1708z0.w(new b(intent2, aVar.f17154y1));
        return false;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (78 <= dVar.f6413Z) {
            dVar.g(this.offline);
        }
        dVar.g(this.language);
        dVar.g(this.model);
        if (107 <= dVar.f6413Z) {
            dVar.g(this.formatting);
        }
        if (56 <= dVar.f6413Z) {
            dVar.g(this.silenceDuration);
        }
        dVar.g(this.varSpokenTexts);
        dVar.g(this.varConfidenceScores);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.offline);
        visitor.b(this.language);
        visitor.b(this.model);
        visitor.b(this.formatting);
        visitor.b(this.silenceDuration);
        visitor.b(this.varSpokenTexts);
        visitor.b(this.varConfidenceScores);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (78 <= cVar.f6409x0) {
            this.offline = (InterfaceC1700x0) cVar.readObject();
        }
        this.language = (InterfaceC1700x0) cVar.readObject();
        this.model = (InterfaceC1700x0) cVar.readObject();
        if (107 <= cVar.f6409x0) {
            this.formatting = (InterfaceC1700x0) cVar.readObject();
        }
        if (56 <= cVar.f6409x0) {
            this.silenceDuration = (InterfaceC1700x0) cVar.readObject();
        }
        this.varSpokenTexts = (J3.l) cVar.readObject();
        this.varConfidenceScores = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        ComponentName componentName;
        ResolveInfo resolveService;
        Bundle bundle;
        String string;
        c1708z0.q(C2541R.string.stmt_speech_recognition_title);
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        String str = null;
        String x7 = J3.h.x(c1708z0, this.language, null);
        String x8 = J3.h.x(c1708z0, this.model, "free_form");
        boolean f8 = J3.h.f(c1708z0, this.formatting, false);
        long t8 = J3.h.t(c1708z0, this.silenceDuration, 0L);
        boolean f9 = J3.h.f(c1708z0, this.offline, false);
        Intent putExtra = new Intent("android.speech.action.RECOGNIZE_SPEECH").putExtra("calling_package", c1708z0.getPackageName()).putExtra("android.speech.extra.MAX_RESULTS", 5).putExtra("android.speech.extra.LANGUAGE_MODEL", x8);
        if (x7 != null) {
            putExtra.putExtra("android.speech.extra.LANGUAGE", x7.replace('_', '-')).putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", C2434l.f23396g);
        }
        if (f8) {
            putExtra.putExtra("android.speech.extra.ENABLE_FORMATTING", "quality");
        }
        if (t8 > 0) {
            putExtra.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", t8);
        }
        if (f9) {
            putExtra.putExtra("android.speech.extra.PREFER_OFFLINE", f9);
        }
        Intent intent = new Intent("android.speech.action.GET_LANGUAGE_DETAILS");
        String[] strArr = f17152L1;
        int i8 = 0;
        loop0: while (true) {
            if (i8 >= 3) {
                break;
            }
            for (ResolveInfo resolveInfo : c1708z0.getPackageManager().queryIntentActivities(new Intent(strArr[i8]), 128)) {
                if (!c1708z0.getPackageName().equals(resolveInfo.activityInfo.packageName) && (bundle = resolveInfo.activityInfo.metaData) != null && (string = bundle.getString("android.speech.DETAILS")) != null) {
                    intent = intent.setClassName(resolveInfo.activityInfo.packageName, string);
                    break loop0;
                }
            }
            i8++;
        }
        if (a8) {
            c1708z0.p("SpeechRecognition Voice details: " + intent);
        }
        ComponentName component = intent.getComponent();
        String packageName = component != null ? component.getPackageName() : null;
        PackageManager packageManager = c1708z0.getPackageManager();
        if (packageName == null || c1708z0.getPackageName().equals(packageName) || (resolveService = packageManager.resolveService(new Intent("android.speech.RecognitionService").setPackage(packageName), 0)) == null) {
            try {
                str = Settings.Secure.getString(c1708z0.getContentResolver(), "voice_recognition_service");
            } catch (SecurityException unused) {
            }
            if (TextUtils.isEmpty(str) || (componentName = ComponentName.unflattenFromString(str)) == null || c1708z0.getPackageName().equals(componentName.getPackageName()) || packageManager.resolveService(new Intent("android.speech.RecognitionService").setComponent(componentName), 0) == null) {
                componentName = 31 <= Build.VERSION.SDK_INT ? new ComponentName("com.google.android.tts", "com.google.android.apps.speech.tts.googletts.service.GoogleTTSRecognitionService") : new ComponentName("com.google.android.googlequicksearchbox", "com.google.android.voicesearch.serviceapi.GoogleRecognitionService");
                if (packageManager.resolveService(new Intent("android.speech.RecognitionService").setComponent(componentName), 0) == null) {
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent("android.speech.RecognitionService"), 0);
                    List<ResolveInfo> emptyList = Collections.emptyList();
                    if (queryIntentServices == null) {
                        queryIntentServices = emptyList;
                    }
                    for (ResolveInfo resolveInfo2 : queryIntentServices) {
                        if (!c1708z0.getPackageName().equals(resolveInfo2.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo2.serviceInfo;
                            componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        }
                    }
                    throw new IllegalStateException("No recognition service found");
                }
            }
        } else {
            ServiceInfo serviceInfo2 = resolveService.serviceInfo;
            componentName = new ComponentName(serviceInfo2.packageName, serviceInfo2.name);
        }
        if (a8) {
            c1708z0.p("SpeechRecognition Recognition service: " + componentName);
        }
        if (f9 && "com.google.android.googlequicksearchbox".equals(componentName.getPackageName())) {
            try {
                if (C2446x.f23433a.compare(c1708z0.getPackageManager().getPackageInfo(componentName.getPackageName(), 0).versionName, "11.23.12") >= 0) {
                    putExtra.removeExtra("android.speech.extra.PREFER_OFFLINE");
                }
            } catch (Exception unused2) {
            }
        }
        a aVar = new a(putExtra, componentName);
        c1708z0.w(aVar);
        aVar.m(2, new IntentFilter());
        c1708z0.sendOrderedBroadcast(intent, null, aVar, c1708z0.j2().f14581L1, -1, null, null);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Bundle bundle;
        ArrayList<String> stringArrayList;
        J3.a aVar = null;
        if (obj == null || (stringArrayList = (bundle = (Bundle) obj).getStringArrayList("results_recognition")) == null || stringArrayList.isEmpty()) {
            J3.l lVar = this.varSpokenTexts;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varConfidenceScores;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        float[] floatArray = bundle.getFloatArray("confidence_scores");
        Object[] array = stringArrayList.toArray();
        J3.a aVar2 = new J3.a(array.length, array);
        if (floatArray != null) {
            Pattern pattern = J3.h.f4650a;
            int length = floatArray.length;
            Object[] objArr = new Object[length];
            int i8 = length;
            while (true) {
                i8--;
                if (i8 < 0) {
                    break;
                }
                objArr[i8] = Double.valueOf(floatArray[i8]);
            }
            aVar = new J3.a(length, objArr);
        }
        J3.l lVar3 = this.varSpokenTexts;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, aVar2);
        }
        J3.l lVar4 = this.varConfidenceScores;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, aVar);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
