package com.llamalab.automate.stmt;

import J3.e;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ChoiceDialogActivity;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.NoSuchElementException;
import x3.C2440r;

@F3.f("dialog_choice.html")
@F3.a(C2541R.integer.ic_dialog_choice)
@F3.i(C2541R.string.stmt_dialog_choice_title)
@F3.h(C2541R.string.stmt_dialog_choice_summary)
@F3.e(C2541R.layout.stmt_dialog_choice_edit)
/* loaded from: classes.dex */
public final class DialogChoice extends ActivityDecision implements InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f16583L1 = -1;
    public InterfaceC1700x0 choiceDescriptions;
    public InterfaceC1700x0 choiceTitles;
    public InterfaceC1700x0 multiselect;
    public InterfaceC1700x0 noselect;
    public InterfaceC1700x0 preselected;
    public InterfaceC1700x0 sort;
    public InterfaceC1700x0 title;
    public J3.l varSelectedIndices;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dialog_choice);
        l8.v(this.title, 0);
        l8.v(this.choiceTitles, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.choiceTitles);
        if (107 <= dVar.f6413Z) {
            dVar.g(this.choiceDescriptions);
        }
        dVar.g(this.multiselect);
        if (60 <= dVar.f6413Z) {
            dVar.g(this.noselect);
        }
        if (36 <= dVar.f6413Z) {
            dVar.g(this.preselected);
        }
        dVar.g(this.sort);
        dVar.g(this.varSelectedIndices);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.choiceTitles);
        visitor.b(this.choiceDescriptions);
        visitor.b(this.multiselect);
        visitor.b(this.noselect);
        visitor.b(this.preselected);
        visitor.b(this.sort);
        visitor.b(this.varSelectedIndices);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16583L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.choiceTitles = (InterfaceC1700x0) cVar.readObject();
        if (107 <= cVar.f6409x0) {
            this.choiceDescriptions = (InterfaceC1700x0) cVar.readObject();
        }
        this.multiselect = (InterfaceC1700x0) cVar.readObject();
        if (60 <= cVar.f6409x0) {
            this.noselect = (InterfaceC1700x0) cVar.readObject();
        }
        if (36 <= cVar.f6409x0) {
            this.preselected = (InterfaceC1700x0) cVar.readObject();
        }
        this.sort = (InterfaceC1700x0) cVar.readObject();
        this.varSelectedIndices = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        boolean z7;
        J3.a aVar;
        if (-1 != i8) {
            c1708z0.z(this.f16583L1, null);
            J3.l lVar = this.varSelectedIndices;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            z7 = false;
        } else {
            if (this.varSelectedIndices != null) {
                int[] intArrayExtra = intent.getIntArrayExtra("com.llamalab.automate.intent.extra.SELECTED");
                if (intArrayExtra != null) {
                    String[] strArr = (String[]) c1708z0.j(this.f16583L1);
                    if (strArr != null) {
                        int length = intArrayExtra.length;
                        aVar = new J3.a(length);
                        while (true) {
                            length--;
                            if (length < 0) {
                                break;
                            }
                            String str = strArr[intArrayExtra[length]];
                            int i9 = y4.j.i(length, aVar.f4627Y);
                            int i10 = i9 + 1;
                            aVar.j(i10);
                            aVar.f4626X[i9] = str;
                            if (aVar.f4627Y <= i9) {
                                aVar.f4627Y = i10;
                            }
                        }
                    } else {
                        aVar = J3.h.H(intArrayExtra);
                    }
                } else {
                    aVar = new J3.a();
                }
                c1708z0.z(this.varSelectedIndices.f4659Y, aVar);
            }
            c1708z0.z(this.f16583L1, null);
            z7 = true;
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int[] iArr;
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2;
        String[] strArr;
        int[] iArr2;
        CharSequence charSequence;
        String[] strArr2;
        c1708z0.q(C2541R.string.stmt_dialog_choice_title);
        int[] iArr3 = null;
        String x7 = J3.h.x(c1708z0, this.title, null);
        Object u8 = J3.h.u(c1708z0, this.choiceTitles, null);
        Object u9 = J3.h.u(c1708z0, this.choiceDescriptions, null);
        J3.a e8 = J3.h.e(c1708z0, this.preselected);
        boolean f8 = J3.h.f(c1708z0, this.multiselect, false);
        boolean f9 = J3.h.f(c1708z0, this.noselect, false);
        boolean f10 = J3.h.f(c1708z0, this.sort, true);
        if (u8 instanceof J3.e) {
            J3.e eVar = (J3.e) u8;
            J3.e eVar2 = u9 instanceof J3.e ? (J3.e) u9 : null;
            if (e8 != null) {
                Object[] i02 = J3.h.i0(e8);
                int length = i02.length;
                if (length > 1) {
                    Arrays.sort(i02);
                    Object obj = i02[0];
                    int i8 = 1;
                    int i9 = 1;
                    while (i9 < length) {
                        int i10 = i9 + 1;
                        Object obj2 = i02[i9];
                        if (!C2440r.h(obj2, obj)) {
                            i02[i8] = obj2;
                            i8++;
                            obj = obj2;
                        }
                        i9 = i10;
                    }
                    if (i8 != length) {
                        i02 = Arrays.copyOf(i02, i8);
                    }
                }
                strArr2 = (String[]) i02;
            } else {
                strArr2 = null;
            }
            int i11 = eVar.f4641x1;
            String[] strArr3 = new String[i11];
            CharSequence[] charSequenceArr3 = new CharSequence[i11];
            CharSequence[] charSequenceArr4 = eVar2 != null ? new CharSequence[i11] : null;
            int[] iArr4 = strArr2 != null ? new int[strArr2.length] : null;
            C1231k c1231k = (C1231k) eVar.f9362Z;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (!(c1231k != eVar)) {
                    String[] strArr4 = strArr3;
                    charSequenceArr2 = charSequenceArr4;
                    iArr = i12 == 0 ? iArr3 : i12 != iArr4.length ? Arrays.copyOf(iArr4, i12) : iArr4;
                    charSequenceArr = charSequenceArr3;
                    strArr = strArr4;
                } else {
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    e.a aVar = (e.a) c1231k;
                    String str = aVar.f4645y0;
                    strArr3[i13] = str;
                    String[] strArr5 = strArr3;
                    charSequenceArr3[i13] = J3.h.f0(null, aVar.f4644x1);
                    if (charSequenceArr4 != null) {
                        charSequenceArr4[i13] = J3.h.f0(null, eVar2.j0(str));
                    }
                    if (iArr4 != null && Arrays.binarySearch(strArr2, str) >= 0) {
                        iArr4[i12] = i13;
                        i12++;
                    }
                    i13++;
                    iArr3 = null;
                    c1231k = c1231k2;
                    strArr3 = strArr5;
                }
            }
        } else {
            iArr = null;
            if (u8 instanceof J3.a) {
                CharSequence[] M7 = J3.h.M((J3.a) u8);
                CharSequence[] M8 = u9 instanceof J3.a ? J3.h.M((J3.a) u9) : null;
                if (e8 != null) {
                    int length2 = M7.length;
                    int i14 = e8.f4627Y;
                    iArr2 = new int[i14];
                    while (true) {
                        i14--;
                        if (i14 < 0) {
                            break;
                        }
                        iArr2[i14] = y4.j.i(J3.h.R(e8.get(i14)), length2);
                    }
                } else {
                    iArr2 = null;
                }
                charSequenceArr2 = M8;
                charSequenceArr = M7;
                iArr = iArr2;
                strArr = null;
            } else if (u8 != null) {
                charSequenceArr = new CharSequence[]{J3.h.e0(u8)};
                charSequenceArr2 = u9 != null ? new CharSequence[]{J3.h.e0(u9)} : null;
                if (e8 != null) {
                    int i15 = e8.f4627Y;
                    int[] iArr5 = new int[i15];
                    while (true) {
                        i15--;
                        if (i15 < 0) {
                            break;
                        }
                        iArr5[i15] = y4.j.i(J3.h.R(e8.get(i15)), 1);
                    }
                    strArr = null;
                    iArr = iArr5;
                } else {
                    strArr = null;
                }
            } else {
                charSequenceArr = null;
                charSequenceArr2 = null;
                strArr = null;
            }
        }
        Intent putExtra = new Intent(c1708z0, (Class<?>) ChoiceDialogActivity.class).putExtra("com.llamalab.automate.intent.extra.CHOICE_TITLES", charSequenceArr).putExtra("com.llamalab.automate.intent.extra.CHOICE_SUMMARIES", charSequenceArr2).putExtra("com.llamalab.automate.intent.extra.SELECTED", iArr).putExtra("com.llamalab.automate.intent.extra.MULTI_SELECT", f8).putExtra("com.llamalab.automate.intent.extra.ALLOW_NO_SELECTION", f9).putExtra("com.llamalab.automate.intent.extra.SORT", f10);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_dialog_choice_title);
        } else {
            putExtra.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        c1708z0.B(putExtra, null, B(c1708z0), z(c1708z0), c1708z0.f(C2541R.integer.ic_dialog_choice), charSequence, c1708z0.s(this));
        c1708z0.z(this.f16583L1, strArr);
        return false;
    }
}
