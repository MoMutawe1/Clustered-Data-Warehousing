<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clustered Data Warehousing project</title>
</head>
<body>
    <div align="center">
        <h1>Clustered Data Warehousing project</h1>
        <form method="post" action="upload" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Pick file:</td>
                    <td><input type="file" name="filedata"  /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload " /></td>
                </tr>
            </table>
        </form>
       <a href="search" >Search file record</a>
    </div>
</body>
</html>