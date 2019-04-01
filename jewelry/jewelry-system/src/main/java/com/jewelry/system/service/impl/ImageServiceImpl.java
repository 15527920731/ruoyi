package com.jewelry.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jewelry.system.mapper.ImageMapper;
import com.jewelry.system.domain.Image;
import com.jewelry.system.service.IImageService;
import com.jewelry.common.support.Convert;

/**
 * 图片管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
@Service
public class ImageServiceImpl implements IImageService 
{
	@Autowired
	private ImageMapper imageMapper;

	/**
     * 查询图片管理信息
     * 
     * @param id 图片管理ID
     * @return 图片管理信息
     */
    @Override
	public Image selectImageById(Long id)
	{
	    return imageMapper.selectImageById(id);
	}
	
	/**
     * 查询图片管理列表
     * 
     * @param image 图片管理信息
     * @return 图片管理集合
     */
	@Override
	public List<Image> selectImageList(Image image)
	{
	    return imageMapper.selectImageList(image);
	}
	
    /**
     * 新增图片管理
     * 
     * @param image 图片管理信息
     * @return 结果
     */
	@Override
	public int insertImage(Image image)
	{
	    return imageMapper.insertImage(image);
	}
	
	/**
     * 修改图片管理
     * 
     * @param image 图片管理信息
     * @return 结果
     */
	@Override
	public int updateImage(Image image)
	{
	    return imageMapper.updateImage(image);
	}

	/**
     * 删除图片管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteImageByIds(String ids)
	{
		return imageMapper.deleteImageByIds(Convert.toStrArray(ids));
	}
	
}
