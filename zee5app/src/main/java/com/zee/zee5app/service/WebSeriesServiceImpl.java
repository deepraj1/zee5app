package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.NoDataFoundException;
//import com.zee.zee5app.repo.WebSeriesRepo;
import com.zee.zee5app.repo.WebsRepository;
@Service
public class WebSeriesServiceImpl implements WebSeriesService {
	@Autowired
	WebsRepository repo;
	@Override
	public WebSeries insertWebs(WebSeries series) {
		// TODO Auto-generated method stub
		return repo.save(series);
	}

	@Override
	public String updateWebs(String WebsId, WebSeries series) {
		// TODO Auto-generated method stub
//		return repo.updateWebs(WebsId, series);
		return null;
	}

	@Override
	public Optional<WebSeries> getWebsByWebsId(String WebsId) {
		// TODO Auto-generated method stub
//		return repo.getWebsByWebsId(WebsId);
		return repo.findById(WebsId);
	}

	@Override
	public Optional<List<WebSeries>> getAllWebs() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public String deleteWebsByWebsId(String WebsId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		try {
			boolean res = repo.existsById(WebsId);
			if(res) {
				repo.deleteById(WebsId);
				return "success";
			}else {
				throw new NoDataFoundException("no webs is present");
			}
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String[] getCastByWebsName(String WebsName) {
		// TODO Auto-generated method stub
//		return repo.getCastByWebsName(WebsName);
		return null;
	}

}
