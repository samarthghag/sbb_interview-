<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Documents</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Upload Your Documents</h2>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
           <label for="photo">Upload Photo:</label>
    <input type="file" name="photo" required>
    <br><br>
    <label for="marksheet10">Upload 10th Marksheet:</label>
    <input type="file" name="marksheet10" required>
    <br><br>
    <label for="marksheet12">Upload 12th Marksheet:</label>
    <input type="file" name="marksheet12" required>
    <br><br>
    <button type="submit">Upload</button>
        </form>
    </div>
</body>
</html>