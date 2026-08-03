package com.llamalab.automate.stmt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.ActivityC1261p;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import x3.C2440r;

/* loaded from: classes.dex */
public class r extends C2 implements View.OnClickListener {

    /* renamed from: y1, reason: collision with root package name */
    public TextView f17510y1;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.device) {
            return;
        }
        ActivityC1261p o6 = o();
        ClipboardManager clipboardManager = (ClipboardManager) o6.getSystemService("clipboard");
        CharSequence text = o6.getText(C2541R.string.label_device_this);
        clipboardManager.setPrimaryClip(ClipData.newPlainText(text, this.f17510y1.getText()));
        Toast.makeText(o6, o6.getString(C2541R.string.toast_copied_to_clipboard, text), 0).show();
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(C2541R.id.device);
        this.f17510y1 = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
            this.f17510y1.setText(C2440r.q());
        }
    }
}
