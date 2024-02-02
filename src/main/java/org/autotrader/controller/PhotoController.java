/**
 * 
 */
package org.autotrader.controller;

import java.util.List;

import org.autotrader.model.Annonce;
import org.autotrader.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author miaro
 *
 */
@RestController
@RequestMapping(path="/api/public/")
public class PhotoController {

	@Autowired
	PhotoService photoService;
	
	@PostMapping("photo")
	public ResponseEntity<?> insertPhotos(@RequestParam MultipartFile[] files, Annonce annonce){
		try {
			
			return photoService.savePhotos(files, annonce);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.toString()+" : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
