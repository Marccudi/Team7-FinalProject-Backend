package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IPlatformDAO;
import com.c6.replay.dto.Platform;
import com.c6.replay.dto.Platform;

@Service
public class PlatformServiceImpl implements IPlatformService{
	@Autowired
	IPlatformDAO platformDAO;
	
	@Override
	public List<Platform> listPlatforms() {
		// TODO Auto-generated method stub
		return platformDAO.findAll();
	}

	@Override
	public Platform savePlatform(Platform platform) {
		// TODO Auto-generated method stub
		return platformDAO.save(platform);
	}

	@Override
	public Platform platformXID(int id) {
		// TODO Auto-generated method stub
		return platformDAO.findById(id).get();
	}

	@Override
	public Platform updatePlatform(Platform platform) {
		// TODO Auto-generated method stub
		return  platformDAO.save(platform);
	}

	@Override
	public void deletePlatform(int id) {
		// TODO Auto-generated method stub
		platformDAO.deleteById(id);
	}
}
