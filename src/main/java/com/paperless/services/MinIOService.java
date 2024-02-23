package com.paperless.services;

import com.paperless.misc.RetrievedObject;

public interface MinIOService {
    void createBucket(String bucketName);

    RetrievedObject retrieveObject(String fileName);
}
