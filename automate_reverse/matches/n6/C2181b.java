package n6;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* renamed from: n6.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2181b extends FilterOutputStream {

    /* renamed from: X, reason: collision with root package name */
    public final Cipher f21073X;

    /* renamed from: Y, reason: collision with root package name */
    public final byte[] f21074Y;

    public C2181b(DataOutputStream dataOutputStream, Cipher cipher) {
        super(dataOutputStream);
        this.f21074Y = new byte[1];
        this.f21073X = cipher;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:0|(4:1|2|(1:4)|6)|7|8|(1:10)(1:12)) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() {
        IOException iOException;
        IOException iOException2;
        try {
            byte[] doFinal = this.f21073X.doFinal();
            if (doFinal != null) {
                ((FilterOutputStream) this).out.write(doFinal);
            }
            iOException2 = null;
        } catch (GeneralSecurityException e8) {
            iOException = new InvalidCipherTextIOException("Error during cipher finalisation", e8);
            iOException2 = iOException;
            flush();
            ((FilterOutputStream) this).out.close();
            if (iOException2 != null) {
            }
        } catch (Exception e9) {
            iOException = new IOException("Error closing stream: " + e9);
            iOException2 = iOException;
            flush();
            ((FilterOutputStream) this).out.close();
            if (iOException2 != null) {
            }
        }
        flush();
        ((FilterOutputStream) this).out.close();
        if (iOException2 != null) {
            throw iOException2;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i8) {
        byte[] bArr = this.f21074Y;
        bArr[0] = (byte) i8;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i8, int i9) {
        byte[] update = this.f21073X.update(bArr, i8, i9);
        if (update != null) {
            ((FilterOutputStream) this).out.write(update);
        }
    }
}
