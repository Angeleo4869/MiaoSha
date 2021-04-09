package com.angeleo.sks.wx.service;

import com.angeleo.sks.db.pojo.SksRegion;
import com.angeleo.sks.db.service.SksRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private SksRegionService regionService;

	private static List<SksRegion> litemallRegions;

	protected List<SksRegion> getSksRegions() {
		if(litemallRegions==null){
			createRegion();
		}
		return litemallRegions;
	}

	private synchronized void createRegion(){
		if (litemallRegions == null) {
			litemallRegions = regionService.getAll();
		}
	}
}
