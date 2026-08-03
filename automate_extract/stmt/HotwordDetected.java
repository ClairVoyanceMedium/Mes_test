package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateVoiceInteractionService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.U2;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("hotword_detected.html")
@F3.a(C2541R.integer.ic_voice_search)
@F3.i(C2541R.string.stmt_hotword_detected_title)
@F3.h(C2541R.string.stmt_hotword_detected_summary)
@F3.e(C2541R.layout.stmt_hotword_detected_edit)
/* loaded from: classes.dex */
public final class HotwordDetected extends Action implements AsyncStatement {

    public static final class a extends com.llamalab.automate.W implements U2 {

        /* renamed from: y1, reason: collision with root package name */
        public final AtomicBoolean f16700y1 = new AtomicBoolean();

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            AutomateVoiceInteractionService automateVoiceInteractionService;
            super.C(automateService, j8, j9, j10);
            if (!AutomateVoiceInteractionService.f14646y1.add(this) || (automateVoiceInteractionService = AutomateVoiceInteractionService.f14645L1.get()) == null) {
                return;
            }
            d1(automateVoiceInteractionService);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateVoiceInteractionService automateVoiceInteractionService;
            if (AutomateVoiceInteractionService.f14646y1.remove(this) && (automateVoiceInteractionService = AutomateVoiceInteractionService.f14645L1.get()) != null) {
                b0(automateVoiceInteractionService);
            }
            u2();
        }

        @Override // com.llamalab.automate.U2
        public final void X0(Throwable th) {
            if (this.f16700y1.compareAndSet(true, false)) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.U2
        public final void Y() {
            if (this.f16700y1.compareAndSet(true, false)) {
                q2(null, false);
            }
        }

        @Override // com.llamalab.automate.U2
        public final void b0(AutomateVoiceInteractionService automateVoiceInteractionService) {
            if (this.f16700y1.compareAndSet(true, false)) {
                automateVoiceInteractionService.getClass();
                try {
                    synchronized (automateVoiceInteractionService.f14647X) {
                        int i8 = automateVoiceInteractionService.f14649Z;
                        if (i8 > 0) {
                            int i9 = i8 - 1;
                            automateVoiceInteractionService.f14649Z = i9;
                            if (i9 == 0 && 2 == automateVoiceInteractionService.f14650x0 && !automateVoiceInteractionService.f14648Y.stopRecognition()) {
                                throw new IllegalStateException("stopRecognition failed");
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.e("AutomateVoiceInteractionService", "stopHotwordRecognition failed", th);
                }
            }
        }

        @Override // com.llamalab.automate.U2
        public final void d1(AutomateVoiceInteractionService automateVoiceInteractionService) {
            if (this.f16700y1.compareAndSet(false, true)) {
                automateVoiceInteractionService.getClass();
                try {
                    synchronized (automateVoiceInteractionService.f14647X) {
                        if (automateVoiceInteractionService.f14648Y == null) {
                            automateVoiceInteractionService.f14648Y = automateVoiceInteractionService.createAlwaysOnHotwordDetectorCompat("OK Google", Locale.US, automateVoiceInteractionService.f14651x1);
                        }
                        int i8 = automateVoiceInteractionService.f14649Z + 1;
                        automateVoiceInteractionService.f14649Z = i8;
                        if (i8 == 1) {
                            int i9 = automateVoiceInteractionService.f14650x0;
                            if (i9 == -2) {
                                throw new UnsupportedOperationException("Hotword detection hardware unavailable");
                            }
                            if (i9 == -1) {
                                throw new IllegalStateException("Hotword keyphrase unsupported");
                            }
                            if (i9 != 0) {
                                if (i9 != 1) {
                                    if (i9 != 2) {
                                        throw new IllegalStateException("Unknown availability: " + automateVoiceInteractionService.f14650x0);
                                    }
                                    if (!automateVoiceInteractionService.f14648Y.startRecognition(0)) {
                                        throw new IllegalStateException("startRecognition failed");
                                    }
                                } else {
                                    if (automateVoiceInteractionService.f14652y0) {
                                        throw new IllegalStateException("Hotword keyphrase not enrolled");
                                    }
                                    automateVoiceInteractionService.f14652y0 = true;
                                    Intent createEnrollIntent = automateVoiceInteractionService.f14648Y.createEnrollIntent();
                                    if (30 <= Build.VERSION.SDK_INT) {
                                        automateVoiceInteractionService.startForegroundService(createEnrollIntent);
                                    } else {
                                        automateVoiceInteractionService.startActivity(createEnrollIntent.addFlags(268435456));
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    automateVoiceInteractionService.a(th);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15560u} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_hotword_detected_title);
        IncapableAndroidVersionException.a(23);
        c1708z0.w(new a());
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
