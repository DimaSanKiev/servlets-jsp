package demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Uploader() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("Nothing uploaded.");
			return;
		}
		
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		
		try {
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem item : items) {
				String contentType = item.getContentType();
				
				if (!contentType.equals("image/png")) {
					out.println("Only PNG image files supported.");
					continue;
				}
				
				File uploadDir = new File("E:\\Dima\\Information\\IT\\MyProjects\\Tutorials\\servlets-jsp\\uploads");
				File file = File.createTempFile("img", ".png", uploadDir);
				
				item.write(file);
				
				out.println("File uploaded.");
			}
		} catch (FileUploadException e) {
			out.println("Upload failed.");
			return;
		} catch (Exception e) {
			out.println("Could not upload file.");
		}
	}

}
