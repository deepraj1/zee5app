package com.zee.zee5app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.WebSeries;
@Repository
public interface WebsRepository extends JpaRepository<WebSeries, String> {

}
