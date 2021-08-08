package com.tugas.absensi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas.absensi.entity.LoginAbsensi;
import com.tugas.absensi.repository.LoginAbsenRepository;

@Service
public class ModelLoginAbsensi implements ModelLoginInterface {
	
	
	@Autowired LoginAbsenRepository loginRepo;

	@Override
	public String addLogin(LoginAbsensi loginAbsensi) {
		// TODO Auto-generated method stub
		this.loginRepo.save(loginAbsensi);
		return "sukses";
	}

	@Override
	public List<LoginAbsensi> getAllLoginAbsensi() {
		// TODO Auto-generated method stub
		return this.loginRepo.findAll();
	}

	@Override
	public LoginAbsensi getById(String id) {
		// TODO Auto-generated method stub
		return this.loginRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public String updateLogin(LoginAbsensi loginAbsensi) {
		// TODO Auto-generated method stub
		this.loginRepo.save(loginAbsensi);
		return "berhasil update";
	}

	

	@Override
	public List<LoginAbsensi> updateDAtaKeluar(LoginAbsensi loginAbsensi) {
		// TODO Auto-generated method stub
		return (List<LoginAbsensi>) this.loginRepo.save(loginAbsensi);
	}

	@Override
	public List<LoginAbsensi> getAllLoginAdminByName(String username) {
		// TODO Auto-generated method stub
		return this.loginRepo.findByName(username);
	}

	

	

//	@Override
//	public String updateTglKeluar(String id, String tglKeluar) {
//		// TODO Auto-generated method stub
//		this.loginRepo.updateTglKeluar(Long.parseLong(id), tglKeluar);
//		return "yes";
//	}
//
//	@Override
//	public String updateTglMasuk(String id, String tglMasuk) {
//		// TODO Auto-generated method stub
//		this.loginRepo.updateTglMasuk(Long.parseLong(id), tglMasuk);
//		return "yes";
//	}

	
	

	

	

	
	

	
}
