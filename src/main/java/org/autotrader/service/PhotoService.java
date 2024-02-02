/**
 * 
 */
package org.autotrader.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.autotrader.model.Annonce;
import org.autotrader.model.Photo;
import org.autotrader.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import org.springframework.util.StringUtils;

/**
 * @author miaro
 *
 */
@Service
public class PhotoService {

	String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/gs://autotrader-4c574.appspot.com/o/%s?alt=media";
	@Autowired
	PhotoRepository photoRepository;
	
	public ResponseEntity<?> savePhotos(MultipartFile[] files/*, Annonce annonce*/)throws Exception{
		
		File[] fileStock = this.convertToFiles(files);
		
		for(File file : fileStock) {
			System.out.println(this.upload(file));
		}
		
		return new ResponseEntity<String>("Insertion avec success", HttpStatus.OK);
	}
	
	public String upload(File file)throws Exception{
		String result = "";
		BlobId blobId = BlobId.of("autotrader-4c574.appspot.com", file.getName());
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
		
		InputStream jsonkeyfile = this.getClass().getClassLoader().getResourceAsStream("json_key.json");
		
		Credentials credentials = GoogleCredentials.fromStream(jsonkeyfile);
		Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
		storage.create(blobInfo, Files.readAllBytes(file.toPath()));
		
		String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/autotrader-4c574.appspot.com/o/%s?alt=media";
		result = String.format(DOWNLOAD_URL, URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
		return result;
	}
	
//	public ResponseEntity<List<Photo>> getPhotos()throws Exception{
//		List<Photo> photos = new ArrayList<>();
//		photoRepository.findAll().forEach(photos::add);
//		
//		return new ResponseEntity<>(photos, HttpStatus.OK);
//	}
	
	/**
	 * Convert Multipart[] from imports to File[] and return the array of file
	 * @param multiparts
	 * @return
	 * @throws Exception
	 */
	public File[] convertToFiles(MultipartFile[] multiparts)throws Exception{
		List<File> files = new ArrayList<>();
		
		for(MultipartFile multipart : multiparts) {
			files.add(this.convert(multipart));
		}
		
		return files.toArray(new File[multiparts.length]);
	}
	
	/**
	 * Convert a Multipart to a File object and return it File
	 * @param multipart
	 * @return
	 * @throws Exception
	 */
	public File convert(MultipartFile multipart)throws Exception{
		File file = new File(multipart.getOriginalFilename());
		
		try (FileOutputStream fos = new FileOutputStream(file)){
			
			fos.write(multipart.getBytes());
			
		} catch (Exception e) {
			throw new Exception ("Cannot convert multipart to file : \n"+e.toString()+"\n"+e.getMessage()+"\n"+e.getCause());
		}
				
		return file;
	}
}
