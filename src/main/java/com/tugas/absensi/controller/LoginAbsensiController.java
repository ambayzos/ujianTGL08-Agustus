package com.tugas.absensi.controller;

import java.io.IOException;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.tugas.absensi.entity.LoginAbsensi;
import com.tugas.absensi.repository.LoginAbsenRepository;
import com.tugas.absensi.services.ModelLoginAbsensi;
import com.tugas.absensi.utility.FileUtility;


@RestController
@RequestMapping("/loginabsensi")
public class LoginAbsensiController {
	@Autowired ModelLoginAbsensi modelLogin;
	@Autowired LoginAbsenRepository loginRepo;
	
	@GetMapping("/")
	public ResponseEntity<List<LoginAbsensi>> getAll(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(this.modelLogin.getAllLoginAbsensi());
	}
	
	@PostMapping("/add")
	public String addLogin(@RequestParam(value="file") MultipartFile images, @ModelAttribute(value = "data") String dataJson)throws IOException{
		
		String filename = StringUtils.cleanPath(images.getOriginalFilename());
		Date tanggalMasuk = new Date();
		Date tanggalKeluar = new Date();
		
		
		
		String uploadDir ="src/main/java/user-photos/";
		FileUtility.saveFile(uploadDir, filename, images);
		LoginAbsensi loginAbsensi = new Gson().fromJson(dataJson, LoginAbsensi.class);
		
		
		loginAbsensi.setImage_url(filename);
		loginAbsensi.setTglMasuk(tanggalMasuk.toString());
		loginAbsensi.setTglKeluar(tanggalKeluar.toString());
		
		return this.modelLogin.addLogin(loginAbsensi);
	}
	
	@GetMapping("/id/{id}")
	public LoginAbsensi getDataById(@PathVariable String id) {
		return this.modelLogin.getById(id);
		
	}
	
//	@GetMapping("/username/{username}")
//	public String getDataByName(@PathVariable String username,  @ModelAttribute(value="data") String dataJson){
//		List<LoginAbsensi> log = modelLogin.getAllLoginAdminByName(username);
//		//LoginAbsensi logi = new LoginAbsensi();
//		//logi.setUsername(username);
//		
//		LoginAbsensi loginAbsensi = new Gson().fromJson(dataJson, LoginAbsensi.class);
//		loginAbsensi.setUsername(username);
//		
//		
//		
//		return this.modelLogin.updateLogin(loginAbsensi);
//		
		
		
//	}
	
	
	
	

}
