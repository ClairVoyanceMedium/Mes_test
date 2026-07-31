package n6;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* renamed from: n6.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2180a extends FilterInputStream {

    /* renamed from: X, reason: collision with root package name */
    public final Cipher f21067X;

    /* renamed from: Y, reason: collision with root package name */
    public final byte[] f21068Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f21069Z;

    /* renamed from: x0, reason: collision with root package name */
    public byte[] f21070x0;

    /* renamed from: x1, reason: collision with root package name */
    public int f21071x1;

    /* renamed from: y0, reason: collision with root package name */
    public int f21072y0;

    public C2180a(DataInputStream dataInputStream, Cipher cipher) {
        super(dataInputStream);
        this.f21068Y = new byte[512];
        this.f21069Z = false;
        this.f21067X = cipher;
    }

    public final byte[] a() {
        try {
            if (this.f21069Z) {
                return null;
            }
            this.f21069Z = true;
            return this.f21067X.doFinal();
        } catch (GeneralSecurityException e8) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e8);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return this.f21072y0 - this.f21071x1;
    }

    public final int b() {
        if (this.f21069Z) {
            return -1;
        }
        this.f21071x1 = 0;
        this.f21072y0 = 0;
        while (true) {
            int i8 = this.f21072y0;
            if (i8 != 0) {
                return i8;
            }
            int read = ((FilterInputStream) this).in.read(this.f21068Y);
            if (read == -1) {
                byte[] a8 = a();
                this.f21070x0 = a8;
                if (a8 == null || a8.length == 0) {
                    return -1;
                }
                int length = a8.length;
                this.f21072y0 = length;
                return length;
            }
            byte[] update = this.f21067X.update(this.f21068Y, 0, read);
            this.f21070x0 = update;
            if (update != null) {
                this.f21072y0 = update.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ((FilterInputStream) this).in.close();
            this.f21071x1 = 0;
            this.f21072y0 = 0;
        } finally {
            if (!this.f21069Z) {
                a();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i8) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (this.f21071x1 >= this.f21072y0 && b() < 0) {
            return -1;
        }
        byte[] bArr = this.f21070x0;
        int i8 = this.f21071x1;
        this.f21071x1 = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j8) {
        if (j8 <= 0) {
            return 0L;
        }
        int min = (int) Math.min(j8, this.f21072y0 - this.f21071x1);
        this.f21071x1 += min;
        return min;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i8, int i9) {
        if (this.f21071x1 >= this.f21072y0 && b() < 0) {
            return -1;
        }
        int min = Math.min(i9, this.f21072y0 - this.f21071x1);
        System.arraycopy(this.f21070x0, this.f21071x1, bArr, i8, min);
        this.f21071x1 += min;
        return min;
    }
}
