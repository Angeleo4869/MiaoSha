package com.angeleo.sks.wx.service;

import com.angeleo.sks.db.pojo.SksRegion;
import com.angeleo.sks.db.service.SksRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leo
 */
@Component
public class GetRegionService {

	@Autowired
	private SksRegionService regionService;

	private static List<SksRegion> sksRegions;

	protected List<SksRegion> getSksRegions() {
		if(sksRegions==null){
			createRegion();
		}
		return sksRegions;
	}

	private synchronized void createRegion(){
		if (sksRegions == null) {
			sksRegions = regionService.getAll();
		}
	}
}
