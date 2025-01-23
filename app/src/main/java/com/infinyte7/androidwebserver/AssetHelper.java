package com.infinyte7.androidwebserver;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.MimeTypeMap;

import java.io.IOException;
import java.io.InputStream;

public class AssetHelper {
    // Method to get MIME type of an asset using MimeTypeMap
    public static String getMimeTypeForAsset(Context context, String assetPath) {
        // Get the file extension from the assetPath
        String extension = assetPath.substring(assetPath.lastIndexOf(".") + 1);

        // Get the MIME type using MimeTypeMap
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        String mimeType = mime.getMimeTypeFromExtension(extension.toLowerCase());

        return mimeType != null ? mimeType : "application/octet-stream"; // Return default if MIME type is unknown
    }
    public static boolean assetExists(Context context, String assetPath) {
        AssetManager assetManager = context.getAssets();
        try {
            // Try to open the asset
            assetManager.open(assetPath);
            return true;  // If no exception occurs, the asset exists
        } catch (IOException e) {
            // If IOException occurs, asset doesn't exist
            return false;
        }
    }
    public static InputStream openAssetFile(Context context, String filename)  {
        AssetManager assetManager = context.getAssets();
        try {
            // Open a specific asset file
            InputStream inputStream = assetManager.open(filename);
            return inputStream;
            // Process the inputStream (e.g., read data, display image, etc.)
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
