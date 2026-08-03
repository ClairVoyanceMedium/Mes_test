package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1708z0;
import java.util.Arrays;
import java.util.Locale;
import w3.n;

@g(1)
/* loaded from: classes.dex */
public final class PhoneFormat extends TernaryFunction {
    public static final String NAME = "phoneFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String spannableStringBuilder;
        String f02 = h.f0(null, this.f4940X.c2(c1708z0));
        if (f02 == null || f02.isEmpty()) {
            return f02;
        }
        String x7 = h.x(c1708z0, this.f4941Y, null);
        if (!"normalize".equalsIgnoreCase(x7)) {
            String x8 = h.x(c1708z0, this.f4942Z, null);
            if (x8 != null) {
                x8 = x8.toUpperCase(Locale.US);
            }
            if (x7 == null || "default".equalsIgnoreCase(x7)) {
                String[] strArr = n.f23254a;
                if (21 <= Build.VERSION.SDK_INT) {
                    spannableStringBuilder = PhoneNumberUtils.formatNumber(f02, x8);
                } else {
                    int formatTypeForLocale = x8 != null ? Arrays.binarySearch(n.f23257d, x8) >= 0 ? 1 : "JP".equals(x8) ? 2 : PhoneNumberUtils.getFormatTypeForLocale(Locale.getDefault()) : 0;
                    if (formatTypeForLocale == 0) {
                        spannableStringBuilder = PhoneNumberUtils.formatNumber(f02);
                    } else {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(f02);
                        PhoneNumberUtils.formatNumber(spannableStringBuilder2, formatTypeForLocale);
                        spannableStringBuilder = spannableStringBuilder2.toString();
                    }
                }
            } else if ("rfc3966".equalsIgnoreCase(x7)) {
                IncapableAndroidVersionException.b(21, "rfc3966 standard");
                spannableStringBuilder = PhoneNumberUtils.formatNumberToRFC3966(f02, x8);
            } else {
                if (!"e164".equalsIgnoreCase(x7)) {
                    throw new IllegalArgumentException("standard");
                }
                IncapableAndroidVersionException.b(23, "e164 standard");
                spannableStringBuilder = PhoneNumberUtils.formatNumberToE164(f02, x8);
            }
            if (spannableStringBuilder == null) {
                return f02;
            }
        } else if (21 <= Build.VERSION.SDK_INT) {
            String[] strArr2 = n.f23254a;
            spannableStringBuilder = PhoneNumberUtils.normalizeNumber(f02);
        } else {
            spannableStringBuilder = n.p(f02);
        }
        return spannableStringBuilder;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
