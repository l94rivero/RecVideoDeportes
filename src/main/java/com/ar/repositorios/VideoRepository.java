package com.ar.repositorios;

import com.ar.entidades.Video;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

    @Query("SELECT v from Video v WHERE v.title = :title")
    public Video findByTitle(@Param("title") String tile);

    @Query("SELECT v from Video v WHERE v.date = :date")
    public Video findByDate(@Param("date") String date);

}
