package com.jewelry.system.service;

import com.jewelry.system.domain.Image;
import java.util.List;

/**
 * 图片管理 服务层
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
public interface IImageService 
{
	/**
     * 查询图片管理信息
     * 
     * @param id 图片管理ID
     * @return 图片管理信息
     */
	public Image selectImageById(Long id);
	
	/**
     * 查询图片管理列表
     * 
     * @param image 图片管理信息
     * @return 图片管理集合
     */
	public List<Image> selectImageList(Image image);
	
	/**
     * 新增图片管理
     * 
     * @param image 图片管理信息
     * @return 结果
     */
	public int insertImage(Image image);
	
	/**
     * 修改图片管理
     * 
     * @param image 图片管理信息
     * @return 结果
     */
	public int updateImage(Image image);
		
	/**
     * 删除图片管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteImageByIds(String ids);
	
}
