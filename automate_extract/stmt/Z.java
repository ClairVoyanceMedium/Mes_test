package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.security.KeyChain;
import android.view.View;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import j3.C2009e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import x3.AbstractDialogInterfaceOnCancelListenerC2432j;
import x3.C2434l;

/* loaded from: classes.dex */
public class Z extends C2 implements View.OnClickListener {

    /* renamed from: y1, reason: collision with root package name */
    public AsyncTask<?, ?, ?> f17326y1;

    public final class a extends AbstractDialogInterfaceOnCancelListenerC2432j<String, Intent, Object[]> {

        /* renamed from: Z, reason: collision with root package name */
        public final char[] f17327Z;

        public a() {
            if (16 <= Build.VERSION.SDK_INT) {
                this.f17327Z = C2434l.f23391b;
            } else {
                this.f17327Z = "automate".toCharArray();
            }
        }

        @Override // x3.AbstractAsyncTaskC2447y
        public final void c(Object obj) {
            Object[] objArr = (Object[]) obj;
            try {
                Z.this.startActivityForResult(KeyChain.createInstallIntent().putExtra(MicrosoftClient.PROP_NAME, (String) objArr[0]).putExtra("PKCS12", (byte[]) objArr[1]), 1);
            } catch (Throwable unused) {
            }
        }

        @Override // x3.AbstractAsyncTaskC2447y
        public final Object d(Object[] objArr) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair genKeyPair = keyPairGenerator.genKeyPair();
            a();
            X509Certificate a8 = com.llamalab.automate.C.a(genKeyPair, Z.this.requireContext().getString(C2541R.string.dn_adb_cert));
            a();
            byte[] b8 = C2009e.b((RSAPublicKey) genKeyPair.getPublic());
            S5.i iVar = new S5.i();
            iVar.update(b8, 0, b8.length);
            byte[] bArr = new byte[16];
            iVar.c(bArr, 0);
            String concat = "adb-".concat(V3.b.h(bArr, 16, V3.b.f6989c));
            PrivateKey privateKey = genKeyPair.getPrivate();
            Certificate[] certificateArr = {a8};
            char[] cArr = this.f17327Z;
            try {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                keyStore.load(null);
                keyStore.setEntry(concat, new KeyStore.PrivateKeyEntry(privateKey, certificateArr), new KeyStore.PasswordProtection(cArr));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                keyStore.store(byteArrayOutputStream, cArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a();
                return new Object[]{concat, byteArray};
            } catch (IOException e8) {
                throw new GeneralSecurityException(e8);
            }
        }

        @Override // x3.AbstractDialogInterfaceOnCancelListenerC2432j, x3.AbstractAsyncTaskC2447y, android.os.AsyncTask
        public final void onPostExecute(Object obj) {
            super.onPostExecute((Object[]) obj);
            Z.this.f17326y1 = null;
        }

        @Override // android.os.AsyncTask
        public final void onPreExecute() {
            Context requireContext = Z.this.requireContext();
            String string = requireContext.getString(C2541R.string.dialog_generating);
            char[] cArr = this.f17327Z;
            if (cArr != null && cArr.length != 0) {
                StringBuilder p8 = C1.H0.p(string, "\n");
                p8.append(requireContext.getString(C2541R.string.format_use_password, new String(cArr)));
                string = p8.toString();
            }
            g(requireContext, null, string, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2541R.id.install_key && this.f17326y1 == null) {
            this.f17326y1 = new a().execute(new String[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        AsyncTask<?, ?, ?> asyncTask = this.f17326y1;
        if (asyncTask != null) {
            asyncTask.cancel(false);
        }
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(C2541R.id.install_key).setOnClickListener(this);
    }
}
