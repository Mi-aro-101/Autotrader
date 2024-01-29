/**
 * 
 */
package org.autotrader.service;

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

import org.springframework.util.StringUtils;

/**
 * @author miaro
 *
 */
@Service
public class PhotoService {

	@Autowired
	PhotoRepository photoRepository;
	
	public ResponseEntity<?> savePhotos(MultipartFile[] files, Annonce annonce)throws Exception{
		
		List<Photo> photos = new ArrayList<>();
		
		for(MultipartFile file : files) {
			Photo photo = new Photo();
			photo.setName(StringUtils.cleanPath(file.getOriginalFilename()));
			photo.setContentType(file.getContentType());
			photo.setData(file.getBytes());
			photo.setSize(file.getSize());
			photo.setAnnonce(annonce);
			
			photos.add(photo);
		}
		
		photoRepository.saveAll(photos);
		
		return new ResponseEntity<String>("Insertion avec success", HttpStatus.OK);
	}
	
	public ResponseEntity<List<Photo>> getPhotos()throws Exception{
		List<Photo> photos = new ArrayList<>();
		photoRepository.findAll().forEach(photos::add);
		
		return new ResponseEntity<>(photos, HttpStatus.OK);
	}	
}
