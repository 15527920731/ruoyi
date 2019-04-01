package com.jewelry.system.mapper;

import com.jewelry.system.domain.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图片管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-27
 */
public interface ImageMapper 
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
     * 删除图片管理
     * 
     * @param id 图片管理ID
     * @return 结果
     */
	public int deleteImageById(Long id);
	
	/**
     * 批量删除图片管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteImageByIds(String[] ids);

	public String[] selectImageURL(@Param("huoHao") String huoHao);
}