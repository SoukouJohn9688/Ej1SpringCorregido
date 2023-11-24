package com.EjercicioSpring.service;


import com.EjercicioSpring.entities.Noticia;
import com.EjercicioSpring.exceptions.MiException;
import com.EjercicioSpring.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    NoticiaRepository noticiaRepository;


    @Transactional
    public Noticia crearNoticia(String titulo, String cuerpo) throws MiException  {

//        if(id==null){
//            throw new MiException("El id no puede ser nulo");
//        }

//

        if(titulo.isEmpty() || titulo==null){
            throw new MiException("El titulo no puede estar vacio");
        }
        if(cuerpo.isEmpty() || cuerpo==null){
            throw new MiException("El cuerpo no puede estar vacio");
        }

        Noticia noticia = new Noticia();
        noticia.setCuerpo(cuerpo);
        noticia.setTitulo(titulo);

        noticiaRepository.save(noticia);
        return noticia;
    }

    public List<Noticia> listarNoticias() {

        List<Noticia> listaNoticias = new ArrayList<>();
        listaNoticias = noticiaRepository.findAll();
        return listaNoticias;

    }

    public List<Noticia> getListaNoticias(){
        return noticiaRepository.findAll();

    }

    public Optional<Noticia> getListaNoticiasPorID(Long id){
        return noticiaRepository.findById(id);
    }


    public void modificarNoticia(Long id, String titulo, String cuerpo) {

        Optional<Noticia> respuesta = noticiaRepository.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setCuerpo(cuerpo);
            noticia.setTitulo(titulo);

            noticiaRepository.save(noticia);
        }
    }



}
