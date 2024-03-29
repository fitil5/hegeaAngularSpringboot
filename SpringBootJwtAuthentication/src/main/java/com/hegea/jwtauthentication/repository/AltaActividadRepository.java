package com.hegea.jwtauthentication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hegea.jwtauthentication.model.Actividad;
import com.hegea.jwtauthentication.model.AltaActividad;
import com.hegea.jwtauthentication.model.AltaActividadCompositeKey;
import com.hegea.jwtauthentication.model.AltaActividadDTO;
import com.hegea.jwtauthentication.services.IActividad;


public interface AltaActividadRepository extends JpaRepository<AltaActividadCompositeKey, AltaActividad>{
	@Query("select new com.hegea.jwtauthentication.model.AltaActividadDTO(f.fecha, f.nombre_act,a.usuario,a.alta) from FechaActividadCompositeKey f left join AltaActividadCompositeKey a ON a.fecha = f.fecha and a.nombre_act = f.nombre_act  and a.usuario=?1 where f.fecha > current_date  order by f.fecha")
	List<AltaActividadDTO> findFechaActividadJoinAltaActividad(String usuario);
	@Query("select aac from AltaActividadCompositeKey aac where aac.fecha =?1 and aac.nombre_act=?2")
	List<AltaActividadCompositeKey> findAllByFechaActividad(Date fecha,String actividad);
	@Query("select aac from AltaActividadCompositeKey aac order by aac.fecha DESC")
	List<AltaActividadCompositeKey> findAllOrderByFecha();

}

	

