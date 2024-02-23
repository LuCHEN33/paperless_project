package com.paperless.misc;

import java.nio.file.Path;

public record RetrievedObject(Path path, String objectId) {
}
