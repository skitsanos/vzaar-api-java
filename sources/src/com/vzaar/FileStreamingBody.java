package com.vzaar;

import org.apache.http.entity.mime.content.InputStreamBody;

import java.io.InputStream;

public class FileStreamingBody extends InputStreamBody {
    private final long contentLength;

    public FileStreamingBody(InputStream in, String filename, final long contentLength) {
        super(in, filename);
        this.contentLength = contentLength;
    }

    @Override
    public long getContentLength() {
        return contentLength;
    }


}
