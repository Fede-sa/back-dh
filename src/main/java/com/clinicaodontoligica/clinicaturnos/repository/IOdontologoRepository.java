package com.clinicaodontoligica.clinicaturnos.repository;

import com.clinicaodontoligica.clinicaturnos.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository <Odontologo, Long>{
}

