package com.exame.spotfree.repositorys;

import com.exame.spotfree.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {

    boolean existsByTitle(String title);
}
