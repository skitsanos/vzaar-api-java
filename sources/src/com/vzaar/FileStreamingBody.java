package com.vzaar;

import org.apache.http.entity.mime.content.InputStreamBody;

import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamingBody extends InputStreamBody {
    private final long contentLength;
    private final int bufferSize;

    public FileStreamingBody(InputStream in, String filename, final long contentLength, int bufferSize) {
        super(in, filename);
        this.contentLength = contentLength;
        this.bufferSize = bufferSize;
    }

    @Override
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public void writeTo(OutputStream out) throws java.io.IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] tmp = new byte[bufferSize];
            int l;
            while ((l = this.getInputStream().read(tmp)) != -1) {
                 out.write(tmp, 0, l);
            }
            out.flush();
        } finally {
            this.getInputStream().close();
        }
    }


}
