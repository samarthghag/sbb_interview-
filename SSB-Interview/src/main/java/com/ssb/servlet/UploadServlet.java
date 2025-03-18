package com.ssb.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads"; // Change this based on your server setup

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process each file upload
        processFileUpload(request, "photo");
        processFileUpload(request, "marksheet10");
        processFileUpload(request, "marksheet12");

        response.getWriter().println("Files uploaded successfully. Please wait for an email with further details.");
    }

    private void processFileUpload(HttpServletRequest request, String fieldName) throws IOException, ServletException {
        Part filePart = request.getPart(fieldName); // Get file part

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = extractFileName(filePart);
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Create directory if it doesn't exist
            }

            File file = new File(uploadPath + File.separator + fileName);

            try (InputStream fileContent = filePart.getInputStream();
                 FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        } else {
            System.err.println("No file uploaded for " + fieldName);
        }
    }

    private String extractFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "unknown";
    }
}
