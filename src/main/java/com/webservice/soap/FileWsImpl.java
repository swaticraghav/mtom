package com.webservice.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachement) {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		// read the file
		try {
			inputStream = attachement.getInputStream();
			outputStream = new FileOutputStream(
					new File("C:/Users/swaragha/Desktop/Training/1. API/donloadsAndUploads/Upload.jpg"));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public DataHandler download() {

		return new DataHandler(
				new FileDataSource(new File("C:/Users/swaragha/Desktop/Training/1. API/donloadsAndUploads/Upload.jpg")));
	}

}
