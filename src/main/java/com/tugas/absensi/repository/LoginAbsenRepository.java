package com.tugas.absensi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tugas.absensi.entity.LoginAbsensi;

public interface LoginAbsenRepository extends JpaRepository<LoginAbsensi, Long> {
	@Query("select u from LoginAbsensi u where u.username = :username")
	List<LoginAbsensi> findByName(String username);
	
//	@Modifying
//	@Query("update LogiAbsensi u set u.tglKeluar = :tglKeluar where u.id = :id")
//	public LoginAbsensi updateTglKeluar (@Param(value = "id") Long id, @Param(value = "tglKeluar") String tglKeluar);
//	
//	@Modifying
//	@Query("update LogiAbsensi u set u.tglMasuk = :tglMasuk where u.id = :id")
//	public LoginAbsensi updateTglMasuk(@Param(value = "id") Long id, @Param(value = "tglMasuk") String tglMasuk);

}
