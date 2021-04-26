package com.angeleo.sks.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.admin.vo.RegionVo;
import com.angeleo.sks.core.util.ResponseUtil;
import com.angeleo.sks.db.pojo.SksRegion;
import com.angeleo.sks.db.service.SksRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private SksRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<SksRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<SksRegion> litemallRegions = regionService.getAll();
        Map<Byte, List<SksRegion>> collect = litemallRegions.stream().collect(Collectors.groupingBy(SksRegion::getType));
        byte provinceType = 1;
        List<SksRegion> provinceList = collect.get(provinceType);
        byte cityType = 2;
        List<SksRegion> city = collect.get(cityType);
        Map<Integer, List<SksRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(SksRegion::getPid));
        byte areaType = 3;
        List<SksRegion> areas = collect.get(areaType);
        Map<Integer, List<SksRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(SksRegion::getPid));

        for (SksRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<SksRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (SksRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(cityVo.getId());
                cityVO.setName(cityVo.getName());
                cityVO.setCode(cityVo.getCode());
                cityVO.setType(cityVo.getType());

                List<SksRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (SksRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
