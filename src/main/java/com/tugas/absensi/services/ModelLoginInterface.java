package com.tugas.absensi.services;

import java.util.List;

import com.tugas.absensi.entity.LoginAbsensi;

public interface ModelLoginInterface {
	
	public List<LoginAbsensi> getAllLoginAbsensi();
	public String addLogin (LoginAbsensi loginAbsensi);
	public LoginAbsensi getById(String id);
	public String updateLogin(LoginAbsensi loginAbsensi);
	public List<LoginAbsensi> getAllLoginAdminByName(String username);
	public List<LoginAbsensi> updateDAtaKeluar(LoginAbsensi loginAbsensi);
	
	//public String updateTglKeluar(String id, String tglKeluar);
//	public String updateTglMasuk(String id, String tglMasuk);

}
