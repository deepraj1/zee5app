package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.NoDataFoundException;
@Service
public interface WebSeriesService {
	public WebSeries insertWebs(WebSeries series);
	public String updateWebs(String WebsId,WebSeries series );
	public Optional<WebSeries> getWebsByWebsId(String WebsId);
	public Optional<List<WebSeries>> getAllWebs();
	public String deleteWebsByWebsId(String WebsId) throws NoDataFoundException;
	public String[] getCastByWebsName(String WebsName);

}
