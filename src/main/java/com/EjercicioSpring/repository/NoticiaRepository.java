package com.EjercicioSpring.repository;

import com.EjercicioSpring.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository  extends JpaRepository<Noticia,Long> {

    @Query("SELECT n FROM Noticia n Where n.titulo=:titulo")
    public Noticia buscarPorTitulo(@Param("titulo") String titulo);





}
